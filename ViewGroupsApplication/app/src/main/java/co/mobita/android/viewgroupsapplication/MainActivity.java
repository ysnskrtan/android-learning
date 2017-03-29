package co.mobita.android.viewgroupsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Uncomment layout which want to run

        // 1. Linear Layout
        //setContentView(R.layout.activity_main);

        // 2. Relative Layout
        setContentView(R.layout.rel_layout);
    }
}
