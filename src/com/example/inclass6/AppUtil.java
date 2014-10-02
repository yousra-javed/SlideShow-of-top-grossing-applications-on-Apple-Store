package com.example.inclass6;

import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class AppUtil {

	static public class AppJsonParser{
		static ArrayList<App> parseApps(String in) throws JSONException
		{

			ArrayList<App> appsList = new ArrayList<App>();
			JSONObject root = new JSONObject(in);
			root = root.getJSONObject("feed");
			
			JSONArray appsJSONArray = root.getJSONArray("entry");
			
			for(int i=0; i<appsJSONArray.length(); i++)
			{
				JSONObject appsJSONObject = appsJSONArray.getJSONObject(i);
				App app = new App();
				app.setName(appsJSONObject.getJSONObject("title").getString("label"));
				
				app.setCategory(appsJSONObject.getJSONObject("category").getJSONObject("attributes").getString("term"));
				app.setPrice(appsJSONObject.getJSONObject("im:price").getString("label"));
				app.setLink(appsJSONObject.getJSONArray("im:image").getJSONObject(2).getString("label"));
				app.setSummary(appsJSONObject.getJSONObject("summary").getString("label"));
				
				
				appsList.add(app);
			}
			return appsList;
			
		}
	}
}
