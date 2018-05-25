
package database;

import java.util.ArrayList;

public class RegistroDeRefeicao {
    
    public RegistroDeRefeicao(){
        pk = DBInternal.genPK();
        refeicoes = new ArrayList<ArrayList<String>>();
    }

    public int adicionarRefeicao(ArrayList<String> _rs){
        ArrayList<String> ref = new ArrayList<String>();
        for (String s: _rs){
            ref.add(s);
        }
        refeicoes.add(ref);
        return refeicoes.size()-1;
    }

    public void removerRefeicao(int _idx){
        if (_idx > -1 && _idx < refeicoes.size()){
            refeicoes.remove(_idx);
        }
    }

    public void insertEmRegistroRefeicao(int _idx, ArrayList<String> alimentos){
        if ( !(_idx > -1 && _idx < refeicoes.size())  ){
            return;
        }
        for (String a: alimentos){
            refeicoes.get(_idx).add(a);
        }
    }

    public void removeFromRegistroRefeicao(int _idx, ArrayList<String> alimentos){
        if ( !(_idx > -1 && _idx < refeicoes.size())  ){
            return;
        }
        for (String a: alimentos){
            refeicoes.get(_idx).remove(a);
        }
    }
    
    private int pk;
    protected ArrayList<ArrayList<String>> refeicoes;
    
}
