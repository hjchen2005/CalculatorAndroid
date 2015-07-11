package com.GottaApp.calculator;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends ActionBarActivity {
	private Button button;
	private EditText editText1, editText2, editText3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button=(Button)this.findViewById(R.id.button1);
		editText1=(EditText)this.findViewById(R.id.editText1);
		editText2=(EditText)this.findViewById(R.id.editText2);
		editText3=(EditText)this.findViewById(R.id.editText3);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,NextActivity.class);
				String a = editText1.getText().toString().trim();
				String b= editText2.getText().toString().trim();
				intent.putExtra("message", a + " + " + b + "  = " + "?");
				startActivityForResult(intent, 1000);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		//return result from NextActivity
		if (requestCode == 1000 && resultCode == 1001){
			String result_value = data.getStringExtra("result");
			editText3.setText(result_value);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
