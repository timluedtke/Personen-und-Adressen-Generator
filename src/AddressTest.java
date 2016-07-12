import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test
	public void testAddress() {
		for(int i=0;i<1000000;i++){
			int hsnumber = Address.generateHousenumber();		
			assertTrue("Housenumber is 0!! @"+i, hsnumber != 0);
		}

	}

}
