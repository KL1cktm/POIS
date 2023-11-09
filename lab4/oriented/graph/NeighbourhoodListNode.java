package oriented.graph;

public class NeighbourhoodListNode<T> {
    private Vertex<T> vertex;
    private NeighbourhoodListNode<T> next = null;
    public void setNodeVertex(Vertex<T> vertex){
        this.vertex=vertex;
    }
    public void SetNextPredNode(NeighbourhoodListNode<T> node){
        this.next=node;
    }
}
