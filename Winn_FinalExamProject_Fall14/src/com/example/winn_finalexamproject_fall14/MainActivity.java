package com.example.winn_finalexamproject_fall14;

// Jack Winn - All work here is honestly obtained and is my own.

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends Activity {
	
	//Fields
	private Button buttonDollars;
	private Button buttonYen;
	private Button buttonPounds;
	private EditText editTextDollars;
	private EditText editTextYen;
	private EditText editTextPounds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Bind to XML
		buttonDollars = (Button)findViewById(R.id.buttonDollars);
		buttonYen = (Button)findViewById(R.id.buttonYen);
		buttonPounds = (Button)findViewById(R.id.buttonPounds);
		editTextDollars = (EditText)findViewById(R.id.editTextDollars);
		editTextYen = (EditText)findViewById(R.id.editTextYen);
		editTextPounds = (EditText)findViewById(R.id.editTextPounds);

	}
	
	public void buttonDollarsClicked(View v) {
		// Get Data from textView
		Editable input = editTextDollars.getText();
		// Convert to a string
		String inputString = String.valueOf(input);
		// Convert to a Float
		float Dollars = Float.valueOf(inputString);
		
		// Do the math
		float Yen = (float) (Dollars * 97.35);
		// Not sure about the pounds
		float Pounds = (float) (Dollars * .62);
		
		// Convert to String and Display
		editTextYen.setText(String.valueOf(Yen));
		editTextPounds.setText(String.valueOf(Pounds));
		
	}
	
	public void buttonYenClicked(View v) {
		Editable input = editTextYen.getText();
		String inputString = String.valueOf(input);
		float Yen = Float.valueOf(inputString);
		
		float Dollars = (float) (Yen * .0102);
		float Pounds = (float) (Yen * .01);
		
		editTextDollars.setText(String.valueOf(Dollars));
		editTextPounds.setText(String.valueOf(Pounds));
		
	}
	
	public void buttonPoundsClicked(View v) {
		Editable input = editTextPounds.getText();
		String inputString = String.valueOf(input);
		float Pounds = Float.valueOf(inputString);
		
		float Dollars = (float) (Pounds * 1.61);
		float Yen = (float) (Pounds * 100);
		
		editTextDollars.setText(String.valueOf(Dollars));
		editTextYen.setText(String.valueOf(Yen));
		
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
