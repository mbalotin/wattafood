
package database;

import java.util.ArrayList;

public class Refeicao {

    public Refeicao(){
        pk = DBInternal.genPK();
        alimentos = new ArrayList<Alimento>();
    }

    public void addAlimento(Alimento alim){
        alimentos.add(alim);
    }

    public int getPK(){
        return pk;
    }

    protected synchronized void removeAlimento(String nome) {
        for (Alimento a: alimentos){
            if (a.getNome().equals(nome)){
                alimentos.remove(a);
                return;
            }
        }
    }

    private int pk;
    protected ArrayList<Alimento> alimentos;

}
