package com.multi.erp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.erp.board.BoardDTO;
import com.multi.erp.board.BoardService;
@RestController   //controller+responseBody
//@Controller
//@ResponseBody // 컨트롤러 내부에서 정의되는 메소드가 모두 json이나 String 데이터를 리턴하는 컨트롤러면 선언부에 한 번 정의해서 사용할 수있다.
@RequestMapping("/json")
public class JSONTestController {
	BoardService service;
	@Autowired
	public JSONTestController(BoardService service) {
		super();
		this.service = service;
	}
	//컨트롤러 상단에  @ResponseBody 를 선언했으므로 이 메소드 위에 @ResponseBody가 정의되어 있는 것과 동일
	//@ResponseBody는 더 이상 뷰를 응답하지 않고 response body에 스프링을 추가해서 response하겠다는 의미
	@RequestMapping("/getString")
	public String responseString() {
		return "text data";
	}
	@RequestMapping("/getJsonObj")
	public BoardDTO responseObj() {
		//리턴타입을 DTO로 명시하면 jackson-databind라이브러리가 자동으로 json object로 변환해서 리턴
		return service.getBoardInfo("6");
	}	
	@RequestMapping("/getJsonArr")
	public List<BoardDTO>  responseJsonArr() {
		//리턴타입을 DTO로 명시하면 jackson-databind라이브러리가 자동으로 json object로 변환해서 리턴
		return service.boardList();
	}	
}
