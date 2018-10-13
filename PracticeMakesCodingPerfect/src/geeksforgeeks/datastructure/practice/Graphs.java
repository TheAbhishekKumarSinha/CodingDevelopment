package geeksforgeeks.datastructure.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Graphs {

    Vertex[] adjList = null;

    class Neighbours {
        public int vertices;
        public Neighbours next;

        /**
         * 
         */
        public Neighbours(int vertices, Neighbours next) {
            this.next = next;
            this.vertices = vertices;

        }
    }

    class Vertex {
        String vertexName;
        Neighbours adjList;

        public Vertex(String vertice, Neighbours neighbours) {
            this.vertexName = vertice;
            this.adjList = neighbours;

        }

    }

    private void dfs(int indexNumber, boolean[] visited) {
        visited[indexNumber] = true;
        for (Neighbours nbr = adjList[indexNumber].adjList; nbr != null; nbr = nbr.next) {
            if (!visited[nbr.vertices]) {
                System.out.println("Visiting index " + adjList[nbr.vertices].vertexName);
                dfs(nbr.vertices, visited);
            }
        }
    }

    private void dfs() {
        boolean[] visited = new boolean[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i]) {
                System.out.println("restarting at " + adjList[i].vertexName);
                dfs(i, visited);
            }
        }
    }

    private int getIndex(String vertexName) {
        for (int i = 0; i < adjList.length; i++) {
            if (adjList[i].vertexName.equals(vertexName)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Graphs graph = new Graphs();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("D:\\com\\a.txt"));
        }
        catch (FileNotFoundException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }

        System.out.println("Enter the type of graph");
        String graphType = scan.next();

        System.out.println("Enter the number of vertices");

        int noOfVertices = scan.nextInt();
        graph.adjList = new Vertex[noOfVertices];
        System.out.println("Enter the Name of Indexes");

        for (int i = 0; i < noOfVertices; i++) {
            String indexName = scan.next();
            graph.adjList[i] = graph.new Vertex(indexName, null);
        }

        System.out.println("Enter the neighours in <Source> <Destination> format and enter Q to exit");
        while (scan.hasNext()) {
            String a = scan.next();
            String b = scan.next();
            if ("Q".equals(a.trim()) || "Q".equals(b.trim())) {
                break;
            }

            int vertice = graph.getIndex(a);
            int neighbourVertices = graph.getIndex(b);
            graph.adjList[vertice].adjList = graph.new Neighbours(neighbourVertices, graph.adjList[vertice].adjList);
            if ("undirected".equals(graphType.trim())) {
                graph.adjList[neighbourVertices].adjList = graph.new Neighbours(vertice, graph.adjList[neighbourVertices].adjList);
            }

        }
        graph.dfs();
        scan.close();

    }
}
