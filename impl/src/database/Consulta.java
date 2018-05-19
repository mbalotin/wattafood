
package database;

import java.util.ArrayList;

public class Consulta {

    public Consulta(){
    }

    public static boolean alimentos_match(ArrayList<String> ref1, ArrayList<String> ref2){

        if (ref1.size() != ref2.size()){
            return false;
        }

        if (ref1.size() == 0 || ref2.size() == 0){
            return false;
        }

        for (String s: ref1){
            if (!ref2.contains(s)) {
                return false;
            }
        }

        return true;

    }
    
}
