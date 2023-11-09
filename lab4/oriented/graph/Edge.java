package oriented.graph;

public class Edge<T> {
    private Vertex<T> first;
    private Vertex<T> second;

    public void setEdge(Vertex<T> first, Vertex<T> second) {
        this.first = first;
        this.second = second;
    }

    public Vertex<T> getStartOfEdge() {
        return this.first;
    }

    public Vertex<T> getEndOfEdge() {
        return this.second;
    }
}
