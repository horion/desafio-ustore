package rest;

import controller.HDController;
import controller.MemoryController;
import service.HDService;
import service.MemoryService;
import spark.Spark;

public class Main {
	
	public static void main(String[] args) {
		enableCORS("*", "*", "*");
	 	new HDController(new HDService());
	 	new MemoryController(new MemoryService());
	 	
	 	
    }
	private static void enableCORS(final String origin, final String methods, final String headers) {

	    Spark.options("/*", (request, response) -> {

	        String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
	        if (accessControlRequestHeaders != null) {
	            response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
	        }

	        String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
	        if (accessControlRequestMethod != null) {
	            response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
	        }

	        return "OK";
	    });

	    Spark.before((request, response) -> {
	        response.header("Access-Control-Allow-Origin", origin);
	        response.header("Access-Control-Request-Method", methods);
	        response.header("Access-Control-Allow-Headers", headers);
	        // Note: this may or may not be necessary in your particular application
	        response.type("application/json");
	    });
	}
		
}
