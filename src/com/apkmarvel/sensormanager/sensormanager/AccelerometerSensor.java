package com.apkmarvel.sensormanager.sensormanager;
/**
 * Created by john carlo franco on 12/17/2015.
 * johncarlofranco.com
 * github.com/francojohnc
 */
import android.content.Context;
import android.hardware.Sensor;


public class AccelerometerSensor extends Sensors{
	private Sensor sensor;
	public AccelerometerSensor(Context context) {
		super(context);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}
	@Override
	public Sensor sensor() {
		return sensor;
	}
}
