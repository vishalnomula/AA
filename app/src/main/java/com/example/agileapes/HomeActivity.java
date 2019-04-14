package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

TextView tvHomeBananaNumber;

//Random change




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    @Override
    public void onResume(){
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Integer bananas = bundle.getInt("bananas");
            String bananastext = bananas.toString();

            TextView txtView = (TextView) findViewById(R.id.tvHomeBananaNumber);
            txtView.setText(bananastext);

        }

    }


    public void launchSettingsScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), SettingsActivity.class);
        startActivity(myIntent);
    }

    public void launchQuizScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
//        tvHomeBananaNumber = findViewById(R.id.tvHomeBananaNumber);
//        Intent intent = new Intent(HomeActivity.this, QuizActivity.class);
//        intent.putExtra("Score", currentPosition);
        startActivity(myIntent);
    }



}
