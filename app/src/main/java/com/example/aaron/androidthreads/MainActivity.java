package com.example.aaron.androidthreads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    Button btnThread;
    Button btnRunnable;
    Button btnAsync;
    TextView tvTesting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThread = (Button)findViewById(R.id.btnThread);
        btnRunnable = (Button)findViewById(R.id.btnRunnable);
        btnAsync = (Button)findViewById(R.id.btnAsync);
        tvTesting = (TextView)findViewById((R.id.tvTesting));
    }

    public void executeThreads(View view){
        switch(view.getId()){
            case R.id.btnThread:
                TestThread testThread = new TestThread(tvTesting);
                testThread.start();
                break;
            case R.id.btnRunnable:
                TestRunnable testRunnable = new TestRunnable(tvTesting);
                Thread thread = new Thread(testRunnable);
                thread.start();
                break;
            case R.id.btnAsync:
                TestAsyncTask testAsyncTask = new TestAsyncTask(tvTesting);
                testAsyncTask.execute("Starting");
                break;
            default:

                break;
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    void onMessegeEvent(MessageEvent messegeEvent){
        Toast.makeText(this, messegeEvent.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
