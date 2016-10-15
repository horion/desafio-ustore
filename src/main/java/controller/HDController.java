package controller;

import static spark.Spark.*;

import service.HDService;
import spark.Request;
import spark.Response;
import spark.Route;

public class HDController {
	public HDController(final HDService hdService) {
		get("/hd", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				return hdService.retornaTodosOsDados();
			}
		});
	}
}
