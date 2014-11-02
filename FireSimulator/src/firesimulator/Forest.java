/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package firesimulator;

/**
 *
 * @author Student Lab
 */
public class Forest {
 

    public int[][] forest;    
    public boolean[][] check;
    private int size = 20;
    
    public Forest(){
      create(size) ;
      //printForest();
      System.out.println();
      
      
    }
    
    public void create(int size) {
        forest = new int[size][size];
        check = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {                  
             if (i == 0 || j == 0 || i == forest.length - 1 || j == forest.length - 1) {   // 0 = frame of forest
                    forest[i][j] = 0;    
                  }                   
             else {
                    forest[i][j] = 1;     //  1 = Tree
                }
            }
        }
    }

    public void resetCheck(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {                  
             check[i][j] = false;
            }
        }
    }
    
    public void printForest() {
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                System.out.print(forest[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
    

}
