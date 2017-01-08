package ds.graph;

/**
 * Created by sherxon on 1/7/17.
 */
public class Edge<T extends Number> {
   private T weight;
   private Vertex from;
   private Vertex to;

    public Edge(T weight) {
        this.weight = weight;
    }

    public Edge(T weight, Vertex from, Vertex to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    public T getWeight() {
        return weight;
    }

    public void setWeight(T weight) {
        this.weight = weight;
    }

    public Vertex getFrom() {
        return from;
    }

    public void setFrom(Vertex from) {
        this.from = from;
    }

    public Vertex getTo() {
        return to;
    }

    public void setTo(Vertex to) {
        this.to = to;
    }
}
