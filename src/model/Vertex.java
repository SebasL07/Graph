package model;

import java.util.ArrayList;

public class Vertex<T> {

    private T value;

    private ArrayList<Vertex<T>> vertices;

    private Color color;

    private int distance;

    private Vertex<T> pre;

    public Vertex(T value) {
        this.value = value;
        vertices = new ArrayList<>();
        color = Color.WHITE;
        distance = 0;
        pre = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ArrayList<Vertex<T>> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex<T> getPre() {
        return pre;
    }

    public void setPre(Vertex<T> pre) {
        this.pre = pre;
    }

    public void addEdge(Vertex<T> toAdd){
        vertices.add(toAdd);

    }

}
