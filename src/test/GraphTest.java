package test;

import junit.framework.TestCase;
import model.Grafo;
import model.Vertex;

import java.util.ArrayList;

public class GraphTest extends TestCase {

    Grafo<String> grafo;
    public void setUpStage1(){

        grafo = new Grafo<>();

        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        grafo.addVertex(v1);
        grafo.addVertex(v2);
        grafo.addVertex(v3);
        grafo.addVertex(v4);

        grafo.addEdge(v1,v2);
        grafo.addEdge(v2,v3);
        grafo.addEdge(v3,v4);


    }

    public void setUpStage2(){

        grafo = new Grafo<>();

        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        grafo.addVertex(v1);
        grafo.addVertex(v2);
        grafo.addVertex(v3);
        grafo.addVertex(v4);

        grafo.addEdge(v1,v2);
        grafo.addEdge(v3,v4);

    }

    public void setUpStage3(){
        grafo = new Grafo<>();

        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        grafo.addVertex(v1);
        grafo.addVertex(v2);
        grafo.addVertex(v3);
        grafo.addVertex(v4);

    }

    public void testBSF(){
        setUpStage1();

        Vertex<String> v1 = grafo.search("A");
        grafo.BFS(v1);

        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> distances2 = new ArrayList<>();

        distances2.add(0);
        distances2.add(1);
        distances2.add(2);
        distances2.add(3);


        for (Vertex<String> u:
                grafo.vertices) {
           distances.add(u.getDistance());
        }

        assertEquals(distances2,distances);



    }

    public void testBFSUnconnectedV1(){
        setUpStage2();

        Vertex<String> v1 = grafo.search("A");
        grafo.BFS(v1);

        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> distances2 = new ArrayList<>();

        distances2.add(0);
        distances2.add(1);
        distances2.add(Integer.MAX_VALUE);
        distances2.add(Integer.MAX_VALUE);


        for (Vertex<String> u:
                grafo.vertices) {
            distances.add(u.getDistance());
        }

        assertEquals(distances2,distances);


    }

    public void testBFSUnconnectedV2(){
        setUpStage3();

        Vertex<String> v1 = grafo.search("B");
        grafo.BFS(v1);

        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> distances2 = new ArrayList<>();

        distances2.add(Integer.MAX_VALUE);
        distances2.add(0);
        distances2.add(Integer.MAX_VALUE);
        distances2.add(Integer.MAX_VALUE);


        for (Vertex<String> u: grafo.vertices) {
            distances.add(u.getDistance());
        }

        assertEquals(distances2,distances);


    }


}
