package test.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONMakerExam {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		JSONObject myjson = new JSONObject();
		myjson.put("name", "김서연");
		myjson.put("age", "20");
		System.out.println(myjson.toJSONString());

		JSONArray subjectlist = new JSONArray();
		subjectlist.add("자바");
		subjectlist.add("하둡");
		subjectlist.add("시큐어코딩");
		
		JSONArray addrlist = new JSONArray();
		JSONObject comment1 = new JSONObject();
		comment1.put("zip", "111-222");
		comment1.put("addr1", "인천시");

		addrlist.add(comment1);
		
		JSONArray historylist = new JSONArray();
		JSONObject history1 = new JSONObject();
		history1.put("subject", "java");
		history1.put("month", "11");
		
		JSONObject history2 = new JSONObject();
		history2.put("subject", "servlet");
		history2.put("month", "12");
		
		historylist.add(history1);
		historylist.add(history2);
		

		myjson.put("subject", subjectlist);
		myjson.put("addr", addrlist);
		myjson.put("history", historylist);

		System.out.println(myjson.toJSONString());
		
		FileWriter fw = new FileWriter("src/main/java/test/json/myjson2.json");
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
	}

}
