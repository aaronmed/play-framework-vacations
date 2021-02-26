import org.junit.*;

import controllers.*;
import models.User;
import models.User.*;

import java.util.*;
import play.test.*;

public class BasicTest extends UnitTest {

	@Test
	public void aVeryImportantThingToTest() {
		assertEquals(2, 1 + 1);
	}

	@Test
	public void login() {
		User u = new User();
		u.username = "aaron";
		u.setPassword("12345");
		u.name = "Aaron";
		u.surname = "Medina";
		u.dni = "45781816V";
		u.telephone = "60676467";
		
		assertEquals(u.username, "aaron");
	}

}
