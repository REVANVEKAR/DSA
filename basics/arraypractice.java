package basics;

import javax.swing.*;

public class arraypractice {
    public static void main(String[] args) {
//        float[] deci = {100.0f, 92.5f, 35.0f, 90.0f, 85.5f};
//
//        float sum = 0;
//        for (int i = 0; i< deci.length; i++){
//            sum += deci[i];
//        }
//        System.out.println(sum);
        //practice prob 2
//        float num = 12.2f;
//        boolean isinarray = false;
//        for (float element:deci){
//            if (num==element){
//                isinarray = true;
//                break;
//            }
//        }
//        if(isinarray){
//            System.out.println("the value is present in array");
//        }
//        else{
//            System.out.println("not available");

        //practice prob 3
//        float averagekasum = 0;
//        for (float element:deci){
//            averagekasum += element;
//        }
//
//        float average = averagekasum/deci.length;
//
//        System.out.println(average);

        //problem 4
//        int[][] mat1 = { {1, 2, 3},
//                       {4, 5, 6} };
//        int[][] mat2 = { {2, 6, 3},
//                       {3, 7, 1} };
//        int[][] mat3 = { {0, 0, 0},
//                       {0, 0, 0} };
//        for (int i=0; i<mat1.length; i++){
//            for (int j=0; j<mat1[i].length; j++){
//                System.out.format(" setting value for i=%d and j=%d\n ",i ,j );
//                mat3[i][j] = mat1[i][j] + mat2[i][j];
//            }
//
//        }
//
//        for (int i=0; i< mat1.length; i++){
//            for (int j=0; j<mat1[i].length; j++){
//                System.out.print(mat3[i][j] + " " );
//                mat3[i][j] = mat1[i][j] + mat2[i][j];
//            }
//            System.out.println("");
//        }
        //reverse an array
//        int[] maaki = {2, 3, 4, 5, 6, 455, 8};
//        int l = maaki.length;
//        int n = Math.floorDiv(l , 2);
//        int temp;
//        for (int i = 0; i<n; i++){
//            /* swapping logic assume there are two empty dabbas and u have to swap the elements of those dabbas
//            assume if i have to pour paani from one dabba to another dabba the other bucket wont have space right?
//            so we bring in another temporary dabba || || || we put the paani from dabba1 to dabba3 then pour dabba2
//            ka paani in dabba1 then pour water from dabba3 to dabba2 this is swapping array ka logic
//             */
//            temp = maaki[i];
//            maaki[i] = maaki[l-i-1];
//            maaki[l-i-1] = temp;
//        }
//        for (int element:maaki){
//            System.out.print(element + " ");
//        }

        //problem 6
//        int max = 0;
//        for (int e:maaki){
//            if(e>max){
//                max = e;
//            }
//        }
//        System.out.println(max);
        //problem 8
//        boolean issorted = true;
//        for (int a = 0; a < maaki.length - 1; a++) {
//            if (maaki[a] > maaki[a + 1]) {
//
//                issorted = false;
//                break;
//            }
//        }
//            if (issorted) {
//                System.out.println("sorted");
//            } else {
//                System.out.println("not sorted");
//            }




    }

}


