package com.example.aaron.androidthreads;

import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by aaron on 8/8/17.
 */

public class TestThread extends Thread {

    android.os.Handler handler = new android.os.Handler(Looper.getMainLooper());

    TextView tvTesting;
    public TestThread(TextView view){
        this.tvTesting = view;
    }







    @Override
    public void run(){
        super.run();

            for(int i = 0 ; i < 10 ; i++) {
                final int j = i;
                try {
                    Thread.sleep(1000);
                    System.out.println(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                final String data = "This is Thread Class";
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvTesting.setText(String.valueOf(j));
                    }

                });
                EventBus.getDefault().post(new MessageEvent(String.valueOf(i)));
            }

    }
}
