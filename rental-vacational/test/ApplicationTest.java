import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Scope.RenderArgs;

public class ApplicationTest extends FunctionalTest {

	@Test
    public void testHomePage() {
        Response response = GET("/home");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
    @Test
    public void testLoginPage() {
        Response response = GET("/login");
        assertStatus(200, response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
}