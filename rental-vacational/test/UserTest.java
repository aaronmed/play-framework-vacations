import org.junit.*;

import controllers.*;
import models.Advert;
import models.Advert.*;
import models.User;
import models.User.*;

import java.util.*;
import play.test.*;

public class UserTest extends UnitTest {

	@BeforeClass
	public static void setUpUser() {
		User user = new User();
		user.username = "diego";
		user.save();
		System.out.print("Añadido");
	}
	
		
	@Test
	public void userAdded() {
		User user = User.find("byUsername", "diego").first();
		assertNotEquals(user, null);
	}
	
	@Test
	public void userDeleted() {
		User user = User.find("byUsername", "diego").first();
		user.delete();
		
		User user2 = User.find("byUsername", "diego").first();
		assertEquals(user2, null);
	}
}
