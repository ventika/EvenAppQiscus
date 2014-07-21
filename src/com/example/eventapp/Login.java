package com.example.eventapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	Button bsignin;
	EditText inuser, inpass;
	
	String username = "ventika";
	String password = "ventika123";
	String preferencename = "DataPreference";
	
	SharedPreferences sp;
	SharedPreferences.Editor spe;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sp = this.getSharedPreferences(preferencename,  0);
		spe = sp.edit();
		
		bsignin = (Button) findViewById(R.id.bsignin);
		inuser = (EditText) findViewById(R.id.inusername);
		inpass = (EditText) findViewById(R.id.inpassword);
		
		bsignin.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String u = inuser.getText().toString();
				String p = inpass.getText().toString();
				
				if (!u.equals("") && !p.equals("")){
					matching(u,p);
				}else{
					ShowToast("fill the field. pleas...");
				}
			}
		});
		
		if (sp.contains("username") && sp.contains("password")){
			GoestoNextActivity();
		}
	}
	
	protected void matching(String u, String p){
		if (u.equals(username) && p.equals(password)) {
			spe.putString("username", u);
			spe.putString("password", p);
			spe.commit();
			GoestoNextActivity();
		}else{
			ShowToast("wrong username and password");
			spe.clear();
		}
	}
	
	protected void ShowToast (String pesan){
		Toast.makeText(getApplicationContext(), pesan, Toast.LENGTH_SHORT).show();
	}
	
	private void GoestoNextActivity(){
		Intent intent = new Intent (Login.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}