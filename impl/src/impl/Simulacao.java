
package impl;

import database.DBInterface;
import java.util.ArrayList;

public class Simulacao {
    
    public Simulacao(DBInterface _dbintf){
        
        dbintf = _dbintf;
        
        // pacientes e nutricionistas
        dbintf.adicionar_paciente("P1");
        dbintf.adicionar_nutricionista("R1");

        // alimentos registrados
        dbintf.adicionar_alimento("Costela");
        dbintf.adicionar_alimento("Bife");
        dbintf.adicionar_alimento("Vazio");
        dbintf.adicionar_alimento("Espetinho");
        dbintf.adicionar_alimento("Ovo Frito");

        // dietas
        ArrayList<String> ref1 = new ArrayList<String>();
        ref1.add("Vazio"); ref1.add("Costela");
        int ref1_pk = dbintf.adicionar_refeicao( ref1 );
        
        ArrayList<String> ref2 = new ArrayList<String>();
        ref2.add("Bife"); ref2.add("Ovo Frito");
        int ref2_pk = dbintf.adicionar_refeicao( ref2 );
        
        ArrayList<Integer> pks = new ArrayList<Integer>();
        pks.add(ref1_pk); pks.add(ref2_pk);
        dbintf.adicionar_dieta("R1", pks);

        // refeicoes feitas
        ArrayList<String> segunda = new ArrayList<String>();
        segunda.add("Vazio"); segunda.add("Costela");
        dbintf.registrarRefeicao(segunda);

        ArrayList<String> sexta = new ArrayList<String>();
        sexta.add("Pastel"); sexta.add("Waffels");
        dbintf.registrarRefeicao(sexta);

    }
    
    private DBInterface dbintf;
    
}
