package com.example.rpggen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class uploadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);
    }

    public void uploaded(View view) {

        EditText name = findViewById(R.id.name);
        EditText desc = findViewById(R.id.desc);

        Bundle extras = getIntent().getExtras();
        String hp = extras.getString(generatorActivity.hpPoint);
        String mp = extras.getString(generatorActivity.mpPoint);
        String dex = extras.getString(generatorActivity.dexPoint);
        String str = extras.getString(generatorActivity.strPoint);
        String lck = extras.getString(generatorActivity.lckPoint);
        String chr = extras.getString(generatorActivity.chrPoint);
        String race = extras.getString(generatorActivity.charRace);
        String Class = extras.getString(generatorActivity.charClass);
        String age = extras.getString(generatorActivity.charAge);
        String gender = extras.getString(generatorActivity.charGender);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(generatorActivity.hpPoint, hp);
            jsonObject.put(generatorActivity.mpPoint, mp);
            jsonObject.put(generatorActivity.strPoint, str);
            jsonObject.put(generatorActivity.dexPoint, dex);
            jsonObject.put(generatorActivity.lckPoint, lck);
            jsonObject.put(generatorActivity.chrPoint, chr);
            jsonObject.put(generatorActivity.charRace, race);
            jsonObject.put(generatorActivity.charClass, Class);
            jsonObject.put(generatorActivity.charAge, age);
            jsonObject.put(generatorActivity.charGender, gender);
            jsonObject.put(generatorActivity.charName, name.getText().toString());
            jsonObject.put(generatorActivity.charDesc, desc.getText().toString());
            Toast.makeText(getApplicationContext(), "Sikeres feltöltés!",
                    Toast.LENGTH_LONG).show();
            finish();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void mainMenu(View view) {
        finish();
    }
}
