
package impl;

import database.DBInterface;

public class Impl {

    public static void main(String[] args) {
        
        DBInterface dbintf = new DBInterface();
        Simulacao sim = new Simulacao(dbintf);
        UC_Acompanhamento acomp = new UC_Acompanhamento(dbintf);
        acomp.run();

    }
    
}
