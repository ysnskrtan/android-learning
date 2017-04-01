package co.mobita.android.objectexerciseapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText("Changed Text");
        text.setTextColor(Color.RED);
        text.setTextSize(36);
        text.setX(120);
        text.setY(300);
        setContentView(text);

        //setContentView(R.layout.activity_main);
    }
}
