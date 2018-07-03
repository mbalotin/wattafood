
package guipkg;

import database.DBInterface;

public class Sessao {

    public Sessao(){
        username = "";
        usertype = UserType.NONE;
        dbintf = new DBInterface();
    }
    
    public String username;
    public UserType usertype;
    public DBInterface dbintf;

}
