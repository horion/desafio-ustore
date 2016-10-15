package rest;

import controller.CPUController;
import controller.HDController;
import service.CPUService;
import service.HDService;

public class Main {
	
	public static void main(String[] args) {
	 	new HDController(new HDService());
	 	new CPUController(new CPUService());
    }
		
}
