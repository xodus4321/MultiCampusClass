package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = "/index.do")
	public String showIndexPage() {
		return "index";
	}

	@RequestMapping(value = "/menu/board.do")
	public String boardPage() {
		return "menu/board";

	}	
}
