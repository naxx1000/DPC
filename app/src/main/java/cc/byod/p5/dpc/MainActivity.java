package cc.byod.p5.dpc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void GoToPolicyManager(View view){
        Intent intentGoToSettings = new Intent(this, PolicyManager.class);
        startActivity(intentGoToSettings);
    }

}
