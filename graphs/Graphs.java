package graphs;

import java.util.Scanner;

public class Graphs {

    public static void dftravesal(int adjMatrix[][]) {
        boolean visited[] = new boolean[adjMatrix.length];
        dftravesal(adjMatrix,0,visited);
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

        dftravesal(adjMatrix);

//        for (int i = 0; i < n ; i++){
//            for (int j = 0; j < n ; j++){
//                System.out.print(adjMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

}
