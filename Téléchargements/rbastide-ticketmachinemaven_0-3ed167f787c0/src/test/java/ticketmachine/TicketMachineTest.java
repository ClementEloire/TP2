package ticketmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@Before
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation
	public void priceIsCorrectlyInitialized() {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
		assertEquals("Initialisation incorrecte du prix", PRICE, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals("La balance n'est pas correctement mise à jour", 10 + 20, machine.getBalance()); // Les montants ont été correctement additionnés               
	}
        
        @Test
        // S3 : 
        public void Test3(){
            machine.insertMoney(40);
            assertFalse(machine.printTicket());
        }
        
        @Test
        // S3 : 
        public void Test4(){
            machine.insertMoney(50);
            assertTrue(machine.printTicket());
        }
        
        @Test
        // S3 : 
        public void Test5(){
            machine.insertMoney(70);
            machine.printTicket();
            assertEquals(20,machine.getBalance());
        }
       
        @Test
        // S6 : 
        public void Test6a(){
        machine.insertMoney(50);
        assertEquals(0,machine.getTotal());
        }
        
        
        @Test
        // S6 : 
        public void Test6b(){
        machine.insertMoney(50);
        machine.printTicket();
        assertEquals(50,machine.getTotal());
        }
        
        @Test
        //
        public void Test7(){
            machine.insertMoney(70);
            assertEquals(70,machine.refund());
            
        }
        @Test
        //
        public void Test8(){
            machine.insertMoney(70);
            machine.refund();
            assertEquals(0,machine.getBalance());
        }
        
        @Test(expected = IllegalArgumentException.class )
        //
        public void Test9() {
            machine.insertMoney(-70);
        }
        
        @Test(expected = IllegalArgumentException.class )
        public void Test10() {
          TicketMachine machine2 = new TicketMachine(-70);
        }
}
