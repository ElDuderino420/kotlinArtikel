package dk.cphbusiness.masterdetailtemplate

import android.content.Context
import android.content.Intent
import android.hardware.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

fun String.times(count: Int) : String {
    var result = this;
    for (i in 2..count) {
        result += this
        }
    return result
    }

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

class MainActivity : AppCompatActivity(), SensorEventListener{

    var text: TextView? = null
    var header: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        header = findViewById(R.id.headerText) as TextView
        var sm: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager;

        /*
        var accelerometer: Sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        val registerListener = sm.registerListener(this as SensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        text = findViewById(R.id.Text) as TextView
        header?.text = "acceleration";
        */
        ///*
        var gyroscope: Sensor = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sm.registerListener(this as SensorEventListener, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        text = findViewById(R.id.Text) as TextView
        header?.text = "Gyroscope";
        //*/
    }
    override fun onSensorChanged(sensorEvent: SensorEvent) {

        text?.text = "X: " + sensorEvent.values[0] +
                "\nY: " + sensorEvent.values[1] +
                "\nZ: " + sensorEvent.values[2];


    }

    override fun onAccuracyChanged(sensor: Sensor, i: Int) {

    }







    }
