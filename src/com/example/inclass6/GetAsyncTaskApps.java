package com.example.inclass6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONException;

import com.squareup.picasso.Picasso;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class GetAsyncTaskApps extends AsyncTask<String,Void,ArrayList<App>>{
MainActivity activity;
ProgressDialog pd1;
Handler handler;
int i=0;
App app;
TextView title ;
TextView summary;
TextView category;
TextView price;
	public GetAsyncTaskApps(MainActivity activity) {
	super();
	this.activity = activity;

}

	public GetAsyncTaskApps() {
	super();
	// TODO Auto-generated constructor stub
}

	@Override
	protected ArrayList<App> doInBackground(String... params) {
		try
		{
			URL url = new URL(params[0]);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("GET");
			con.connect();
			int statusCode = con.getResponseCode();
			if(statusCode == HttpURLConnection.HTTP_OK)
			{
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line = reader.readLine();
				while(line !=null)
				{
					sb.append(line);
					line = reader.readLine();
					
				}
				return AppUtil.AppJsonParser.parseApps(sb.toString());
				
			}			
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch(ProtocolException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(final ArrayList<App> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		pd1.dismiss();

       title = (TextView)activity.findViewById(R.id.textView3);
       price = (TextView)activity.findViewById(R.id.textView2);
       category = (TextView)activity.findViewById(R.id.textView1);
       summary = (TextView)activity.findViewById(R.id.textView4);
       handler = new Handler();
       handler.postDelayed(new Runnable() {
           public void run() {
        	   app = result.get(i);
               title.setText(app.getName());
               price.setText(app.getPrice());
               category.setText(app.getCategory());
               summary.setText(app.getSummary().split("\n")[0]);
               ImageView im = (ImageView) activity.findViewById(R.id.imageView1);
               Picasso.with(activity).load(app.getLink()).into(im);
               i++;
               if(i==200)
            	   i=0;
               handler.postDelayed(this, 3000); //now is every 3 secs
           }
        }, 3000);
       
	        
   
	}


	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		
		pd1 =  new ProgressDialog(activity);
		pd1.setTitle("Loading Apps");
		pd1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd1.setCancelable(false);
		pd1.show();
		super.onPreExecute();

	}

	
}
