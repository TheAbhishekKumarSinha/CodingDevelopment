package geeksforgeeks.datastructure.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Dijikstra {
    static int adjacentMatrix[][] = null;
    static String[] nameIndex = null;
    static int distance[] = null;
    static boolean visited[] = null;

    public static int minDistanceVertex(int[] distance, boolean[] visited) {
        int minIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minIndex == -1 || distance[i] < distance[minIndex])) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("D:\\com\\b.txt"));
        }
        catch (FileNotFoundException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
        System.out.println("Enter the number of vertices");

        int noOfVertices = scan.nextInt();
        visited = new boolean[noOfVertices];
        distance = new int[noOfVertices];

        distance[0] = 0;
        for (int i = 1; i < noOfVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < noOfVertices; i++) {
            int verticeNumber = minDistanceVertex(distance, visited);
            visited[verticeNumber] = true;
            for (int j = 0; i < noOfVertices; j++) {
                if (adjacentMatrix[verticeNumber][j] != 0 && !visited[j]) {
                    int newDistance = distance[verticeNumber] + adjacentMatrix[verticeNumber][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }

            }
        }

    }
}
