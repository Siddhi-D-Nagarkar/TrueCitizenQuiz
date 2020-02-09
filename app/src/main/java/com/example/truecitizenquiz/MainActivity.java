package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button truebutton;
    private Button falsebutton;
    private TextView questiontext;
    private Question []questionBank=new Question[]{
            new Question(R.string.one,true),
            new Question(R.string.two,true),
            new Question(R.string.three,false),
            new Question(R.string.four,false),
            new Question(R.string.five,false),
    };
    private ImageButton nextbut;
    private int currentQuestionNo=0;
    private boolean correctanswer;
    private ImageButton prevbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prevbut=findViewById(R.id.previous_button);
        truebutton=findViewById(R.id.TrueButton);
        falsebutton=findViewById(R.id.FalseButton);
        questiontext=findViewById(R.id.my_Text_View);
        nextbut=findViewById(R.id.next_button);
        truebutton.setOnClickListener(this);
        falsebutton.setOnClickListener(this);
        nextbut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.FalseButton:// Toast.makeText(getApplicationContext(),"")
                correctanswer=questionBank[currentQuestionNo].isAnswerTrue();
                if(correctanswer==false)
                    Toast.makeText(MainActivity.this,"YOu Are Right",Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this,"YOu Are Wrong",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.TrueButton:
                correctanswer=questionBank[currentQuestionNo].isAnswerTrue();
                if(correctanswer==true)
                    Toast.makeText(MainActivity.this,"YOu Are Right",Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this,"YOu Are Wrong",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.next_button:
                if(currentQuestionNo==4)
                    currentQuestionNo=0;
                else {
                    currentQuestionNo++;
                }
                questiontext.setText(questionBank[currentQuestionNo].getAnswerResId());


        }

    }
}
