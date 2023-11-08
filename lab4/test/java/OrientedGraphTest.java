package test.java;

import org.junit.Assert;
import org.junit.Test;
import oriented.graph.Edge;
import oriented.graph.OrientedGraph;
import oriented.graph.Vertex;

public class OrientedGraphTest {
    @Test
    public void getCountVertexTest(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        graph.addVertex("A","class");
        graph.addVertex("B","class");
        graph.addVertex("C","class");

        Assert.assertEquals(3,graph.getCountVertices());
    }
    @Test
    public void getCountEdgeTest(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        graph.addVertex(vert1);
        graph.addVertex(vert2);
        graph.addVertex(vert3);
        graph.addEdge(vert1,vert3);
        graph.addEdge(vert3,vert2);
        graph.addEdge(vert1,vert2);

        Assert.assertEquals(3,graph.getCountEdges());
    }
    @Test
    public void checkVertexInGraph(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        Vertex<String> vert4 = new Vertex<>();
        graph.addVertex(vert1);
        graph.addVertex(vert2);
        graph.addVertex(vert3);

        Assert.assertEquals(true,graph.checkVertexInGraph(vert1));
        Assert.assertEquals(false,graph.checkVertexInGraph(vert4));
    }
    @Test
    public void checkEdgeInGraph(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        graph.addVertex(vert1);
        graph.addVertex(vert2);
        graph.addVertex(vert3);
        graph.addEdge(vert1,vert3);
        graph.addEdge(vert3,vert2);

        Assert.assertEquals(true,graph.checkEdgeInGraph(vert1,vert3));
        Assert.assertEquals(false,graph.checkEdgeInGraph(vert2,vert1));
    }
    @Test
    public void getDegreeVertexTest(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        Vertex<String> vert4 = new Vertex<>();
        graph.addVertex(vert1);
        graph.addVertex(vert2);
        graph.addVertex(vert3);
        graph.addVertex(vert4);
        graph.addEdge(vert1,vert3);
        graph.addEdge(vert3,vert2);

        Assert.assertEquals(2,graph.getDegreeVertex(vert3));
        Assert.assertEquals(1,graph.getDegreeVertex(vert1));
        Assert.assertEquals(0,graph.getDegreeVertex(vert4));
    }
    @Test
    public void deleteVertexTest(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        Vertex<String> vert4 = new Vertex<>();
        graph.addVertex(vert1);
        graph.addVertex(vert2);
        graph.addVertex(vert3);
        graph.addVertex(vert4);
        graph.addEdge(vert1,vert3);
        graph.addEdge(vert3,vert2);
        graph.deleteVertex(vert3);

        Assert.assertEquals(3,graph.getCountVertices());
        Assert.assertEquals(0,graph.getCountEdges());
    }
    @Test
    public void deleteEdgeTest(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        Vertex<String> vert4 = new Vertex<>();
        graph.addVertex(vert1);
        graph.addVertex(vert2);
        graph.addVertex(vert3);
        graph.addVertex(vert4);
        graph.addEdge(vert1,vert3);
        graph.addEdge(vert3,vert2);
        graph.deleteEdge(vert3,vert2);

        Assert.assertEquals(1,graph.getCountEdges());
        Assert.assertEquals(4,graph.getCountVertices());
    }
    @Test
    public void vertexSearchByIteratorTest(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        Vertex<String> vert4 = new Vertex<>();
        vert1.setData("A","class");
        vert2.setData("B","class");
        vert3.setData("C","class");
        vert4.setData("D","class");
        graph.addVertex(vert1);
        graph.addVertex(vert2);
        graph.addVertex(vert3);
        graph.addVertex(vert4);

        Assert.assertEquals("A\nB\nC\nD\n",graph.vertexSearchByIteratorFromBeginning());
        Assert.assertEquals("D\nC\nB\nA\n",graph.vertexSearchByIteratorFromEnding());
    }
    @Test
    public void createModifiedVirtTest() {
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        Vertex<String> vert4 = new Vertex<>();
        vert3.setData("A","class");
        vert1.setData("B","class");
        vert4.setData("C","class");
        graph.addVertex(vert1);
        graph.addVertex(vert2);
        graph.addVertex(vert3);
        graph.addVertex(vert4);
        graph.addEdge(vert1, vert3);
        graph.addEdge(vert3, vert2);
        graph.addEdge(vert3, vert1);
        graph.createModifiedVirt();

        Assert.assertEquals("Vertex: A\nCount Pred: 1\nCount Next: 2\n",graph.printVertexInfoFromVirt(vert3));
        Assert.assertEquals("Vertex: B\nCount Pred: 1\nCount Next: 1\n",graph.printVertexInfoFromVirt(vert1));
        Assert.assertEquals("Vertex: C\nCount Pred: 0\nCount Next: 0\n",graph.printVertexInfoFromVirt(vert4));
    }
    @Test
    public void getVertexTypeTest(){
        OrientedGraph<String> graph = new OrientedGraph<>();
        Vertex<String> vert1 = new Vertex<>();
        Vertex<String> vert2 = new Vertex<>();
        Vertex<String> vert3 = new Vertex<>();
        vert1.setData("A","class");
        vert2.setData("B","set");
        vert3.setData("C","object");

        Assert.assertEquals("class",vert1.getType());
        Assert.assertEquals("set",vert2.getType());
        Assert.assertEquals("object",vert3.getType());
    }
}
