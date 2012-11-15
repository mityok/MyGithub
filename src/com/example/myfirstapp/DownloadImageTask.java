package com.example.myfirstapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

	private ImageView bmImage;

	public DownloadImageTask(ImageView bmImage) {
		this.bmImage = bmImage;
	}

	@Override
	protected Bitmap doInBackground(String... urls) {
		if(isCancelled()){
			return null;
		}
		String urldisplay = urls[0];
		Bitmap mIcon11 = null;
		try {
			InputStream in = new URL(urldisplay).openStream();
			mIcon11 = BitmapFactory.decodeStream(in);
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}
		return mIcon11;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		bmImage.setImageBitmap(result);
		String extStorageDirectory = Environment.getExternalStorageDirectory()
				.toString() + "/external_sd" + "/pics";
		OutputStream outStream = null;
		boolean isSDPresent = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
		if (!isSDPresent) {
			return;
		}
		File picsDirectory = new File(extStorageDirectory);

		picsDirectory.mkdirs();

		File file = new File(picsDirectory.toString(), "cat.jpg");
		try {
			outStream = new FileOutputStream(file);
			result.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
			outStream.flush();
			outStream.close();
		} catch (Exception e) {
		}

		File sdcard = new File(extStorageDirectory);
		if (sdcard.isDirectory()) {
			for (File child : sdcard.listFiles()) {
				Log.e("MyData", child.getName());
			}
		}

		// // Get the text file
		// File file2 = new File(sdcard, "er.jpg");
		// try {
		// BufferedReader br = new BufferedReader(new FileReader(file2));
		//
		// } catch (IOException e) {
		// Log.e("Error", "err");
		// }

	}

}
