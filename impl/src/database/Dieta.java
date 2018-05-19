
package database;

import java.util.ArrayList;

public class Dieta {

    public Dieta(Nutricionista nutr){
        nutricionista = nutr;
        pk = DBInternal.genPK();
        refeicoes = new ArrayList<Refeicao>();
    }

    public void addRefeicao(Refeicao ref){
        refeicoes.add(ref);
    }

    public synchronized void removeRefeicao(Refeicao ref){
        refeicoes.remove(ref);
    }

    protected synchronized void removeRefeicao(int _pk){
        for (Refeicao r: refeicoes){
            if (r.getPK() == _pk){
                refeicoes.remove(r);
            }
        }
    }
    
    public void setNutricionista(Nutricionista nutr){
        nutricionista = nutr;
    }
    
    public Nutricionista getNutricionista(){
        return nutricionista;
    }
    
    public int getPK(){
        return pk;
    }
    
    private int pk;
    protected ArrayList<Refeicao> refeicoes;
    protected Nutricionista nutricionista;

}
