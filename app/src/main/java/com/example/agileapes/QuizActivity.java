package com.example.agileapes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    //Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();

    TextView tvQuizQuestion;
    Button btQuizSubmit;
    EditText etQuizAnswer;
    TextView tvQuizScore;
    ArrayList<Qanda> qandaArrayList = new ArrayList<>();

    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuizQuestion = findViewById(R.id.tvQuizQuestion);
        btQuizSubmit = findViewById(R.id.btQuizSubmit);
        etQuizAnswer = findViewById(R.id.etQuizAnswer);
        tvQuizScore = findViewById(R.id.tvQuizScore);

        etQuizAnswer.requestFocus();

        getQanda();

        setTvQuizQuestion();

        btQuizSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String userInput = etQuizAnswer.getText().toString();

                //Toast.makeText(getApplicationContext(), "onClick" + userInput, Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(QuizActivity.this, CorrectAnswerActivity.class);
//                intent.putExtra("userInput", userInput);
//                startActivity(intent);

                checkAnswer();







//                Global.userQuizAnswer = etQuizAnswer.getText().toString();

//                String str = etQuizAnswer.getText().toString();
//                Intent intent = new Intent(getApplicationContext(), CorrectAnswerActivity.class);
//                intent.putExtra("message", str);
//                startActivity(intent);

            }
        });

        Log.d("onCreate", "onCreate");


    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//
//        tvQuizScore.setText(Global.bananas);
//
//        Log.d("onResume", "onResume");
//
//        Toast.makeText(getApplicationContext(), "onResume" + Global.bananas, Toast.LENGTH_SHORT).show();
//
//    }

    public void goBackToHomeScreen(View v) {

        Global.bananas = Integer.parseInt(tvQuizScore.getText().toString());

        Intent myIntent1 = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(myIntent1);

    }

    public void getQanda() {

        qandaArrayList.add(new Qanda("_______ are common solutions to common problems where the solution is ineffective and may result in undesired consequences.", "antipatterns"));
//        qandaArrayList.add(new Qanda("_______ involves team members with different perspectives (customer, development, testing) collaborating to write acceptance tests in advance of implementing the corresponding functionality.", "acceptance test driven development"));
//        qandaArrayList.add(new Qanda("_______ is a practice where members of the team discuss the expected behavior of a system in order to build a shared understanding of expected functionality.", "behavior driven development"));
        qandaArrayList.add(new Qanda("_______ and burnup charts track the amount of output (in terms of hours, story points, or backlog items) a team has completed across an iteration or a project.", "burndown charts"));
        qandaArrayList.add(new Qanda("_______ is the ability of an organization to sense changes internally or externally and respond accordingly in order to deliver value to its customers.", "business agility"));
//        qandaArrayList.add(new Qanda("_______ is the explicit convention that every team member can make changes to any code file as necessary: either to complete a development task, to repair a defect, or to improve the code's overall structure.", "collective code ownership"));

    }

    public void setTvQuizQuestion() {

        Random rand = new Random();
        int randomElement = rand.nextInt(qandaArrayList.size());
        currentPosition = randomElement;

        tvQuizQuestion.setText(qandaArrayList.get(currentPosition).getQuestion());


        tvQuizScore.setText("" + Global.bananas);
    }



    public void checkAnswer() {
        String answer = etQuizAnswer.getText().toString().trim().toLowerCase();

        if (answer.equals(qandaArrayList.get(currentPosition).getAnswer())) {
            Log.e("answer", "right");

            Global.bananas++;
            currentPosition++;
            setTvQuizQuestion();
            etQuizAnswer.setText("");


            startActivity(new Intent(getBaseContext(), CorrectAnswerActivity.class));


        } else {

            Log.e("answer", "wrong");

            currentPosition++;
            setTvQuizQuestion();
            etQuizAnswer.setText("");

            startActivity(new Intent(getBaseContext(), IncorrectAnswerActivity.class));


        }




    }

}