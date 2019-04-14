package com.example.agileapes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    TextView tvQuizQuestion;
    ArrayList<Qanda> qandaArrayList;
    Button btQuizSubmit;
    EditText etQuizAnswer;
    TextView tvQuizScore;

    int currentPosition = 0;
    int bananas = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);




        tvQuizQuestion = findViewById(R.id.tvQuizQuestion);
        btQuizSubmit = findViewById(R.id.btQuizSubmit);
        etQuizAnswer = findViewById(R.id.etQuizAnswer);
        etQuizAnswer.requestFocus();
        tvQuizScore = findViewById(R.id.tvQuizScore);


//        tvQuizScore.setText(getIntent().getStringExtra("Score"));
        qandaArrayList = new ArrayList<>();

        getQanda();

        setTvQuizQuestion();

        btQuizSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    public void goBackToHomeScreen(View v) {

        Intent myIntent1 = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(myIntent1);
        Intent intent = new Intent(QuizActivity.this, HomeActivity.class);
        intent.putExtra("bananas", bananas);
        startActivity(intent);
    }

    public void getQanda() {

        qandaArrayList.add(new Qanda("_______ are common solutions to common problems where the solution is ineffective and may result in undesired consequences.", "Antipatterns"));
        qandaArrayList.add(new Qanda("_______ involves team members with different perspectives (customer, development, testing) collaborating to write acceptance tests in advance of implementing the corresponding functionality.", "Acceptance Test Driven Development"));
        qandaArrayList.add(new Qanda("_______ is a practice where members of the team discuss the expected behavior of a system in order to build a shared understanding of expected functionality.", "Behavior Driven Development"));
        qandaArrayList.add(new Qanda("_______ and burnup charts track the amount of output (in terms of hours, story points, or backlog items) a team has completed across an iteration or a project.", "Burndown Charts"));
        qandaArrayList.add(new Qanda("_______ is the ability of an organization to sense changes internally or externally and respond accordingly in order to deliver value to its customers.", "Business Agility"));
        qandaArrayList.add(new Qanda("_______ is the explicit convention that every team member can make changes to any code file as necessary: either to complete a development task, to repair a defect, or to improve the code's overall structure.", "Collective Code Ownership"));

    }

    public void setTvQuizQuestion() {
        tvQuizQuestion.setText(qandaArrayList.get(currentPosition).getQuestion());
        tvQuizScore.setText("" + bananas);
    }


    public void checkAnswer() {
        String answer = etQuizAnswer.getText().toString().trim();

        if (answer.equals(qandaArrayList.get(currentPosition).getAnswer())) {
            Log.e("answer", "right");

            bananas++;
            currentPosition++;
            setTvQuizQuestion();
            etQuizAnswer.setText("");


           // startActivity(new Intent(getBaseContext(), CorrectAnswerActivity.class));


        } else {

            Log.e("answer", "wrong");

            currentPosition++;
            setTvQuizQuestion();
            etQuizAnswer.setText("");

            startActivity(new Intent(getBaseContext(), IncorrectAnswerActivity.class));


        }




    }

}




