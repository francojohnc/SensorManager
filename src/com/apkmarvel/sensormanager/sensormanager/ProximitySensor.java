package com.apkmarvel.sensormanager.sensormanager;
/**
 * Created by john carlo franco on 12/17/2015.
 * johncarlofranco.com
 * github.com/francojohnc
 */
import android.content.Context;
import android.hardware.Sensor;


public class ProximitySensor extends Sensors{
	private Sensor sensor;
	public ProximitySensor(Context context) {
		super(context);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
	}
	@Override
	public Sensor sensor() {
		return sensor;
	}
}
