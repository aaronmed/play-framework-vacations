package controllers;

import play.*;
import play.mvc.*;

import java.util.*;


public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void enterDemo(String user) {        
    	Chat.index(user);
    }
}