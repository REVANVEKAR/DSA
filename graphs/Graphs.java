package graphs;

import Trees.BinaryTreeuse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graphs {

    public static void dftravesal(int adjMatrix[][]) {
        boolean visited[] = new boolean[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            // making this change in the code as all the components
            // of disconnected graph won't be printed
            // by adding this for loop in the code we can iterate over each
            // component and it won't print the same elements
            // as it will be marked already and will print left out components
            if (!visited[i] ) {
                dftravesal(adjMatrix, i, visited);
                System.out.println();
                // after traversal of one component we should skip that line
            }

        }
    }

    public static void dftravesal(int adjMatrix[][], int currVertex, boolean visited[]) {
        visited[currVertex] = true;
        System.out.print(currVertex + " ");
        for (int i = 0 ; i < adjMatrix.length ; i++ ){
              if (adjMatrix[currVertex][i] == 1 && visited[i] == false){
                // i is neighbour of currentvertex
                dftravesal(adjMatrix,i,visited);
            }
        }
    }

    public static void bftraversal(int adjMatrix[][]){
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];

        visited[0] = true;

        pendingVertices.add(0);


            while (!pendingVertices.isEmpty()) {
                int currentVertex = pendingVertices.poll();
                System.out.print(currentVertex + " ");

                for (int j = 0; j < adjMatrix.length; j++) {
                    // searching for neighbour vertex
                    if (adjMatrix[currentVertex][j] == 1 && !visited[j]) {
                        pendingVertices.add(j);
                        visited[j] = true;
                    }
                }
            }


    }

    public static boolean hasPath(int[][] adjMatrix, int sv , int ev ){
        boolean[] visited = new boolean[adjMatrix.length];
        return bsf(adjMatrix,sv,ev,visited);
    }

    public static boolean bsf(int[][] adjMatrix, int sv , int ev , boolean[] visited){
        if (sv> (adjMatrix.length-1) || ev > (adjMatrix.length-1)){
            return false;
        }
        if (adjMatrix[sv][ev] == 1){
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        visited[sv] = true;
        queue.add(sv);
        while (!queue.isEmpty()){
            int front = queue.poll();
            for (int i = 0; i < adjMatrix.length;i++){
                if (adjMatrix[front][i] == 1 && !visited[i]){
                    if (i == ev){
                        return true;
                    }else {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
        return false;
    }


    // get path in dfs manner
    public static ArrayList<Integer> getPath(int edges[][], int src, int dest, boolean visited[]) {

        if (src == dest){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(dest);
            return res;
        }
        visited[src] = true;

        for(int i = 0; i < edges.length ; i++){
            if (edges[src][i] == 1 && !visited[i]){
                ArrayList<Integer> path = getPath(edges,i,dest,visited);
                if (path.size()>0){
                    path.add(src);
                    return path;
                }
            }
        }
        return new ArrayList<>();
    }




    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int adjMatrix[][] = new int[n][n];
        for (int i = 0; i < e ; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        bftraversal(adjMatrix);

//        bftraversal(adjMatrix);

//        for (int i = 0; i < n ; i++){
//            for (int j = 0; j < n ; j++){
//                System.out.print(adjMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

}
