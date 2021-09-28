package com.sharathbn2001gmail.toss;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;//this is for selecting head or tail randomly

import static com.sharathbn2001gmail.toss.R.drawable.ic_baseline_refresh_24;

//Mainactivity class starts here
public class MainActivity extends AppCompatActivity {
    //declaration of Imageview
    ImageView coin_image, refresh;

    //declaration of Button
    Button ahead_button, atail_button, bhead_button, btail_button;

    //declaration of Textview
    TextView resultA, resultB, imagecenter_toss;

    //declaration of color for buttons
    int color, initial_color, red, green;

    //declaration of button status or image status
    //which is used for checking whether button or image are click once or not
    boolean ahead, atail, bhead, btail, isselect, istossed;

    //constructor, which is used to initialise the variable
    public MainActivity() {
        green = 0xFF00FF00;// color values initialisation
        red = 0xFFFF0000;
        color = 0xFFFF960A;
        initial_color = 0xFFFFBB33;

        //this is used to crack, whether user has selected the choice or not.this cracks button are presses once only.
        isselect = false;

        //this is used check whether user tossed or not. By this we can toss once.
        istossed = false;

        //this is the choice of user
        ahead = false;//this is true when A player choice head
        atail = false;//this is true when A player choice tail
        bhead = false;//this is true when B player choice head
        btail = false;//this is true when B player choice tail
    }

    //when once coin is tossed ,this user-defined reset method is used to reset all the parameter to initial state
    @SuppressLint("SetTextI18n")
    void reset() {
        imagecenter_toss.setText("TOSS");
        resultA.setText("");
        resultB.setText("");
        isselect = false;
        istossed = false;
        ahead = false;
        atail = false;
        bhead = false;
        btail = false;
    }

    //this user-defined method is used to set the button color
    protected void setButtonColors() {
        //choice head by A or tail by B are the same
        if (ahead) //if (btail) both is same
        {
            //this color is set when A choice head or B choice tail
            ahead_button.setBackgroundColor(color);
            btail_button.setBackgroundColor(color);
            bhead_button.setBackgroundColor(initial_color);
            atail_button.setBackgroundColor(initial_color);
        }
        //choice tail by A or head by B are the same
        else if (bhead)//if (atail) both is same
        {
            //this color is set when A choice tail or B choice head
            bhead_button.setBackgroundColor(color);
            atail_button.setBackgroundColor(color);
            ahead_button.setBackgroundColor(initial_color);
            btail_button.setBackgroundColor(initial_color);
        } else {
            //initialisation of color to initial state
            ahead_button.setBackgroundColor(initial_color);
            btail_button.setBackgroundColor(initial_color);
            bhead_button.setBackgroundColor(initial_color);
            atail_button.setBackgroundColor(initial_color);
        }
    }


    //this is build-in oncreate method
    //when this activity start, all the set of code in oncreate method is executed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//set the layout build-in


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
        refresh = findViewById(R.id.reset);

        //whenever coin image is clicked this, build-in method execute
        //inside we write code after clicking if
        coin_image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!istossed && isselect) {
                    imagecenter_toss.setText("");
                    coin_image.animate().setDuration(4500);
                    coin_image.animate().rotationXBy(14040f);
                    istossed = true;
                    coin_image.animate().withEndAction(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {
                            Random random = new Random();
                            boolean ishead = random.nextBoolean();
                            if (ishead) {
                                imagecenter_toss.setText("HEAD");
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
                                imagecenter_toss.setText("TAIL");
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
                            refresh.setImageDrawable(getResources().getDrawable(ic_baseline_refresh_24));
                        }
                    });

                } else if (!isselect) {
                    Toast.makeText(getApplicationContext(), "select the your choice", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //whenever refresh image is clicked, this build-in method execute
        //inside we write code after clicking if
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                setButtonColors();
                refresh.setImageDrawable(null);
            }
        });

        //whenever button is clicked, this build-in method execute
        //inside we write code after clicking if
        ahead_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isselect) {
                    ahead = true;
                    atail = false;
                    bhead = false;
                    btail = true;
                    isselect = true;
                    setButtonColors();
                    Toast.makeText(getApplicationContext(), "Toss the coin", Toast.LENGTH_SHORT).show();
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
                    setButtonColors();
                    Toast.makeText(getApplicationContext(), "Toss the coin", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getApplicationContext(), "Toss the coin", Toast.LENGTH_SHORT).show();;
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
                    Toast.makeText(getApplicationContext(), "Toss the coin", Toast.LENGTH_SHORT).show();
                    setButtonColors();
                }
            }
        });

    }
}





