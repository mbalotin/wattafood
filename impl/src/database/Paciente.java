
package database;

import java.util.ArrayList;

public class Paciente {

    public Paciente(String _n){
        pk = DBInternal.genPK();
        nome = _n;
        registro_refeicoes = new ArrayList<RegistroDeRefeicao>();
    }

    public String getNome(){
        return nome;
    }
    
    public void addRegistroRefeicao(RegistroDeRefeicao rdr){
        registro_refeicoes.add(rdr);
    }
    
    public void setDieta(Dieta d){
        dieta = d;
    }
    
    public int getPK(){
        return pk;
    }
    
    private int pk;
    private String nome;
    private ArrayList<RegistroDeRefeicao> registro_refeicoes;
    private Dieta dieta;

}
