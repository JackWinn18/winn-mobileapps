package com.example.standardtometric;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// All work Here is honestly obtained and is my own. Jack Winn

public class MainActivity extends Activity {
	
	// Fields
	private Button buttonConvert1;
	private Button buttonConvert2;
	private Button buttonConvert3;
	private EditText editTextM;
	private EditText editTextG;
	private EditText editTextI;
	private EditText editTextK;
	private EditText editTextL;
	private EditText editTextC;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Bind to XML Objects 
        buttonConvert1 = (Button)findViewById(R.id.buttonConvert1);
        buttonConvert2 = (Button)findViewById(R.id.buttonConvert2);
        buttonConvert3 = (Button)findViewById(R.id.buttonConvert3);
        editTextK = (EditText)findViewById(R.id.editTextK);
        editTextL = (EditText)findViewById(R.id.editTextL);
        editTextC = (EditText)findViewById(R.id.editTextC);
        editTextM = (EditText)findViewById(R.id.editTextM);
        editTextG = (EditText)findViewById(R.id.editTextG);
        editTextI = (EditText)findViewById(R.id.editTextI);
    }
    
    public void buttonConvert1Clicked(View v) {
    	Editable input = editTextM.getText();
    	String inputString = String.valueOf(input);
    	float miles = Float.valueOf(inputString);
    	
    	float kilo = (float) (miles * 1.61);
    	
    	editTextK.setText(String.valueOf(kilo));
    }
    
    public void buttonConvert2Clicked(View v) {
    	Editable input = editTextG.getText();
    	String inputString = String.valueOf(input);
    	float gallons = Float.valueOf(inputString);
    	
    	float liters = (float) (gallons * 3.8);
    	
    	editTextL.setText(String.valueOf(liters));
    	
    }
    
    public void buttonConvert3Clicked(View v) {
    	Editable input = editTextI.getText();
    	String inputString = String.valueOf(input);
    	float inches = Float.valueOf(inputString);
    	
    	float centimeters = (float) (inches * 2.54);
    	
    	editTextC.setText(String.valueOf(centimeters));
    	
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
