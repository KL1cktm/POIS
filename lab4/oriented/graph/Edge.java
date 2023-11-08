package oriented.graph;

public class Edge extends Vertex{
    private Vertex first;
    private Vertex second;
    public void setEdge(Vertex first,Vertex second){
        this.first = first;
        this.second = second;
    }
    public Vertex getStartOfEdge(){
        return this.first;
    }
    public Vertex getEndOfEdge(){
        return this.second;
    }
}
