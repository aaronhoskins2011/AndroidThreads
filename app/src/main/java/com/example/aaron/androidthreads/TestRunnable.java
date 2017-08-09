package com.example.aaron.androidthreads;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Created by aaron on 8/8/17.
 */

public class TestRunnable implements Runnable {
    Handler handler = new Handler(Looper.getMainLooper());
    TextView tvTesting;
    public TestRunnable(TextView view){
        this.tvTesting = view;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            final int j = i;
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            final String data = "This is Thread Class";
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tvTesting.setText(String.valueOf(j));
                }

            }, 2000);

        }
    }
}
