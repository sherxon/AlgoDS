package amazon;

import java.util.*;

/**
 * @author Sherali Obidov.
 */
public class AmazonMovie {

    public Set<Movie> getMovieRecommendations (Movie movie, int N) {
        Set<Movie> set= new HashSet<>();
        if(N==0 || movie==null)return set;

        PriorityQueue<Movie> pq= new PriorityQueue<>((a, b)->{
            float k=a.getRating()-b.getRating();
            if(k<0)return 1;
            else if(k>0)return -1;
            return 0;
        });

        bfs(movie, pq);

        if(N>=pq.size()){
            set.addAll(pq);
            return set;
        }
        while (N>0){
            set.add(pq.remove());
            N--;
        }
        return set;

    }

    private void bfs(Movie movie, PriorityQueue<Movie> pq) {
        Queue<Movie> q= new LinkedList<>();
        Set<Movie> visited= new HashSet<>();
        visited.add(movie);
        q.add(movie);
        while (!q.isEmpty()){
            Movie current=q.remove();

            for (Movie similar : current.getSimilarMovies()) {
                if(!visited.contains(similar)){
                    q.add(similar);
                    pq.add(similar);
                    visited.add(similar);
                }
            }
        }
    }

}
class Movie{
    private int movieId;
    private float rating;
    private ArrayList<Movie> similarMovies;

    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        this.similarMovies= new ArrayList<>();
    }
    public void addSimilarMovie(Movie movie){
        this.similarMovies.add(movie);
    }

    public ArrayList<Movie> getSimilarMovies() {
        return similarMovies;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
