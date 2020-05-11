

import java.util.*;
public class Program {


    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> riverSizes = new ArrayList<>();
        boolean[][] visitedPoint = new boolean[matrix.length][matrix[0].length];
        for(int x =0;x<matrix.length;x++){
            for(int y=0;y<matrix[0].length;y++){
                if(visitedPoint[x][y]){
                    continue;
                }
                findRiverSize(x,y,matrix,visitedPoint,riverSizes);

            }

        }



       
        return riverSizes;
    }

    private static void findRiverSize(int x, int y, int[][] matrix, boolean[][] visitedPoint,List<Integer> riverSizes) {

        List<Integer[]> searchQueue = new ArrayList<>();
        searchQueue.add(new Integer[] {x,y});
        int OneCount=0;
        while(!searchQueue.isEmpty()){

            Integer[] currentPoint = searchQueue.get(0);
            searchQueue.remove(0);
            int i=currentPoint[0];
            int j= currentPoint[1];
            if(visitedPoint[i][j]){
                continue;
            }
            if(matrix[i][j]==0){
                continue;
            }
            visitedPoint[i][j]=true;
            OneCount++;
            List<Integer[]> neighbours = getNeighbouringPoints(i,j,matrix);
            searchQueue.addAll(neighbours);














        }
        if(OneCount>0){
            riverSizes.add(OneCount);

        }






    }

    private static List<Integer[]> getNeighbouringPoints(int i, int j, int[][] matrix) {
        List<Integer[]> neighbourList = new ArrayList<>();
        if(i>0){
            neighbourList.add(new Integer[] {i-1,j});

        }
        if(i<matrix.length-1){
            neighbourList.add(new Integer[] {i+1,j});

        }
        if(j>0){
            neighbourList.add(new Integer[] {i,j-1});

        }
        if(j<matrix[0].length-1){
            neighbourList.add(new Integer[] {i,j+1});

        }


        return neighbourList;
    }


}
