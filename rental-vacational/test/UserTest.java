import org.junit.*;

import controllers.*;
import models.Advert;
import models.Advert.*;
import models.User;
import models.User.*;

import java.util.*;
import play.test.*;

public class UserTest extends UnitTest {

	@Before
	public void setUpUser() {
		Fixtures.loadModels("user.yml");
	}
		
	@Test
	public void findByUser() {
		User user = User.find("byUsername", "diegarc").first();
		assertNotEquals(user, null);
	}
}
