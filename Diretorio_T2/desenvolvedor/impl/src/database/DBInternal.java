
package database;

public class DBInternal {
    
    static int pk=0;
    
    public static int genPK(){
        pk++;
        return pk;
    }
    
    public static void reset(){
        pk=0;
    }
    
}
