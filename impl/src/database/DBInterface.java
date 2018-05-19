
package database;

import java.util.ArrayList;

public class DBInterface {
    
    public DBInterface(){
        nutricionistas = new ArrayList<Nutricionista>();
        alimentos = new ArrayList<Alimento>();
        pacientes = new ArrayList<Paciente>();
        refeicoes = new ArrayList<Refeicao>();
        dietas = new ArrayList<Dieta>();
        registro_refeicoes = new RegistroDeRefeicao();
    }

    public synchronized void reset() {
        DBInternal.reset();
        nutricionistas = new ArrayList<Nutricionista>();
        alimentos = new ArrayList<Alimento>();
        pacientes = new ArrayList<Paciente>();
        refeicoes = new ArrayList<Refeicao>();
        dietas = new ArrayList<Dieta>();
        registro_refeicoes = new RegistroDeRefeicao();
    }
    
    public synchronized int adicionar_nutricionista(String nome){
        for (Nutricionista n: nutricionistas){
            // nao deixa adicionar repetido
            if (n.equals(nome)){
                return -1;
            }
        }
        Nutricionista nutr = new Nutricionista(nome);
        nutricionistas.add(nutr);
        return nutr.getPK();
    }

    public synchronized int adicionar_alimento(String nome){
        for (Alimento a: alimentos){
            // nao deixa adicionar repetido
            if (a.getNome().equals(nome)){
                return -1;
            }
        }
        Alimento alim = new Alimento(nome);
        alimentos.add(alim);
        return alim.getPK();
    }

    public synchronized void remover_alimento(String nome){
        for (Refeicao r: refeicoes){
            r.removeAlimento(nome);
        }
        for (Alimento a: alimentos){
            if (a.getNome().equals(nome)){
                alimentos.remove(a);
                return;
            }
        }
    }

    public synchronized int adicionar_paciente(String nome){
        for (Paciente p: pacientes){
            // nao deixa adicionar duplicado
            if (p.getNome().equals(nome)){
                return -1;
            }
        }
        Paciente pac = new Paciente(nome);
        pacientes.add(pac);
        return pac.getPK();
    }

    public synchronized boolean adicionar_alimentos_refeicao(int pk, ArrayList<String> lista_alimentos){
        
        Refeicao ref = find_refeicao(pk);
        if (ref == null){
            return false;
        }
        for (String s: lista_alimentos){
            Alimento a = find_alimento(s);
            if (a == null){
                return false;
            }
            ref.addAlimento(a);
        }
        refeicoes.add(ref);
        return true;
        
    }

    public synchronized int adicionar_refeicao(ArrayList<String> lista_alimentos){
        
        Refeicao ref = new Refeicao();
        for (String s: lista_alimentos){
            Alimento a = find_alimento(s);
            if (a == null){
                return -1;
            }
            ref.addAlimento(a);
        }
        refeicoes.add(ref);
        return ref.getPK();

    }

    public synchronized void remover_refeicao(int _pk){
        for (Dieta d: dietas){
            d.removeRefeicao(_pk);
        }
        for (Refeicao r: refeicoes){
            if (r.getPK() == _pk){
                refeicoes.remove(r);
                break;
            }
        }
    }

    public synchronized int adicionar_dieta(String nome_nutricionista, ArrayList<Integer> pks_refeicoes){

        Nutricionista n = find_nutricionista(nome_nutricionista);
        if (n == null){
            return -1;
        }

        Dieta dieta = new Dieta(n);
        for (Integer in: pks_refeicoes){
            Refeicao ref = find_refeicao(in);
            if (ref == null){
                return -1;
            }
            dieta.addRefeicao(ref);
        }
        dietas.add(dieta);
        return dieta.getPK();

    }

    public synchronized void remover_dieta(int _pk){
        for (Dieta d: dietas){
            if (d.getPK() == _pk){
                dietas.remove(d);
                break;
            }
        }
    }

    public synchronized ArrayList<String> read_refeicoes_dieta(int _pk){

        Dieta d = find_dieta(_pk);
        if (d == null){
            return null;
        }

        ArrayList<String> ra = new ArrayList<String>();
        for (Refeicao r: d.refeicoes){
            ra.add(Integer.toString(r.getPK()));
        }
        return ra;

    }

    public synchronized ArrayList<String> read_alimentos_refeicao(int _pk_d, int _pk_r){

        Dieta d = find_dieta(_pk_d);
        if (d == null){
            return null;
        }

        Refeicao r = find_refeicao_em_dieta(d, _pk_r);
        if (r == null){
            return null;
        }

        ArrayList<String> ra = new ArrayList<String>();
        for (Alimento a: r.alimentos){
            ra.add(a.getNome());
        }
        return ra;

    }

    protected synchronized Dieta find_dieta(int _pk){
        for (Dieta d: dietas){
            if (d.getPK() == _pk){
                return d;
            }
        }
        return null;
    }

