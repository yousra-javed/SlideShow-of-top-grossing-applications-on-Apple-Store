package com.example.inclass6;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.squareup.picasso.Picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class DownloadImage extends AsyncTask<String,Void,Bitmap>{
MainActivity activity;

	public DownloadImage(MainActivity activity) {
	super();
	this.activity = activity;
}

	@Override
	protected Bitmap doInBackground(String... params) 
		
		{
			
			try {
				URL url;
				url = new URL(params[0]);
				 HttpURLConnection con;
				 con = (HttpURLConnection)url.openConnection();
				 con.setRequestMethod("GET");
				 con.connect();
				 BitmapFactory b = new BitmapFactory();
				 return b.decodeStream(con.getInputStream());
			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

             catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           
			return null;
		 
		}

	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		ImageView im = (ImageView) activity.findViewById(R.id.imageView1);
		im.setImageBitmap(result);
		
	}


	

}
