package graphs;

import java.util.Scanner;

public class dijkstrasAlgorithm {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int adjMatrix[][] = new int[n][n];
        for (int i = 0; i< e; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }
    }

    public static void dijsktra(int adjMatrix[][]){
        int n = adjMatrix.length;
        boolean visited[] = new boolean[n];
        int distance[] = new int[n];
        distance[0] = 0;
        for (int i = 0; i< n ; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i< n-1; i++){
            int minVertex = findMinVertex(visited,distance);
            visited[minVertex] = true;
            for (int j = 0; j < n; j++){
                if (adjMatrix[minVertex][j] > 0 && !visited[j] && adjMatrix[minVertex][j] < Integer.MAX_VALUE){
                    // unvisited neighbour of minVertex
                    //calculate distance to reach j from via MinVertex
                    int newDist = distance[minVertex] + adjMatrix[minVertex][j];
                    if (newDist < distance[j]){
                        distance[j] = newDist;
                    }
                }
            }
        }

    }

    private static int findMinVertex(boolean[] visited, int[] distance) {
        int minVertex = -1;
        for (int i = 0; i < visited.length; i++){
            if (!visited[i] && (minVertex == -1|| distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }

}
