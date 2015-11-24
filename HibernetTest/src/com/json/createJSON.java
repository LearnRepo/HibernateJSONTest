package com.json;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hiber.PersistantTest;

public class createJSON {
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
		System.out.print(jArr);
	}
}
