package com.example.mamn01_individuell_uppgift;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {


    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    boolean haveSensor = false;
    private boolean mLastAccelerometerSet = false;
    private float[] mLastAccelerometer = new float[3];
    TextView txt_x;
    TextView txt_y;
    TextView txt_z;
    static final float ALPHA = 0.25f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        txt_x = (TextView) findViewById(R.id.txt_x);
        txt_y = (TextView) findViewById(R.id.txt_y);
        txt_z = (TextView) findViewById(R.id.txt_z);
    }

    private void start() {
        if ((mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null)) {
            noSensorsAlert();
        }
        else {
            mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            haveSensor = mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //System.arraycopy(event.values, 0, mLastAccelerometer, 0, event.values.length);
            mLastAccelerometer = lowPass(event.values.clone(), mLastAccelerometer);
            mLastAccelerometerSet = true;
        }

        if (mLastAccelerometerSet) {
            txt_x.setText("X: " + mLastAccelerometer[0]);
            txt_y.setText("Y: " + mLastAccelerometer[1]);
            txt_z.setText("Z: " + mLastAccelerometer[2]);
        }



    }

    protected float[] lowPass( float[] input, float[] output ) {
        if ( output == null ) return input;
        for ( int i=0; i<input.length; i++ ) {
            output[i] = output[i] + ALPHA * (input[i] - output[i]);
        }
        return output;
    }

    public void noSensorsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Your device doesn't support the Accelerometer.")
                .setCancelable(false)
                .setNegativeButton("Close",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        alertDialog.show();
    }

    public void stop() {
        if(haveSensor){
            mSensorManager.unregisterListener(this,mAccelerometer);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        start();
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
