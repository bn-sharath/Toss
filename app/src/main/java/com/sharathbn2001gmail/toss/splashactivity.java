package com.sharathbn2001gmail.toss;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        /* this function or method is used for hiding the  */
        Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent goto_home = new Intent(splashactivity.this, MainActivity.class);
                        startActivity(goto_home);
                        finish();
                    }
                }, 2500);

    }
}
//        Thread thread = new Thread() {
//
//        public void run(){
//            try
//
//            {
//                Thread.sleep(10000);
//            } catch(
//                    InterruptedException e)
//
//            {
//                e.printStackTrace();
//            }
//            finally
//
//            {
//                Intent goto_home = new Intent(splashactivity.this, MainActivity.class);
//                startActivity(goto_home);
//            }
//
//        }
//
//
//        }; thread.start();
//    }


