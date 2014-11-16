package spreadfiresimulator;

/**
 *
 * @author csc319 GROUP # 14
 */

public class EachTree {
    public static final int BURN = 2, TREE = 1,EMTRY = 0;
    private int state;
    
    /*
        Constructor create tree
    */
    public EachTree(){
        state = TREE;
    }
    
    /*
        Get the status of tree
    */
    public int getState() {
        return state;
    }
    
    /*
        Set the status of tree
    */
    public void setState(int state) {
        this.state = state;
    }
    
}
