package com.sharathbn2001gmail.toss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView coin_image;
    Button ahead_button,atail_button,bhead_button,btail_button;
    TextView resultA,resultB,imagecenter_toss;

    //variables for initialing the head and tail
    public boolean ahead ,atail,bhead,btail;

    int color;
    protected void setButtonColors(int i_color){
        if(ahead)
        {
            ahead_button.setBackgroundColor(i_color);
            btail_button.setBackgroundColor(i_color);
        }
        else {
            bhead_button.setBackgroundColor(i_color);
            atail_button.setBackgroundColor(i_color);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textview.... initialising textview object to corresponding variable
            imagecenter_toss=(TextView)findViewById(R.id.tossing);
            resultB=(TextView)findViewById(R.id.result_b);
            resultA=(TextView)findViewById(R.id.result_a);

        //textview.... initializing button object to corresponding variable
            ahead_button=(Button)findViewById(R.id.ahead);
            atail_button=(Button)findViewById(R.id.atail);
            bhead_button=(Button)findViewById(R.id.bhead);
            btail_button=(Button)findViewById(R.id.btail);

        //textview.... initializing imageview object to corresponding variable
            coin_image=(ImageView)findViewById(R.id.coin);

            // when button is clicked ,methods for what to do
        ahead_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ahead=true;
                atail=false;
                bhead=false;
                btail=true;
                color= 0xFFFB8C00;
               setButtonColors(color);
            }
        });

        bhead_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bhead=true;
                btail=false;
                atail=true;
                ahead=false;
                color= 0xFFFB8C00;
                setButtonColors(color);
            }
        });

        atail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atail=true;
                ahead=false;
                btail=false;
                bhead=true;
                color= 0xFFFB8C00;
                setButtonColors(color);

            }
        });

        btail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btail=true;
                bhead=false;
                ahead=true;
                atail=false;
                color= 0xFFFB8C00;
                setButtonColors(color);

            }
        });





    }


}