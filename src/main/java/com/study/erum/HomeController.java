package com.study.erum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
  @GetMapping("/")
  public String index() {
    return "index";	//jsp에서는 바로 출력이 안돼지만 스프링프레임워크에서는 index.jsp를 간단하게 출력이 가능하다.	
	}
	
}
