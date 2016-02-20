package com.apkmarvel.sensormanager;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.apkmarvel.sensormanager.sensormanager.AccelerometerSensor;
import com.apkmarvel.sensormanager.sensormanager.GryoscopeSensor;
import com.apkmarvel.sensormanager.sensormanager.LightSensor;
import com.apkmarvel.sensormanager.sensormanager.ProximitySensor;
import com.apkmarvel.sensormanager.sensormanager.Sensors;

public class MainActivity extends Activity implements OnClickListener {
	private Sensors sensors;
	private TextView txtX;
	private TextView txtY;
	private TextView txtZ;
	private Button btnGryoscope;
	private Button btnLight;
	private Button btnAccelerometer;
	private Button btnProximity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cast();
		
	}

	private void cast() {
		txtX = (TextView) findViewById(R.id.txtX);
		txtY = (TextView) findViewById(R.id.txtY);
		txtZ = (TextView) findViewById(R.id.txtZ);
		btnGryoscope = (Button) findViewById(R.id.btnGryoscope);
		btnLight = (Button) findViewById(R.id.btnLight);
		btnAccelerometer = (Button) findViewById(R.id.btnAccelerometer);
		btnProximity = (Button) findViewById(R.id.btnProximity);
		//setonclick
		btnGryoscope.setOnClickListener(this);
		btnLight.setOnClickListener(this);
		btnAccelerometer.setOnClickListener(this);
		btnProximity.setOnClickListener(this);
	}

	public SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onSensorChanged(SensorEvent event) {
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			txtX.setText("X : " + (int) x);
			txtY.setText("Y : " + (int) y);
			txtZ.setText("Z : " + (int) z);
		}

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {

		}
	};
	//onClick event
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnGryoscope:
			sensors = new GryoscopeSensor(getApplicationContext());
			sensors.unregisterListener(sensorEventListener);
			sensors.registerListener(sensorEventListener);
			break;
		case R.id.btnLight:
			sensors = new LightSensor(getApplicationContext());
			sensors.unregisterListener(sensorEventListener);
			sensors.registerListener(sensorEventListener);
			break;
		case R.id.btnAccelerometer:
			sensors = new AccelerometerSensor(getApplicationContext());
			sensors.unregisterListener(sensorEventListener);
			sensors.registerListener(sensorEventListener);
			break;
		case R.id.btnProximity:
			sensors = new ProximitySensor(getApplicationContext());
			sensors.unregisterListener(sensorEventListener);
			sensors.registerListener(sensorEventListener);
			break;
		}

	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		sensors.unregisterListener(sensorEventListener);
	}

}
