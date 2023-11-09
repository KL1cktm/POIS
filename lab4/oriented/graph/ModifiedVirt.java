package oriented.graph;

import java.util.ArrayList;
import java.util.List;

public class ModifiedVirt<T> {
    private int countPred;
    private Vertex<T> key;
    private int countNext;
    private List<NeighbourhoodListNode<T>> nextLists = new ArrayList<>();
    private List<NeighbourhoodListNode<T>> predLists = new ArrayList<>();
    public void setKey(Vertex<T> key){
        this.key=key;
    }
    public void setCountPred(int countPred){
        this.countPred = countPred;
    }
    public void setCountNext(int countNext){
        this.countNext=countNext;
    }
    public void setPredLists(List<Edge<T>> edges){
        for (int i=0;i<edges.size();i++){
            if (i == 0) {
                NeighbourhoodListNode<T> node = new NeighbourhoodListNode<T>();
                node.setNodeVertex(edges.get(i).getStartOfEdge());
                predLists.add(node);
            }
            else {
                NeighbourhoodListNode<T> node = new NeighbourhoodListNode<T>();
                node.setNodeVertex(edges.get(i).getStartOfEdge());
                predLists.get(predLists.size()).SetNextPredNode(node);
                predLists.add(node);
            }
        }
    }
    public void setNextLists(List<Edge<T>> edges){
        for (int i=0;i<edges.size();i++){
            if (i == 0) {
                NeighbourhoodListNode<T> node = new NeighbourhoodListNode<T>();
                node.setNodeVertex(edges.get(i).getEndOfEdge());
                nextLists.add(node);
            } else {
                NeighbourhoodListNode<T> node = new NeighbourhoodListNode<T>();
                node.setNodeVertex(edges.get(i).getEndOfEdge());
                nextLists.get(predLists.size()).SetNextPredNode(node);
                nextLists.add(node);
            }
        }
    }
    public Vertex<T> getKey(){
        return this.key;
    }
    public String getVertexInfo(){
        String text = "";
        text += "Vertex: " + key.getId() + "\n";
        text += "Count Pred: " + countPred + "\n";
        text += "Count Next: " + countNext + "\n";
        return text;
    }
}
