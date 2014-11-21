package spreadfiresimulator;

import javax.swing.JPanel;

/**
 *
 * @author csc319 GROUP # 14
 */
public class Forest extends JPanel{
    private EachTree[][] eachtree;
    static DrawField field;
    
    /*
        Constructor set state of each tree
    */
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
}
