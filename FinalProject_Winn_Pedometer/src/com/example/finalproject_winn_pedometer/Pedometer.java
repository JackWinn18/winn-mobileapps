package com.example.finalproject_winn_pedometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;



public class Pedometer extends Activity {
	
	// adding cod for handler runnables and countdown app

	// Display Fields for Accelerometer 
	private TextView textViewX;
	private TextView textViewY;
	private TextView textViewZ;
	
	// Display Field for Sensitivity 
	private TextView textSensitive;
	
	// Display for Steps
	private TextView textViewSteps;
	
	// Reset Button
	private Button buttonReset;
	
	// Sensor Manager 
	private SensorManager sensorManager;
	private float acceleration;
	
	// Values to Calculate Number of Steps
	private float previousY;
	private float currentY;
	private int numSteps;
	
	// SeekBar Fields
	private SeekBar seekBar;
	private int threshold; // Point at which we want to trigger a step
	
	// Fields for timer
	private TextView textTimer; // Displays the text
	private Button buttonReset2; // Used to hold the Counter
	
	private int elapsedTime; // Used to hold the elpased Time
	
	private Handler h; // The Handler
	
	private int RATE = 1000; // milliseconds - how fast to count
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pedometer);
		
		// Bind to XML
		textTimer = (TextView)findViewById(R.id.textTimer);
		buttonReset2 = (Button)findViewById(R.id.buttonReset2);
		
		elapsedTime = 0; // Set the variable for time to 0
		
		// Initialize the Handler
		h = new Handler();
		
		count(); // Starts the count
		
		
		// Attach objects to XML View 
		textViewX = (TextView)findViewById(R.id.textViewX);
		textViewY = (TextView)findViewById(R.id.textViewY);
		textViewZ = (TextView)findViewById(R.id.textViewZ);
		
		// Attach Step and Sensitive View Objects to XML
		textViewSteps = (TextView)findViewById(R.id.textSteps);
		textSensitive = (TextView)findViewById(R.id.textViewSensitive);
		
		// Attach the resetButton to XML
		buttonReset = (Button)findViewById(R.id.buttonReset);
		
		// Attach the seekBar to XML
		seekBar = (SeekBar)findViewById(R.id.seekBar);
		
		// Set the Values on the seekBar, threshold, and threshold display
		seekBar.setProgress(10);
		seekBar.setOnSeekBarChangeListener(seekBarListener);
		threshold = 10;
		textSensitive.setText(String.valueOf(threshold));
		
		// Initialize Values
		previousY = 0;
		currentY = 0;
		numSteps = 0;
		
		// Initialize acceleration Values
		acceleration = 0.00f;
		
		// Enable the listener - We will write this later in the class
		enableAccelerometerListening();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pedometer, menu);
		return true;
	}
	
	public void buttonReset2Clicked(View v) {
		elapsedTime = 0;
	}
	
	public void count() {
		elapsedTime++; // increase the counter
		textTimer.setText(String.valueOf(elapsedTime)); // set the View
		h.postDelayed(r,  RATE); // call the Runnable
	}
	
	private Runnable r = new Runnable() {
		public void run() {
			count(); // calls the count function
		}
	}; // End Runnable r
	
	private void enableAccelerometerListening() {
		// Initialize the Sensor Manager
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
							SensorManager.SENSOR_DELAY_NORMAL);
	}
	
		private SensorEventListener sensorEventListener = 
				new SensorEventListener()
		{
		
		public void onSensorChanged(SensorEvent event)
		{	
			// Gather the values from accelerometer
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			
			// Fetch the current y
			currentY = y;
			
			// Measure if a step is taken 
			if (Math.abs(currentY - previousY) > threshold) {
				numSteps++;
				textViewSteps.setText(String.valueOf(numSteps));
			} // end if
			
			// Display the Values
			textViewX.setText(String.valueOf(x));
			textViewY.setText(String.valueOf(y));
			textViewZ.setText(String.valueOf(z));
			
			// Store the previous Y
			previousY = y;
			
		} // end onSensorChanged

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			{
				// Empty - required by Class
			}// end onAccuracy Changed
		
			
		}; // ends private inner class sensorEventListener
		
	}; // ends private inner class sensorEventListener
	
	// Called by the resetButton to set Steps count to 0 and reset the Display
	public void resetSteps(View v) {
		numSteps = 0;
		textViewSteps.setText(String.valueOf(numSteps));
	} // End method resetSteps
	
	// the inner class for the seekBarListener
	private OnSeekBarChangeListener seekBarListener = 
			new OnSeekBarChangeListener()
	{
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			// Change the threshold
			threshold = seekBar.getProgress();
			// Write to the TextView
			textSensitive.setText(String.valueOf(threshold));
		} // End Method onProgressChanged()
		
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
		} // end Method onStartTrackingTouch()
		
		public void OnStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
		} // end Method onStopTrackingTouch()

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
		
	};
	

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

	
	
