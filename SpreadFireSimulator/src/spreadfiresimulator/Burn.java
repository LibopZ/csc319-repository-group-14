/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadfiresimulator;

/**
 *
 * @author StaroMoon
 */
public class Burn {
    
    DrawField field = Forest.field;
    boolean check[][] = new boolean[field.getNumTree()][field.getNumTree()];
    Jframe gui;
    int addcnt,cnt,speed = 100;
    /*public Burn(double probBurning){
      this.probBurning = probBurning;   
      start(forest.length/2,forest[0].length/2);
      //printF();
    }
    
    public void drawSpreadFire(int[][] area){
        add(new Draw(area));
        setVisible(true);
        try{Thread.sleep(50);}
        catch(Exception e){};
        
    }
    
      // จุดเผาไฟ เริ่มที่ตรงกลาง
    public void start(int x , int y){
        forest[x][y] = 2;
    }*/
     
    // method for search burning (2)
    public void search(){
        for(int x=0;x< field.getNumTree()-1;x++){
            for(int y=0; y< field.getNumTree()-1;y++){
                if(field.eachtree[x][y].getState()==2 && check[x][y]==false){                    
                    field.eachtree[x][y].setState(0);
                   spread(x,y); 
                }
            }
        }
    }
    
    public void spread(int x, int y){      
         //North
        if(field.eachtree[x][y-1].getState()==1 && random(gui.getProbfire()) == true && check[x][y-1]==false ){
            field.eachtree[x][y-1].setState(2); check[x][y-1] = true;   
        }
        // East
         if(field.eachtree[x+1][y].getState()==1 && random(gui.getProbfire()) == true && check[x+1][y]==false){
            field.eachtree[x+1][y].setState(2); check[x+1][y] = true;  
        }
        // South  
        if(field.eachtree[x][y+1].getState()==1 && random(gui.getProbfire()) == true && check[x][y+1]==false){
            field.eachtree[x][y+1].setState(2); check[x][y+1] = true;   
        }
        // West
         if(field.eachtree[x-1][y].getState()==1 && random(gui.getProbfire()) == true && check[x-1][y]==false){
            field.eachtree[x-1][y].setState(2); check[x-1][y] = true;  
        }
   }
    // method to check if still have burning (2)
    public boolean finish(){
        for(int x=0;x<field.getNumTree();x++){
            for(int y=0; y<field.getNumTree();y++){
                if(field.eachtree[x][y].getState()==2){
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
   
    public void resetCheck(){
        for (int i = 1; i < check.length-1; i++) {
            for (int j = 1; j < check.length-1; j++) {                  
             check[i][j] = false;
            }
        }
    }
    
    public void run(){
        try{
        while(!finish()){
                step();
            }
        }catch (Exception e){
             // printF(); เพื่อไม่ให้มันปริ้นออกมาตอนรัน
        }
    }
    
    public void step() {
        try {
            search();
            resetCheck();
            /*if(finish() == true){
                if(addcnt == 0){
                addcnt++;
                cnt++;
                }else{
                }
            }else{
            cnt++;
            }*/
            field.update(field.eachtree);
            Thread.sleep(speed);
            } catch (Exception e) {
        }
    }
    
    public void printF(){
       for(int i = 0 ; i < field.getNumTree() ; i++){
           for(int j = 0 ;j < field.getNumTree() ; j++) {
               System.out.print(field.eachtree[i][j].getState()+ " ");
           }
           System.out.println();
       }
   System.out.println("-------------------------------");
   }

    public void setGui(Jframe gui) {
        this.gui = gui;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
}
