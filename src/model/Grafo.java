package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo<T extends Comparable<T>> implements Graph<T>{

    public ArrayList<Vertex<T>> vertices;

    public Queue<Vertex<T>> vertexQueue;

    @Override
    public void BFS(Vertex<T> s){
        for(Vertex<T> u : vertices){
            u.setColor(Color.WHITE);
            u.setDistance(Integer.MAX_VALUE);
            u.setPre(null);
        }

        s.setColor(Color.BLACK);
        s.setDistance(0);
        s.setPre(null);

        vertexQueue.add(s);
        Vertex<T> u;
        while(!vertexQueue.isEmpty()){
            u = vertexQueue.poll();
            for (Vertex<T> v : u.getVertices()){
                if(v.getColor() == Color.WHITE){
                    v.setColor(Color.GRAY);
                    v.setDistance(u.getDistance()+1);
                    v.setPre(u);
                    vertexQueue.add(v);
                }
            }
            u.setColor(Color.BLACK);
        }

    }
    @Override
    public void DFS(){
        for (Vertex<T> u: vertices) {
            u.setColor(Color.WHITE);
            u.setPre(null);
        }
        for (Vertex<T> u:
             vertices) {
            if (u.getColor() == Color.WHITE){
                DFS_VISIT(u);
            }
        }
    }

    public Vertex<T> search(T value){

        int left = 0;
        int right = vertices.size() -1;

        int mid;

        while (left<=right){
            mid = (left+right)/2;

            Vertex<T> toCompare = vertices.get(mid);

            if (toCompare.getValue().equals(value)){
                return vertices.get(mid);
            }else if(toCompare.getValue().compareTo(value) > 0){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }

        return null;

    }

    private void DFS_VISIT(Vertex<T> u){
        int time = 0;

        u.setColor(Color.GRAY);
        for (Vertex<T> v:
            u.getVertices() ) {
            if(v.getColor() == Color.WHITE){
                v.setPre(u);
                DFS_VISIT(v);
            }
        }
        u.setColor(Color.BLACK);
    }

    public void addEdge(Vertex<T> origin, Vertex<T> toAdd){
        origin.addEdge(toAdd);
        toAdd.addEdge(origin);
    }

    @Override
    public void addVertex(Vertex<T> vertex){
        vertices.add(vertex);
    }

    public Grafo() {
        vertices = new ArrayList<>();
        vertexQueue = new LinkedList<>();
    }
}
