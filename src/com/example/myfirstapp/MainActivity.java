package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.*;

public class MainActivity extends Activity {

    private DownloadImageTask downloadImageTask;

	public String EXTRA_MESSAGE="message";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadImageTask = new DownloadImageTask((ImageView) findViewById(R.id.img));
		downloadImageTask
        .execute("http://fc03.deviantart.net/fs28/f/2008/071/5/7/Cat_by_AWhisperOfLove.jpg");//"http://uhaweb.hartford.edu/aschmidt/kitten11.jpg");
		
    }
	 public void selfDestruct(View view) {
	    if(downloadImageTask!=null){
	    	downloadImageTask.cancel(true);
	    	Toast.makeText(getApplicationContext(), "stop", 5000).show();
	    }
	 }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	public void openList(View view){
		Intent intent = new Intent(this, ListViewActivity.class);  
		intent.putExtra(EXTRA_MESSAGE, "message"); 
		startActivity(intent);
	}
}
