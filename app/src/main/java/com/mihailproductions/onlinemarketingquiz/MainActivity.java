package com.mihailproductions.onlinemarketingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mAnswer1ET;
    private CheckBox mAnswer2CB1;
    private CheckBox mAnswer2CB2;
    private CheckBox mAnswer2CB3;
    private CheckBox mAnswer2CB4;
    private RadioGroup mAnswer3RG;
    private RadioGroup mAnswer4RG;
    private EditText mAnswer5ET;
    private int score;
    private final int TOTAL = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAnswer1ET = (EditText) findViewById(R.id.a1);
        mAnswer2CB1 = (CheckBox) findViewById(R.id.cb1);
        mAnswer2CB2 = (CheckBox) findViewById(R.id.cb2);
        mAnswer2CB3 = (CheckBox) findViewById(R.id.cb3);
        mAnswer2CB4 = (CheckBox) findViewById(R.id.cb4);
        mAnswer3RG = (RadioGroup) findViewById(R.id.a3);
        mAnswer4RG = (RadioGroup) findViewById(R.id.a4);
        mAnswer5ET = (EditText) findViewById(R.id.a5);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                if (mAnswer1ET.getText().toString().toLowerCase().equals(getResources().getString(R.string.a1).toString().toLowerCase()))
                    score++;
                if (mAnswer2CB1.isChecked() && mAnswer2CB2.isChecked() && mAnswer2CB3.isChecked() && !mAnswer2CB4.isChecked())
                    score++;
                if (mAnswer3RG.indexOfChild(findViewById(mAnswer3RG.getCheckedRadioButtonId())) == 3)
                    score++;
                if (mAnswer4RG.indexOfChild(findViewById(mAnswer4RG.getCheckedRadioButtonId())) == 1)
                    score++;
                if (mAnswer5ET.getText().toString().toLowerCase().equals(getResources().getString(R.string.a5).toString().toLowerCase()))
                    score++;
                Toast.makeText(MainActivity.this, getResources().getString(R.string.finalScore) + (float)score / TOTAL * 100, Toast.LENGTH_SHORT).show();
            }
        });
    }
}