package com.apkmarvel.sensormanager.sensormanager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
public abstract class Sensors {
	protected SensorManager sensorManager;
	public abstract Sensor sensor();
	Sensors(Context context) {
		sensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
	}
	public void registerListener(SensorEventListener sensorEventListener){
		if(sensorManager!=null)sensorManager.registerListener(sensorEventListener, sensor(),SensorManager.SENSOR_DELAY_NORMAL);
	}
	public void unregisterListener(SensorEventListener sensorEventListener){
		if(sensorManager!=null)sensorManager.unregisterListener(sensorEventListener);
	}
}
