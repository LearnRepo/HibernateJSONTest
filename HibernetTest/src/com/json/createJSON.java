package com.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hiber.PersistantTest;

public class createJSON {
	
	String str = null;
	@SuppressWarnings("unchecked")
	public createJSON(List<PersistantTest> ls)
	{	JSONObject jObj;
		JSONArray jArr = new JSONArray();
		for(PersistantTest PT: ls)
		{
			jObj = new JSONObject();
			jObj.put("City", PT.getCity());
			jObj.put("UserName", PT.getUserName());
			jObj.put("Email", PT.getEmail());
			jArr.add(jObj);
		}
		//System.out.print(jArr);
		str = jArr.toString();
		PrintWriter out;
		try {
			out = new PrintWriter("D:\\File1.json");
			out.print(jArr);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getJson()
	{
		return str;
	}
}
