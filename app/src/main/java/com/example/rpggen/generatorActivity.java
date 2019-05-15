package com.example.rpggen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class generatorActivity extends AppCompatActivity {

    public static final String hpPoint = "hp";
    public static final String mpPoint = "mp";
    public static final String strPoint = "str";
    public static final String dexPoint = "dex";
    public static final String lckPoint = "lck";
    public static final String chrPoint = "chr";
    public static final String charRace = "race";
    public static final String charClass = "Class";
    public static final String charAge = "age";
    public static final String charGender = "gender";
    public static final String charName = "name";
    public static final String charDesc = "description";

    public void generated(View view) {
        final int a = -1;
        String race = ((Spinner) findViewById(R.id.raceSpinner)).getSelectedItem().toString();
        String Class = ((Spinner) findViewById(R.id.classSpinner)).getSelectedItem().toString();
        RadioGroup genders = findViewById(R.id.genderButton);
        int selectedGender = genders.getCheckedRadioButtonId();
        View gender = genders.findViewById(selectedGender);
        int genderId = genders.indexOfChild(gender);
        RadioButton Chosen = (RadioButton) genders.getChildAt(genderId);
        String chosen = (String) Chosen.getText();
        Random r = new Random();
        int hp = (r.nextInt(7-3) + 1) * 10;
        int mp = (r.nextInt(7-3) + 1) * 5;
        int str = r.nextInt(7-3) + 1;
        int dex = r.nextInt(7-3) + 1;
        int lck = r.nextInt(7-3) + 1;
        int chr = r.nextInt(7-3) + 1;
        int i = 25;
        String hpPoints;
        String mpPoints;
        String strPoints;
        String dexPoints;
        String lckPoints;
        String chrPoints;
        String ageNum;
        EditText ageText = (EditText) findViewById(R.id.editAge);
        if (ageText.getText().toString().length() > 0) {
            Integer agenum = Integer.parseInt(ageText.getText().toString());
            if (i < agenum) {
                while (i < agenum) {
                    hp-=10;
                    mp+=5;
                    str-=1;
                    dex-=1;
                    lck+=1;
                    chr+=1;
                    i+=25;
                }
            }
            else if (agenum > 18) {
                while (i > agenum) {
                    hp += 10;
                    mp -= 5;
                    str += 1;
                    dex += 1;
                    lck += 1;
                    chr -= 1;
                    agenum += 25;
                }
            }

            switch(race){
                case "ember":
                    str+=1;
                    dex+=1;
                    lck+=1;
                    chr+=1;
                    break;
                case "törpe":
                    hp+=30;
                    mp-=5;
                    if (mp<5) {
                        mp=5;
                    }
                    str+=3;
                    dex-=1;
                    if (dex<1) {
                        dex=1;
                    }
                    break;
                case "tündér":
                    hp-=10;
                    if (hp<10) {
                        hp = 10;
                    }
                    str-=1;
                    if (str<1) {
                        str=1;
                    }
                    mp+=25;
                    dex+=1;
                    break;
                case "farkasember":
                    mp-=10;
                    if (mp<5) {
                        mp=5;
                    }
                    hp-=10;
                    if (hp<10) {
                        hp=10;
                    }
                    dex+=3;
                    lck+=1;
                    chr+=3;
                    break;
            }

            switch(Class){
                case "Harcos":
                    hp+=20;
                    str+=2;
                    break;
                case "Íjász":
                    dex+=2;
                    lck+=2;
                    break;
                case "Mágus":
                    mp+=10;
                    chr+=2;
                    break;
                case "Pap":
                    mp+=10;
                    chr+=1;
                    lck+=1;
                    break;
                case "Bérgyilkos":
                    dex+=2;
                    chr+=1;
                    lck+=1;
                    break;
            }

            if (chosen == "Férfi") {
                hp+=10;
                str+=2;
                chr+=2;
            } else {
                mp+=10;
                dex+=2;
                lck+=1;
            }

            hpPoints = "10";
            mpPoints = "5";
            dexPoints = "1";
            strPoints = "1";
            lckPoints = "1";
            chrPoints = "1";
            ageNum = "0";

            hpPoints = Integer.toString(hp);
            mpPoints = Integer.toString(mp);
            dexPoints = Integer.toString(dex);
            strPoints = Integer.toString(str);
            lckPoints = Integer.toString(lck);
            chrPoints = Integer.toString(chr);
            ageNum = Integer.toString(agenum);

            Intent intent = new Intent(this, generatedActivity.class);
            intent.putExtra(hpPoint, hpPoints);
            intent.putExtra(mpPoint, mpPoints);
            intent.putExtra(dexPoint, dexPoints);
            intent.putExtra(strPoint, strPoints);
            intent.putExtra(lckPoint, lckPoints);
            intent.putExtra(chrPoint, chrPoints);
            intent.putExtra(charAge, ageNum);
            intent.putExtra(charRace, race);
            intent.putExtra(charClass, Class);
            intent.putExtra(charGender, chosen);
            finish();
            this.startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "Nem adtál meg érvényes életkort!",
                    Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.generator);

    }

    public void mainMenu(View view) {
        finish();
    }

}
