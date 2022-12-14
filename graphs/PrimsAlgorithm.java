package graphs;

import java.util.Scanner;

public class PrimsAlgorithm {


    public static void prims(int adjMatrix[][]){
        int n = adjMatrix.length;
        boolean visited[] = new boolean[n];
        int parent[] = new int[n];
        int weight[] = new int[n];
        //source - vertex 0
        parent[0] = -1;
        weight[0] = 0;
        for (int i =0; i < n; i++){
            weight[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i< n; i++){
            int minVertex = findMinVertex(visited, weight);
            visited[minVertex] = true;
            //explore neighbours of min vertex
            for (int j = 0; j < n ; j++){
                if (adjMatrix[minVertex][j] > 0 && !visited[j]){
                    if (weight[j]>adjMatrix[minVertex][j]){
                        // update values
                        weight[j] = adjMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        //print mst
        for(int i = 1;i<n;i++){
            if (i < parent[i]) {
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }else{
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }
        }

    }

    private static int findMinVertex(boolean[] visited, int[] weight) {
        int minVertex = -1;
        for (int i = 0; i< visited.length;i++){
            if (!visited[i] && (minVertex == -1 || weight[i]< weight[minVertex])){
                minVertex= i;
            }
        }
        return minVertex;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int adjMatrix[][] = new int[n][n];
        for (int i = 0; i < e ; i ++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }

        prims(adjMatrix);

    }

}

