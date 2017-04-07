package com.example.rajesh.mathquiz;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class CentralActivity extends AppCompatActivity {


    MyCountDownTimer myCountDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    private class MyCountDownTimer extends CountDownTimer {

        private MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            finish_test();
        }
    }


    @Override
    public void onStart(){
        super.onStart();
        Gen_Num();

        myCountDownTimer = new MyCountDownTimer(30000, 1000);
        myCountDownTimer.start();
    }

    public void finish_test(){
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
    }




    public void Gen_Ques(View view){
        Gen_Num();
    }


    public void Gen_Num(){


        Random r = new Random();

        int i1 = r.nextInt(1000 - 100) + 100;
        int i2 = r.nextInt(1000 - 100) + 100;
        int i3 = i1 + i2;

        int N1 = r.nextInt(2000-200) + 200;
        int N2 = r.nextInt(2000-200) + 200;
        int N3 = r.nextInt(2000-200) + 200;

        String str1 = String.valueOf(i1);
        String str2 = String.valueOf(i2);
        String str3 = str1.concat("+").concat(str2);
        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(str3);


        Button ButtonA = (Button)findViewById(R.id.optionA);
        Button ButtonB = (Button)findViewById(R.id.optionB);
        Button ButtonC = (Button)findViewById(R.id.optionC);
        Button ButtonD = (Button)findViewById(R.id.optionD);




        int r1=r.nextInt(5 - 1) + 1;

        switch (r1){

            case 1:
                ButtonA.setText(String.valueOf(i3));
                ButtonB.setText(String.valueOf(N1));
                ButtonC.setText(String.valueOf(N2));
                ButtonD.setText(String.valueOf(N3));
                break;


            case 2:
                ButtonA.setText(String.valueOf(N1));
                ButtonB.setText(String.valueOf(i3));
                ButtonC.setText(String.valueOf(N2));
                ButtonD.setText(String.valueOf(N3));
                break;


            case 3:
                ButtonA.setText(String.valueOf(N2));
                ButtonB.setText(String.valueOf(N1));
                ButtonC.setText(String.valueOf(i3));
                ButtonD.setText(String.valueOf(N3));
                break;


            case 4:
                ButtonA.setText(String.valueOf(N3));
                ButtonB.setText(String.valueOf(N1));
                ButtonC.setText(String.valueOf(N2));
                ButtonD.setText(String.valueOf(i3));
                break;

        }

    }

}
