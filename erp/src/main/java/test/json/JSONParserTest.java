package test.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



//.json파일을 JSONAaaray나 JSONObject로 변환하는 작업
public class JSONParserTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//1. json parser를 생성
		//	=>json문자열을 분석할 수 있는 객체
		JSONParser parser = new JSONParser();
		//2. json문자열 파싱하기
		JSONObject root = (JSONObject)parser.parse(new FileReader("src/main/java/test/json/myjson.json"));
		//3.json object에서 데이터 읽기
		String name =(String)root.get("name");
		String age =(String)root.get("age");
		System.out.println("name=>"+name+"age=>"+age);
		
		//4.JSONArray에서 데이터 읽기
		JSONArray subjectlist = (JSONArray) root.get("subject");
		for(int i=0;i<subjectlist.size();i++) {
			String subject =(String)subjectlist.get(i);
			System.out.println("subject"+subject);
		}
		JSONArray commentlist = (JSONArray) root.get("comment");
        for(int i=0; i<commentlist.size(); i++) {
            JSONObject comment = (JSONObject) commentlist.get(i);
            System.out.println("no : "+comment.get("no"));
            System.out.println("id : "+comment.get("id"));
            System.out.println("content : "+comment.get("content"));
            System.out.println("===================================================");
        }
	}
}
