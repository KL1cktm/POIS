package oriented.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class OrientedGraph<T> {
    private List<Vertex<T>> vertices =  new ArrayList<>();
    private List<Edge<T>> edges = new ArrayList<>();
    private List<ModifiedVirt<T>> modifiedVirt = new ArrayList<>();
    public void addVertex(T id,String type){
        Vertex<T> vertex = new Vertex<>();
        vertex.setData(id,type);
        vertices.add(vertex);
    }
    public void addVertex(Vertex<T> vertex){
        vertices.add(vertex);
    }
    public void addEdge(Vertex<T> start,Vertex<T> end){
        if (start == end){
            throw new RuntimeException("Unable to create an edge, start edge is end edge");
        }
        Edge<T> edge = new Edge<T>();
        edge.setEdge(start,end);
        edges.add(edge);
    }
    public void addEdge(Edge<T> edge){
        edges.add(edge);
    }
    public int getCountVertices(){
        return vertices.size();
    }
    public int getCountEdges(){
        return edges.size();
    }
    public boolean checkVertexInGraph(Vertex<T> vertex){
        for (Vertex<T> vert : vertices){
            if (vert == vertex){
                return true;
            }
        }
        return false;
    }
    public boolean checkEdgeInGraph(Vertex<T> start,Vertex<T> end) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getStartOfEdge() == start && edges.get(i).getEndOfEdge() == end) {
                return true;
            }
        }
        return false;
    }
    public int getDegreeVertex(Vertex<T> vertex){
        int degree = 0;
        for (Edge<T> edge : edges){
            if(edge.getStartOfEdge() == vertex || edge.getEndOfEdge() == vertex){
                degree++;
            }
        }
        return degree;
    }
    public void deleteVertex(Vertex<T> vertex){
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
    public void deleteEdge(Edge<T> edge){
        for (int i=0;i<edges.size();i++){
            if (edges.get(i) == edge){
                edges.remove(i);
                return;
            }
        }
    }
    public void deleteEdge(Vertex<T> first,Vertex<T> second){
        for (int i=0;i<edges.size();i++){
            if ((edges.get(i).getStartOfEdge() == first || edges.get(i).getEndOfEdge() == first) &&
                    (edges.get(i).getStartOfEdge() == second || edges.get(i).getEndOfEdge() == first)){
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
            ModifiedVirt<T> vertexVirt = new ModifiedVirt<T>();
            vertexVirt.setKey(vertices.get(i));
            vertexVirt.setCountNext(getStartEdgeOnThisVertex(vertices.get(i)).size());
            vertexVirt.setCountPred(getEndEdgeOnThisVertex(vertices.get(i)).size());
            vertexVirt.setNextLists(getStartEdgeOnThisVertex(vertices.get(i)));
            vertexVirt.setPredLists(getEndEdgeOnThisVertex(vertices.get(i)));
            modifiedVirt.add(vertexVirt);
        }
    }
    private List<Edge<T>> getEndEdgeOnThisVertex(Vertex<T> vertex){
        List<Edge<T>> endEdgeOnThisVertex = new ArrayList<>();
        for (int i=0;i<edges.size();i++)
        {
            if (edges.get(i).getEndOfEdge() == vertex){
                endEdgeOnThisVertex.add(edges.get(i));
            }
        }
        return endEdgeOnThisVertex;
    }
    private List<Edge<T>> getStartEdgeOnThisVertex(Vertex<T> vertex){
        List<Edge<T>> startEdgeOnThisVertex = new ArrayList<>();
        for (int i=0;i<edges.size();i++)
        {
            if (edges.get(i).getStartOfEdge() == vertex){
                startEdgeOnThisVertex.add(edges.get(i));
            }
        }
        return startEdgeOnThisVertex;
    }
    public String printVertexInfoFromVirt(Vertex<T> vertex){
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
