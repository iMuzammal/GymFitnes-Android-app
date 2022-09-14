package com.example.fitnessapp.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.fitnessapp.R;

public class MainActivity extends AppCompatActivity {
    ImageView logo;

  //  LottieAnimationView lottieAnimationView;
    private final int SPLASH_DISPLAY_LENGTH = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //lottieAnimationView = (LottieAnimationView) findViewById( R.id.lottie );

     //   startCheckAnimation();

        new Handler().postDelayed( new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(mainIntent);

            }
        }, SPLASH_DISPLAY_LENGTH);


        logo=(ImageView)findViewById( R.id.logo );
        logo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(mainIntent);
            }
        } );

        logo.setImageResource(R.drawable.bglogo);

        boolean up = true;

        if (!up) {
            up = true;
            logo.startAnimation(animate(up));
        } else {
            up = false;
            logo.startAnimation(animate(up));
        }

    }

    private Animation animate(boolean up) {
        Animation anim = AnimationUtils.loadAnimation(this, up ? R.anim.rotate_up : R.anim.rotate_down);
        anim.setInterpolator(new LinearInterpolator()); // for smooth animation
        return anim;
    }

//    private void startCheckAnimation() {
//
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat( 0f, 1f ).setDuration( 3000 );
//        valueAnimator.addUpdateListener( new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                lottieAnimationView.setProgress( (Float) animation.getAnimatedValue() );
//            }
//        } );
//        if (lottieAnimationView.getProgress() == 0f) {
//
//            valueAnimator.start();
//
//        } else {
//            lottieAnimationView.setProgress( 0f );
//        }
//    }



}


