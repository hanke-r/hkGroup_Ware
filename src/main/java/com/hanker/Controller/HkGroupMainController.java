package com.hanker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HkGroupMainController {

	@RequestMapping(value="/hkGroup/main", method=RequestMethod.GET)
	public void hkMain() throws Exception{
		
	}
}
