package com.dipakkr.github.miowkapp;

import android.content.Intent;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView  txtfamily,txtcolor,txtphrase,txtnumber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtfamily = (TextView)findViewById(R.id.family);
        txtcolor = (TextView)findViewById(R.id.colors);
        txtnumber = (TextView)findViewById(R.id.numbers);
        txtphrase = (TextView)findViewById(R.id.phrases);

        txtfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FamilyActivity.class));
            }
        });

        txtphrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PhrasesActivity.class));
            }
        });
        txtcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ColorsActivity.class));
            }
        });

        txtnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NumbersActivity.class));
            }
        });




    }


}
