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
public class Burn { 
    private Forest f = new Forest();
    private int[][] forest = f.forest;
    private boolean[][] check = f.check;
    private double probBurning ;
    private Jpanel gui = new Jpanel();;
    
    public Burn(double probBurning){
      this.probBurning = probBurning;   
      start(forest.length/2,forest[0].length/2);
      printF();
       
      //loop util finish
      while(!finish()){
          search();
          f.resetCheck();
          //printF();
        gui.drawSpreadFire(forest);
         
      }
    }

      // จุดเผาไฟ เริ่มที่ตรงกลาง
    public void start(int x , int y){
        forest[x][y] = 2;
    }
    // method for search burning (2)
    public void search(){
        for(int x=0;x<forest.length;x++){
            for(int y=0; y<forest[0].length;y++){
                if(forest[x][y]==2 && check[x][y]==false){                    
                    forest[x][y] = 0;
                   spread(x,y); 
                }
            }
        }
    }
    public void spread(int x, int y){      
         //South
        if(forest[x][y-1]==1 && random(probBurning) == true && check[x][y-1]==false ){
            forest[x][y-1] = 2; check[x][y-1] = true;   
        }
        // East
         if(forest[x+1][y]==1 && random(probBurning) == true && check[x+1][y]==false){
            forest[x+1][y] = 2; check[x+1][y] = true;  
        }
        // North  
        if(forest[x][y+1]==1 && random(probBurning) == true && check[x][y+1]==false){
            forest[x][y+1] = 2; check[x][y+1] = true;   
        }
        // West
         if(forest[x-1][y]==1 && random(probBurning) == true && check[x-1][y]==false){
            forest[x-1][y] = 2; check[x-1][y] = true;  
        }
   }
    // method to check if still have burning (2)
    public boolean finish(){
        for(int x=0;x<forest.length;x++){
            for(int y=0; y<forest[0].length;y++){
                if(forest[x][y]==2){
                   return false; // still have 2
                }
            }
        }return true; //dont have
    }
    
    public boolean random(double probB){
        double a = Math.random();
        if(a<probB){
            return true;
        }return false;
    }
   
   public void printF(){
       for(int i = 0 ; i < forest.length ; i++){
           for(int j = 0 ;j < forest.length ; j++) {
               System.out.print(forest[i][j]+ " ");
           }
           System.out.println();
       }
   System.out.println("-------------------------------");
   }
            
     
}
