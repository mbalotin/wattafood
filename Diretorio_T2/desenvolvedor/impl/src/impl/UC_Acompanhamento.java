
package impl;

import database.Consulta;
import database.DBInterface;
import java.util.ArrayList;

public class UC_Acompanhamento {
    
    public UC_Acompanhamento(DBInterface dbintf){
        dbinterface = dbintf;
    }

    public void run(){

        // 1. caso: selecionar nutricionista
        String nome_nutr = "R1";
        
        ItensComida breakfast = new ItensComida();
        ItensComida lunch = new ItensComida();
        ItensComida dinner = new ItensComida();

        breakfast.itens.add("Torrada");
        breakfast.itens.add("Cafe");

        lunch.itens.add("Lasanha");
        lunch.itens.add("Pizza");

        dinner.itens.add("Espaguete");
        dinner.itens.add("Alfafa");
 
        ArrayList<ItensComida> itens = new ArrayList<ItensComida>();
        itens.add(breakfast);
        itens.add(lunch);
        itens.add(dinner);

        ArrayList<ArrayList<String>> refeicoes_feitas = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<ArrayList<String>>> refeicoes_dietas = new ArrayList<ArrayList<ArrayList<String>>>();
        
        refeicoes_feitas = dbinterface.getRegistroRefeicoes();
        refeicoes_dietas = dbinterface.getRefeicoesTodasDietas();

        // refeicoes feitas
        for (ArrayList<String> rf: refeicoes_feitas){

            // match refeicoes feitas contra dietas
            for (ArrayList<ArrayList<String>> d: refeicoes_dietas){

                // refeicoes em d (dieta)
                boolean match = false;
                for (ArrayList<String> r: d){
                    match |= Consulta.alimentos_match(r, rf);
                }
                if (!match) refeicao_ruim(rf);

            }

        }

    }

    private void refeicao_ruim(ArrayList<String> alimentos){
        System.out.println("Esta refeicao esta fora da dieta:");
        for (String a: alimentos){
            System.out.println(a);
        }
        System.out.println("\n");
    }
    
    private DBInterface dbinterface;

}
