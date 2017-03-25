package ds.graph;

/**
 * Created by sherxon on 1/7/17.
 */
public class Edge<T extends Number, V> {
   private T weight;
    private Vertex<V> from;
    private Vertex<V> to;

    public Edge(T weight) {
        this.weight = weight;
    }

    public Edge(T weight, Vertex<V> from, Vertex<V> to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?, ?> edge = (Edge<?, ?>) o;

        if (weight != null ? !weight.equals(edge.weight) : edge.weight != null) return false;
        if (from != null ? !from.equals(edge.from) : edge.from != null) return false;
        return !(to != null ? !to.equals(edge.to) : edge.to != null);

    }

    @Override
    public int hashCode() {
        int result = weight != null ? weight.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
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

    public Vertex<V> getTo() {
        return to;
    }

    public void setTo(Vertex<V> to) {
        this.to = to;
    }
}
