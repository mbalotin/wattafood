
package database;

import java.util.ArrayList;

public class Nutricionista {
    
    public Nutricionista(String _n){
        pk = DBInternal.genPK();
        nome = _n;
        dietas = new ArrayList<Dieta>();
    }
    
    public String getNome(){
        return nome;
    }
    
    public void addDieta(Dieta d){
        dietas.add(d);
    }
    
    public int getPK(){
        return pk;
    }
    
    private int pk;
    private String nome;
    private ArrayList<Dieta> dietas;
    
}
