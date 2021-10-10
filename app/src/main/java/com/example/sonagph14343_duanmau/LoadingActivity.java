package com.example.sonagph14343_duanmau;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {
    CountDownTimer countDownTimer = new CountDownTimer(3000, 100) {
        public void onTick(long l) {
        }

        public void onFinish() {
            LoadingActivity.this.startActivity(new Intent(LoadingActivity.this, MainActivity.class));
        }
    }.start();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_loading);
    }
}
