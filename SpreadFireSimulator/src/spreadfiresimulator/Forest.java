package spreadfiresimulator;

import javax.swing.JPanel;

/**
 *
 * @author csc319 GROUP # 14
 */
public class Forest extends JPanel{
    EachTree[][] eachtree;
    static DrawField field;
    
    public Forest(DrawField field){
        this.field = field;
        eachtree = new EachTree[field.getNumTree()][field.getNumTree()];
        for(int i = 0; i < field.getNumTree();i++){
            for(int j = 0; j < field.getNumTree();j++){
                eachtree[i][j] = new EachTree();
                if (i == 0 || j == 0 || i == field.getNumTree() - 1 || j == field.getNumTree() - 1) {   // 0 = frame of forest
                    eachtree[i][j].setState(0);    
                }
                if(i == field.getNumTree()/2 && j == field.getNumTree() / 2){
                    eachtree[i][j].setState(2);
                }
            }
        }
        field.update(eachtree);
    }
    
    public void printForest() {
        for (int i = 0; i < field.getNumTree(); i++) {
            for (int j = 0; j < field.getNumTree(); j++) {
                System.out.print(eachtree[i][j].getState() + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
    
    /*public void create(int size){
        forest = new int[size][size];
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
    
    public void setSize(int size) {
        this.size = size;
        repaint();
    }

    public int getSize() {
        return size;
    }*/
    
}
