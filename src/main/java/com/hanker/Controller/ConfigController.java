package com.hanker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConfigController {
	
	
	@RequestMapping(value="/config/listView", method=RequestMethod.GET)
	public void listView() throws Exception{
		
	}

}
