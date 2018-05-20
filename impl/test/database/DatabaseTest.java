
package database;

import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testaPKGen() {
        DBInternal dbint = new DBInternal();
        DBInternal.reset();
        assertEquals("PK deve ser 1", dbint.genPK(), 1);
        assertEquals("PK deve ser 2", dbint.genPK(), 2);
    }

    @Test
    public void testaIntf() {

        DBInterface dbintf = new DBInterface();
        
        dbintf.adicionar_alimento("aaa");
        dbintf.adicionar_alimento("bbb");
        dbintf.adicionar_alimento("ccc");
        dbintf.adicionar_alimento("ddd");
        
        ArrayList<String> ref1 = new ArrayList<String>();
        ref1.add("aaa"); ref1.add("bbb");
        int ref1_pk = dbintf.adicionar_refeicao( ref1 );
        
        ArrayList<String> ref2 = new ArrayList<String>();
        ref2.add("ccc"); ref2.add("ddd");
        int ref2_pk = dbintf.adicionar_refeicao( ref2 );
        
        assertNotEquals("PKs devem ser diferentes", ref1_pk, ref2_pk);

    }
    
    @Test
    public void testaDieta() {

        DBInterface dbintf = new DBInterface();
        
        ArrayList<Integer> pks = new ArrayList<Integer>();
        assertEquals(-1, dbintf.adicionar_dieta("NaoTem", pks));
        
    }
 
    @Test
    public void testaNutricionista() {

        DBInterface dbintf = new DBInterface();
        dbintf.reset();
        
        int pk1 = dbintf.adicionar_nutricionista("N1");
        int pk2 = dbintf.adicionar_nutricionista("N2");

        assertEquals(2, pk1);
        assertEquals(3, pk2);
        
    }
    
    @Test
    public void testaPaciente() {

        DBInterface dbintf = new DBInterface();
        dbintf.reset();
        
        int pk1 = dbintf.adicionar_paciente("P1");
        int pk2 = dbintf.adicionar_paciente("P2");
        
        assertEquals(2, pk1);
        assertEquals(3, pk2);
        
    }

    @Test
    public void testaRefeicao() {

        DBInterface dbintf = new DBInterface();
        
        ArrayList<String> alims = new ArrayList<String>();
        alims.add("Batata");
        alims.add("Cebola");
        alims.add("Brocolis");

        int pk = dbintf.adicionar_refeicao(alims);
        assertEquals(-1, pk); // nao adicionado ainda
        
        // adiciona alimentos
        for (String s: alims){
            dbintf.adicionar_alimento(s);
        }
        
        pk = dbintf.adicionar_refeicao(alims);
        assertEquals(6, pk);
        
    }
    
}
