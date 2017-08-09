package com.example.aaron.androidthreads;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.content.ContentValues.TAG;


/**
 * Created by aaron on 8/8/17.
 */

public class TestAsyncTask extends AsyncTask<String, Integer, String> {
    TextView textView;

    public TestAsyncTask(TextView tv){
        this.textView = tv;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textView.setText("Progress = " + values[0]);
        Log.d(TAG, "onProgressUpdate: "+ Thread.currentThread());
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText("Finished = " + s);
        Log.d(TAG, "onPostExecute: "+ Thread.currentThread());
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: "+ strings[0] +Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                strings[0] = String.valueOf(i);
            } catch (Exception e) {
                e.printStackTrace();
            }

            publishProgress(i);
        }
        return strings[0];


    }
}
