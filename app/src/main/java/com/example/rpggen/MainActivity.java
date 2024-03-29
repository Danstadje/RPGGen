package com.example.rpggen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void generateChar(View view) {
        Intent intent = new Intent(this, generatorActivity.class);
        startActivity(intent);

    }

    public void generatedList(View view) {
        Intent intent = new Intent(this, charListActivity.class);
        startActivity(intent);
    }

    public void exit(View view) {
        finish();
    }

}
