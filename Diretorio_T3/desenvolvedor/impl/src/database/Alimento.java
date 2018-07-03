
package database;

public class Alimento {
    
    public Alimento(String _n){
        pk = DBInternal.genPK();
        nome = _n;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getPK(){
        return pk;
    }
    
    private int pk;
    private String nome;
    
}
