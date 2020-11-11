package com.hanker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreeBoardController {

	
	@RequestMapping(value="/frBoard/frBoardMain", method=RequestMethod.GET)
	public void frBoardMain() throws Exception{
		
	}
}
