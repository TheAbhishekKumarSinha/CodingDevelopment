package geeksforgeeks.datastructure.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class DijiksthaPriorityQueue {
    public static void main(String[] args) {

        DijiksthaPriorityQueue dijikstraPriority = new DijiksthaPriorityQueue();

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");

        vertexA.setAdjacentList(new Edge(10, vertexA, vertexC));
        vertexA.setAdjacentList(new Edge(17, vertexA, vertexB));
        // vertexC.setAdjacentList(new Edge(5, vertexC, vertexB));
        vertexC.setAdjacentList(new Edge(9, vertexC, vertexD));
        vertexC.setAdjacentList(new Edge(11, vertexC, vertexE));
        vertexB.setAdjacentList(new Edge(1, vertexB, vertexD));
        vertexD.setAdjacentList(new Edge(6, vertexD, vertexE));

        ShortestPathSearch shortestPath = new ShortestPathSearch();
        shortestPath.findShortestPathFromVertex(vertexA);

        System.out.println("======================================");
        System.out.println("Calculating minimum distance");
        System.out.println("======================================");

        System.out.println("Minimum distance from A to B: " + vertexB.getDistance());
        System.out.println("Minimum distance from A to C: " + vertexC.getDistance());
        System.out.println("Minimum distance from A to D: " + vertexD.getDistance());
        System.out.println("Minimum distance from A to E: " + vertexE.getDistance());

        System.out.println("=====================   =================");
        System.out.println("Calculating Paths");
        System.out.println("======================================");

    }

}

class Edge {
    int weight;
    Vertex startVertex;
    Vertex targetVertex;

    Edge(int weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

}

class Vertex implements Comparable<Vertex> {
    String vertexName;
    List<Edge> adjacentList;
    Vertex precederVextex;
    boolean visited;
    double distance = Double.MAX_VALUE;

    /**
     * @param vertexName
     */
    public Vertex(String vertexName) {
        super();
        this.vertexName = vertexName;
        this.adjacentList = new ArrayList<>();
    }

    public String getVertexName() {
        return vertexName;
    }

    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

    public List<Edge> getAdjacentList() {
        return adjacentList;
    }

    public void setAdjacentList(Edge edge) {
        this.adjacentList.add(edge);
    }

    public Vertex getPrecederVextex() {
        return precederVextex;
    }

    public void setPrecederVextex(Vertex precederVextex) {
        this.precederVextex = precederVextex;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.vertexName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.distance);
    }

}

class ShortestPathSearch {
    public void findShortestPathFromVertex(Vertex actualVertex) {

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(actualVertex);
        actualVertex.setVisited(true);
        actualVertex.setDistance(0);

        while (!priorityQueue.isEmpty()) {
            actualVertex = priorityQueue.poll();
            for (Edge edge : actualVertex.getAdjacentList()) {
                Vertex v = edge.getTargetVertex();
                if (!v.isVisited()) {
                    double newDistance = edge.getWeight() + actualVertex.getDistance();
                    if (newDistance < v.getDistance()) {
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPrecederVextex(actualVertex);
                        priorityQueue.add(v);

                    }
                }

            }
            actualVertex.setVisited(true);
        }

    }

    public void pathToVertex(Vertex targetVertex) {
        for (Vertex v = targetVertex; v != null; v = v.getPrecederVextex()) {
            System.out.print(v.vertexName);
            System.out.print("->");
        }
    }
}