    protected synchronized Refeicao find_refeicao_em_dieta(Dieta _d, int _pk_r){
        for (Refeicao r: _d.refeicoes){
            if (r.getPK() == _pk_r){
                return r;
            }
        }
        return null;
    }

    public synchronized boolean update_dieta(int _pk, String nome_nutricionista, ArrayList<Integer> pks_refeicoes){

        Dieta dieta = find_dieta(_pk);
        if (dieta == null){
            return false;
        }

        Nutricionista n = find_nutricionista(nome_nutricionista);
        if (n == null){
            return false;
        }
        dieta.setNutricionista(n);

        for (Integer in: pks_refeicoes){
            Refeicao ref = find_refeicao(in);
            if (ref == null){
                return false;
            }
            dieta.addRefeicao(ref);
        }

        return true;
    }

    public synchronized boolean update_refeicao(int _pk, ArrayList<Integer> pks_alimentos){
        
        Refeicao ref = find_refeicao(_pk);
        if (ref == null){
            return false;
        }

        for (Integer in: pks_alimentos){
            Alimento alim = find_alimento(in);
            ref.alimentos.add(alim);
        }

        return true;
    }

    public synchronized boolean remove_from_dieta(int _pk, ArrayList<Integer> pks_refeicoes){

        Dieta dieta = find_dieta(_pk);
        if (dieta == null){
            return false;
        }

        for (Integer in: pks_refeicoes){
            Refeicao ref = find_refeicao(in);
            if (ref == null){
                return false;
            }
            dieta.removeRefeicao(ref);
        }

        return true;
    }

    public synchronized int registrarRefeicao(ArrayList<String> alimentos){
        int idx = registro_refeicoes.adicionarRefeicao(alimentos);
        return idx;
    }
 
    public synchronized void insertEmRegistroRefeicao(int _pk, ArrayList<String> alimentos){
        registro_refeicoes.insertEmRegistroRefeicao(_pk, alimentos);
    }

    public synchronized void removerRefeicao(int _pk){
        registro_refeicoes.removerRefeicao(_pk);
    }

    public synchronized void removeFromRegistroRefeicao(int _pk, ArrayList<String> alimentos){
        registro_refeicoes.removeFromRegistroRefeicao(_pk, alimentos);
    }

    public synchronized ArrayList<String> readRegistroRefeicao(int _pk){
        if ( !( _pk > -1 && _pk < registro_refeicoes.refeicoes.size() ) ){
            return null;
        }
        ArrayList<String> reg = new ArrayList<String>();
        for (String s: registro_refeicoes.refeicoes.get(_pk)){
            reg.add(s);
        }
        return reg;
    }
    
    private synchronized Nutricionista find_nutricionista(String nome){
        for (Nutricionista n: nutricionistas){
            if (n.getNome().equals(nome)){
                return n;
            }
        }
        return null;
    }

    private synchronized Refeicao find_refeicao(Integer pk){
        for (Refeicao ref: refeicoes){
            if (ref.getPK() == pk){
                return ref;
            }
        }
        return null;
    }

    private synchronized Alimento find_alimento(String nome){
        for (Alimento a: alimentos){
            if (a.getNome().equals(nome)){
                return a;
            }
        }
        return null;
    }

    private synchronized Alimento find_alimento(Integer pk){
        for (Alimento a: alimentos){
            if (a.getPK() == pk){
                return a;
            }
        }
        return null;
    }

    public synchronized ArrayList<ArrayList<ArrayList<String>>> getRefeicoesTodasDietas(){

        ArrayList<ArrayList<ArrayList<String>>> ddd = new ArrayList<ArrayList<ArrayList<String>>>();
        for (Dieta d: dietas){

            ArrayList<ArrayList<String>> ddr = new ArrayList<ArrayList<String>>();
            for (Refeicao r: d.refeicoes){

                ArrayList<String> rl = new ArrayList<String>();
                for (Alimento a: r.alimentos){
                    rl.add(a.getNome());
                }

                ddr.add(rl);
            }

            ddd.add(ddr);
        }

        return ddd;

    }

    public synchronized ArrayList<ArrayList<String>> getRegistroRefeicoes(){
        
        ArrayList<ArrayList<String>> rr = new ArrayList<ArrayList<String>>();

        for (ArrayList<String> refs: registro_refeicoes.refeicoes){
            
            ArrayList<String> rn = new ArrayList<String>();
            for (String ras: refs){
                rn.add(ras);
            }
            rr.add(rn);
            
        }

        return rr;
    }
    
    private ArrayList<Nutricionista> nutricionistas;
    private ArrayList<Alimento> alimentos;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Refeicao> refeicoes;
    private ArrayList<Dieta> dietas;
    private RegistroDeRefeicao registro_refeicoes;
    
}
