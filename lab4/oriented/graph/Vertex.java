package oriented.graph;

public class Vertex<T> {
    private T id;
    private String type;
    public void setData(T id,String type){
        this.id = id;
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public T getId(){
        return this.id;
    }
}