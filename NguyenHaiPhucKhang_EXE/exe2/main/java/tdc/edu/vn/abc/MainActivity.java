package tdc.edu.vn.abc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv1;
    private SensorManager sm;
    private List<Sensor> deviceSensor = null;
    private ArrayList<String> deviceSensorList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1 = findViewById(R.id.lv1);
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        deviceSensor =sm.getSensorList(Sensor.TYPE_ALL);
        for(Sensor s : deviceSensor){
            deviceSensorList.add(s.getName());
        }
        lv1.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,deviceSensorList));
    }
}
