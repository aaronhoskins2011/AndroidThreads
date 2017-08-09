package com.example.aaron.androidthreads;

/**
 * Created by aaron on 8/8/17.
 */

public class MessageEvent {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageEvent(String message) {

        this.message = message;
    }
}
