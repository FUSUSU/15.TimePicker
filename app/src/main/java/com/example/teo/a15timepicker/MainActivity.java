package com.example.teo.a15timepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TimePicker timePicker1;
    Button changetime1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        textView1 = (TextView) findViewById(R.id.textView1);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        changetime1 = (Button) findViewById(R.id.button1);
        //Cài đặt hiển thị chế độ 24h
        timePicker1.setIs24HourView(true);

        //Hiển thị thời gian hiện tại ra textView1
        textView1.setText(getCurrentTime());

        //Bắt sự kiện button
        changetime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(getCurrentTime());
            }
        });
    }

    //Hàm lấy thời gian từ TimePicker
    public String getCurrentTime() {
        //API 23 trở lên không sử dụng getCurrentHour() nữa mà thay vào đó là getHour()
        String currentTime = "Current Time: "+timePicker1.getCurrentHour()+":"+timePicker1.getCurrentMinute();
        return currentTime;
    }

    //Menu item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
