package controller;

import static spark.Spark.get;
import static utils.JsonUtil.json;

import service.MemoryService;

public class MemoryController {

	public MemoryController(final MemoryService memoryService) {
		 get("/memoria", (req, res) -> memoryService.retornaTodosOsDado(), json());
	}

}
