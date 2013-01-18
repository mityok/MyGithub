package com.example.myfirstapp;

import android.os.*;
import android.app.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.view.*;
public class ListViewActivity extends ListActivity
{
static final String[] LIST=new String[]{"1","2","3"};
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_list,LIST));
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener(){

				public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
				{
					Toast.makeText(getApplicationContext(),((TextView)view).getText(),Toast.LENGTH_SHORT).show();
				}
				
			
		});
    }
}
