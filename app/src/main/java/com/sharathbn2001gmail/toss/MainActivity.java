package com.sharathbn2001gmail.toss;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView coin_image;
    Button ahead_button, atail_button, bhead_button, btail_button;
    TextView resultA, resultB, imagecenter_toss;

    int color, initial_color, red, green;
    boolean ahead, atail, bhead, btail, isselect, istossed;

    public MainActivity() {
        green = 0xFF00FF00;
        red = 0xFFFF0000;
        color = 0xFFFB8C00;
        initial_color = 0xFFFFBB33;
        isselect = false;
        istossed = false;
        ahead = false;
        atail = false;
        bhead = false;
        btail = false;
    }
    //variables for initialing the head and tail


    protected void setButtonColors() {

        if (ahead) {
            ahead_button.setBackgroundColor(color);
            btail_button.setBackgroundColor(color);
            bhead_button.setBackgroundColor(initial_color);
            atail_button.setBackgroundColor(initial_color);
        } else if (bhead) {
            bhead_button.setBackgroundColor(color);
            atail_button.setBackgroundColor(color);
            ahead_button.setBackgroundColor(initial_color);
            btail_button.setBackgroundColor(initial_color);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //textview.... initialising textview object to corresponding variable
        imagecenter_toss = findViewById(R.id.tossing);
        resultB = findViewById(R.id.result_b);
        resultA = findViewById(R.id.result_a);

        //textview.... initializing button object to corresponding variable
        ahead_button = findViewById(R.id.ahead);
        atail_button = findViewById(R.id.atail);
        bhead_button = findViewById(R.id.bhead);
        btail_button = findViewById(R.id.btail);

        //textview.... initializing imageview object to corresponding variable
        coin_image = findViewById(R.id.coin);

        coin_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!istossed && isselect) {
                    imagecenter_toss.setText("");
                    coin_image.animate().setDuration(5000);
                    coin_image.animate().rotationXBy(14400f);
                    istossed = true;
                    coin_image.animate().withEndAction(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {
                            Random random = new Random();
                            boolean ishead = random.nextBoolean();
                            if (ishead) {
                                imagecenter_toss.setText("head");
                                if (ahead) {
                                    resultA.setText("PLAYER 'A' WON");
                                    resultB.setText("PLAYER 'B' LOSE");
                                    resultB.setTextColor(red);
                                    resultA.setTextColor(green);
                                    ahead_button.setBackgroundColor(green);
                                    btail_button.setBackgroundColor(red);
                                } else if (bhead) {
                                    resultB.setText("PLAYER 'B' WON");
                                    resultA.setText("PLAYER 'A' LOSE");
                                    resultA.setTextColor(red);
                                    resultB.setTextColor(green);
                                    bhead_button.setBackgroundColor(green);
                                    atail_button.setBackgroundColor(red);

                                }
                            } else {
                                imagecenter_toss.setText("tail");
                                if (atail) {
                                    resultA.setText("PLAYER 'A' WON");
                                    resultB.setText("PLAYER 'B' LOSE");
                                    resultB.setTextColor(red);
                                    resultA.setTextColor(green);
                                    atail_button.setBackgroundColor(green);
                                    bhead_button.setBackgroundColor(red);
                                } else if (btail) {
                                    resultB.setText("PLAYER 'B' WON");
                                    resultA.setText("PLAYER 'A' LOSE");
                                    resultB.setTextColor(green);
                                    resultA.setTextColor(red);
                                    btail_button.setBackgroundColor(green);
                                    ahead_button.setBackgroundColor(red);
                                }
                            }

                        }
                    });
                }
            }
        });


        // when button is clicked ,methods for what to do
        ahead_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isselect) {
                    ahead = true;
                    atail = false;
                    bhead = false;
                    btail = true;
                    isselect = true;
//                color= 0xFFFB8C00;
                    setButtonColors();
                }
            }
        });

        bhead_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isselect) {
                    bhead = true;
                    btail = false;
                    atail = true;
                    ahead = false;
                    isselect = true;
//                color= 0xFFFB8C00;
                    setButtonColors();
                }
            }
        });

        atail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isselect) {
                    atail = true;
                    ahead = false;
                    btail = false;
                    bhead = true;
                    isselect = true;
//                color= 0xFFFB8C00;
                    setButtonColors();
                }
            }
        });

        btail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isselect) {
                    btail = true;
                    bhead = false;
                    ahead = true;
                    atail = false;
                    isselect = true;
//                color= 0xFFFB8C00;
                    setButtonColors();
                }
            }
        });

    }
}

//        imagecenter_toss.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(View v) {
//                if (!istossed && isselect) {
//                    imagecenter_toss.setText("");
//                    coin_image.animate().setDuration(2000);
//                    coin_image.animate().rotationXBy(360f);
//                    imagecenter_toss.setText("Head");
//                    istossed = true;
//                }
//            }
//
//        });





