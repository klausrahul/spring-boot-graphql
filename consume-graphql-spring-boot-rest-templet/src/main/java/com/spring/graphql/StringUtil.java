package com.spring.graphql;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//hello "world"
		System.out.println("Hello \"World\" ");
		
		
		int bookId = 1;
		
		String variables = String.format("{ \"bookId\": %d }", bookId);
		System.out.println(variables);
		

		String query = "query($bookId:Int){\n"
				+ "getBook(bookId:$bookId){\n"
				+ "id\n"
				+"title\n"
				+ "}\n"
				+ "}";
		System.out.println(query);
		
		
		//'{"query":"query($bookId:Int){\r\n    getBook(bookId:$bookId){\r\n        id\r\n        title\r\n    }\r\n}\r\n\r\n"
		//,"variables":{"bookId":2}}'
		String end=String.format("{ \"query\" : \"%s\", \"variables\": %s }", query,variables);
		System.out.println(end);
	}

}
