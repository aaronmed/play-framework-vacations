import org.junit.*;

import controllers.*;
import models.Advert;
import models.Advert.*;
import models.User;
import models.User.*;

import java.util.*;
import play.test.*;

public class AdvertTest extends UnitTest {

	
	@BeforeClass
	public static void setUpAdvert() {
		Advert advert = new Advert();
		advert.address = "Alicante";
		advert.save();
	}
		
	
	@Test
	public void advertAdded() {
		Advert advert = Advert.find("byAddress", "Alicante").first();
		assertNotEquals(advert, null);
	}
	
	@Test
	public void advertDeleted() {
		Advert advert = Advert.find("byAddress", "Alicante").first();
		advert.delete();
		
		advert = Advert.find("byAddress", "Alicante").first();
		assertEquals(advert, null);
	}
}