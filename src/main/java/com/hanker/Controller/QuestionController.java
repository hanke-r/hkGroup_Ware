package com.hanker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController {
	
	@RequestMapping(value="/question/qsBoardMain", method=RequestMethod.GET)
	public void qsBoardMain() throws Exception{
		
	}
}
