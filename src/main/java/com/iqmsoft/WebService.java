package com.iqmsoft;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iqmsoft.pojos.JSLibraries;
import com.iqmsoft.pojos.JSLibrary;

@Service
public class WebService {
	
	private RestTemplate restTemplate;
	
	public WebService() {
		restTemplate = new RestTemplate();
	}
	
	public JSLibraries getJavaScriptLibraries() {
		return restTemplate.getForObject("https://api.cdnjs.com/libraries/", JSLibraries.class);
	}
	
	public JSLibrary getJavaScriptLibrary(String libraryName) {
		return restTemplate.getForObject("https://api.cdnjs.com/libraries/" + libraryName, JSLibrary.class);
	}

}
