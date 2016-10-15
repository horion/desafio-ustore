package controller;

import static spark.Spark.*;

import service.CPUService;
import spark.Request;
import spark.Response;
import spark.Route;

public class CPUController {

	public CPUController(final CPUService cpuService) {
		get("/cpu", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				return cpuService.retornaTodosOsDado();
			}
		});
	}

}
