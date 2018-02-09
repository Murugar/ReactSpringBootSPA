package com.iqmsoft;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.pojos.JSLibrary;

@RestController
@RequestMapping("/api")
public class MyRestController {

	@Autowired
	private WebService service;

	public MyRestController(WebService service){
		this.service = service;
	}

	@GetMapping("/libraries")
	public Collection<JSLibrary> libraries() {
		return service.getJavaScriptLibraries().getResults();
	}

	@GetMapping("/libraries/{name}")
	public JSLibrary library(@PathVariable String name) {
		return service.getJavaScriptLibrary(name);
	}
}
