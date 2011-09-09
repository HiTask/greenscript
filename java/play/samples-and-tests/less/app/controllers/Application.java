package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void processStatic() {
        render();
    }
    
    public static void jobStatus() {
        response.print(CorePlugin.computeApplicationStatus(request.path.contains(".json")));
    }

}