package model;

public interface Graph<T> {

    public void addVertex(Vertex<T> u);
    public void BFS(Vertex<T> s);
    public void DFS();
}
