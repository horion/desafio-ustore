package controller;

import static spark.Spark.get;
import static utils.JsonUtil.json;

import service.HDService;

public class HDController {
	public HDController(final HDService hdService) {
		 get("/hd", (req, res) -> hdService.retornaTodosOsDados(), json());
	}
}
