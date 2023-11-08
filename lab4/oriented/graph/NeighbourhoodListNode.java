package oriented.graph;

public class NeighbourhoodListNode {
    private Vertex vertex;
    private NeighbourhoodListNode next = null;
    public void setNodeVertex(Vertex vertex){
        this.vertex=vertex;
    }
    public void SetNextPredNode(NeighbourhoodListNode node){
        this.next=node;
    }
}
