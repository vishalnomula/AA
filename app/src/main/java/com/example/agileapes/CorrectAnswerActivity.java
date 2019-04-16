package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CorrectAnswerActivity extends AppCompatActivity {

    TextView tvCorrectAnswerUserAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);

//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            String userInput = bundle.getString("userInput");
//
//            Toast.makeText(getApplicationContext(), "onCreate" + userInput, Toast.LENGTH_SHORT).show();
//
//            tvCorrectAnswerUserAnswer = (TextView) findViewById(R.id.tvCorrectAnswerUserAnswer);
//            tvCorrectAnswerUserAnswer.setText(userInput);
//
//        }

//        tvCorrectAnswerUserAnswer = findViewById(R.id.tvCorrectAnswerUserAnswer);
//        tvCorrectAnswerUserAnswer.setText(Global.userQuizAnswer);
//
//                Toast.makeText(getApplicationContext(), "onCreate" + Global.userQuizAnswer, Toast.LENGTH_SHORT).show();

//
//        Intent intent = getIntent();
//        String str = intent.getStringExtra("message");
//
//        Toast.makeText(getApplicationContext(), "onCreate" + str, Toast.LENGTH_SHORT).show();

//        tvCorrectAnswerUserAnswer.setText(str);

    }

    public void goToQuiz(View v) {
        Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
        startActivity(myIntent);
    }
}
