package com.example.eventapp;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;


public class MainActivity extends Activity {
	
	private ListView ListViewAcara;
	private ArrayList<Acara> ListAcara = new ArrayList<Acara>();
	private EventAdapter eventAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        ListViewAcara = (ListView) findViewById(R.id.listView1);
        
        eventAdapter = new EventAdapter(this, R.layout.item_event, ListAcara);
        ListViewAcara.setAdapter(eventAdapter);
        
        GetEvent getEvent = new GetEvent(){

			@Override
			public void respon(String respons) {
				// TODO Auto-generated method stub
				System.out.println(respons);
				
				try {
					JSONObject objEvent=new JSONObject(respons);
					JSONArray arrayEvent=objEvent.getJSONArray("listEvent");
					
					for (int i = 0; i < arrayEvent.length(); i++) {
						JSONObject objectAcara = arrayEvent.getJSONObject(i);
						
						String namaAcara=objectAcara.getString("title");
						String tanggal=objectAcara.getString("date");
						String jam=objectAcara.getString("time");
						
						Acara singleAcara=new Acara(namaAcara, tanggal, jam);
						ListAcara.add(singleAcara);
					}
					eventAdapter.notifyDataSetChanged();
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
        	
        };
        getEvent.execute("http://www.koreatoday.info/api/v1/event");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}