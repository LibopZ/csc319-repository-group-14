package spreadfiresimulator;

/**
 *
 * @author csc319 GROUP # 14
 */
public class Burn {
    private int speed = 100;
    DrawField field = Forest.field;
    boolean check[][] = new boolean[field.getNumTree()][field.getNumTree()];
    Jframe gui;
    
    /*
        Check tree if already burn then set to empty tree and probability to spread fire to other tree
    */
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
    
    /*
        Check if it is a tree then check probability to spread fire to other tree
    */
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
    
    /*
        Check if still have burning tree
    */
    public boolean finish(){
        for(int x=0;x<field.getNumTree();x++){
            for(int y=0; y<field.getNumTree();y++){
                if(field.eachtree[x][y].getState()==2){
                   return false; // still have burning tree
                }
            }
        }return true; //dont have
    }
    
    /*
        Random probability
    */
    public boolean random(double probB){
        double a = Math.random();
        if(a<probB){
            return true;
        }return false;
    }
    
    /*
        Set tree doesn't check to false
    */
    public void resetCheck(){
        for (int i = 1; i < check.length-1; i++) {
            for (int j = 1; j < check.length-1; j++) {                  
             check[i][j] = false;
            }
        }
    }
    
    /*
        Make forest automatic burn
    */
    public void run(){
        while(!finish()){
                step();
            }
    }
    
    /*
        Make forest burn step by step
    */
    public void step() {
        try {
            search();
            resetCheck();
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

    /*
        Set Jframe
    */
    public void setGui(Jframe gui) {
        this.gui = gui;
    }
    
    /*
        Set speed of automatic burn forest
    */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
}
