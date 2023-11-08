package oriented.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class OrientedGraph<T> {
    private List<Vertex<T>> vertices =  new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();
    private List<ModifiedVirt> modifiedVirt = new ArrayList<>();
    public void addVertex(T id,String type){
        Vertex vertex = new Vertex();
        vertex.setData(id,type);
        vertices.add(vertex);
    }
    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }
    public void addEdge(Vertex start,Vertex end){
        if (start == end){
            throw new RuntimeException("Unable to create an edge");
        }
        Edge edge = new Edge();
        edge.setEdge(start,end);
        edges.add(edge);
    }
    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public int getCountVertices(){
        return vertices.size();
    }
    public int getCountEdges(){
        return edges.size();
    }
    public boolean checkVertexInGraph(Vertex vertex){
        for (Vertex vert : vertices){
            if (vert == vertex){
                return true;
            }
        }
        return false;
    }
    public boolean checkEdgeInGraph(Vertex start,Vertex end) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getStartOfEdge() == start && edges.get(i).getEndOfEdge() == end) {
                return true;
            }
        }
        return false;
    }
    public int getDegreeVertex(Vertex vertex){
        int degree = 0;
        for (Edge edge : edges){
            if(edge.getStartOfEdge() == vertex || edge.getEndOfEdge() == vertex){
                degree++;
            }
        }
        return degree;
    }
    public void deleteVertex(Vertex vertex){
        for (int i=0;i<edges.size();i++){
            if (edges.get(i).getStartOfEdge() == vertex || edges.get(i).getEndOfEdge() == vertex){
                edges.remove(i);
                i--;
            }
        }
        for (int i=0;i<vertices.size();i++){
            if (vertices.get(i) == vertex){
                vertices.remove(i);
                return;
            }
        }
    }
    public void deleteEdge(Edge edge){
        for (int i=0;i<edges.size();i++){
            if (edges.get(i) == edge){
                edges.remove(i);
                return;
            }
        }
    }
    public void deleteEdge(Vertex first,Vertex second){
        for (int i=0;i<edges.size();i++){
            if ((edges.get(i).getStartOfEdge() == first || edges.get(i).getEndOfEdge() == first) && (edges.get(i).getStartOfEdge() == second || edges.get(i).getEndOfEdge() == first)){
                edges.remove(i);
                i--;
            }
        }
    }
    public String vertexSearchByIteratorFromBeginning(){
        ListIterator<Vertex<T>> iterator = vertices.listIterator();
        String text = "";
        while (iterator.hasNext()){
            Vertex<T> currentVertex = iterator.next();
            text += currentVertex.getId() + "\n";
            System.out.println(currentVertex.getId());
        }
        return text;
    }
    public String vertexSearchByIteratorFromEnding(){
        ListIterator<Vertex<T>> iterator = vertices.listIterator(vertices.size());
        String text = "";
        while (iterator.hasPrevious()){
            Vertex<T> currentVertex = iterator.previous();
            text += currentVertex.getId() + "\n";
            System.out.println(currentVertex.getId());
        }
        return text;
    }
    public void createModifiedVirt(){
        for (int i=0;i<vertices.size();i++){
            ModifiedVirt vertexVirt = new ModifiedVirt();
            vertexVirt.setKey(vertices.get(i));
            vertexVirt.setCountNext(getStartEdgeOnThisVertex(vertices.get(i)).size());
            vertexVirt.setCountPred(getEndEdgeOnThisVertex(vertices.get(i)).size());
            vertexVirt.setNextLists(getStartEdgeOnThisVertex(vertices.get(i)));
            vertexVirt.setPredLists(getEndEdgeOnThisVertex(vertices.get(i)));
            modifiedVirt.add(vertexVirt);
        }
    }
    private List<Edge> getEndEdgeOnThisVertex(Vertex vertex){
        List<Edge> endEdgeOnThisVertex = new ArrayList<>();
        for (int i=0;i<edges.size();i++)
        {
            if (edges.get(i).getEndOfEdge() == vertex){
                endEdgeOnThisVertex.add(edges.get(i));
            }
        }
        return endEdgeOnThisVertex;
    }
    private List<Edge> getStartEdgeOnThisVertex(Vertex vertex){
        List<Edge> startEdgeOnThisVertex = new ArrayList<>();
        for (int i=0;i<edges.size();i++)
        {
            if (edges.get(i).getStartOfEdge() == vertex){
                startEdgeOnThisVertex.add(edges.get(i));
            }
        }
        return startEdgeOnThisVertex;
    }
    public String printVertexInfoFromVirt(Vertex vertex){
        String text = "";
        for (int i=0;i<modifiedVirt.size();i++){
            if (modifiedVirt.get(i).getKey() == vertex){
                text = modifiedVirt.get(i).getVertexInfo();
                return text;
            }
        }
        throw new RuntimeException("Vertex not found");
    }
}
