package com.example.rpggen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class generatedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.generated);

        TextView health = findViewById(R.id.health);
        TextView magicka = findViewById(R.id.magicka);
        TextView strength= findViewById(R.id.strength);
        TextView dexterity= findViewById(R.id.dexterity);
        TextView charisma = findViewById(R.id.charisma);
        TextView luck = findViewById(R.id.luck);
        TextView Races = findViewById(R.id.race);
        TextView Classes= findViewById(R.id.Classes);
        TextView ageValue = findViewById(R.id.age);
        TextView genderType = findViewById(R.id.genderType);

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

        health.setText(hp);
        magicka.setText(mp);
        strength.setText(str);
        dexterity.setText(dex);
        charisma.setText(chr);
        luck.setText(lck);
        Races.setText(race);
        Classes.setText(Class);
        ageValue.setText(age);
        genderType.setText(gender);
    }

    public void generateOtherChar(View view) {
        finish();
        Intent intent = new Intent(this, generatorActivity.class);
        startActivity(intent);
    }

    public void mainMenu(View view) {
        finish();
    }

    public void upload(View view) {

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

        finish();
        Intent intent = new Intent(this, uploadActivity.class);
        intent.putExtra(generatorActivity.hpPoint, hp);
        intent.putExtra(generatorActivity.mpPoint, mp);
        intent.putExtra(generatorActivity.dexPoint, dex);
        intent.putExtra(generatorActivity.strPoint, str);
        intent.putExtra(generatorActivity.lckPoint, lck);
        intent.putExtra(generatorActivity.chrPoint, chr);
        intent.putExtra(generatorActivity.charAge, age);
        intent.putExtra(generatorActivity.charRace, race);
        intent.putExtra(generatorActivity.charClass, Class);
        intent.putExtra(generatorActivity.charGender, gender);
        startActivity(intent);
    }

}
