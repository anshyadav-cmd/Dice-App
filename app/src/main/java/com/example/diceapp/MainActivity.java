package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View Instances
        Button btnRoll = findViewById(R.id.btnRollTheDice);
        ImageView diceImage1 = findViewById(R.id.imgDice1);
        ImageView diceImage2 = findViewById(R.id.imgDice2);

        // Storing dice Images into an array
        int[] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4,
        R.drawable.dice5, R.drawable.dice6};
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);


        btnRoll.setOnClickListener(new View.OnClickListener() {
            final Random random = new Random();
            @Override
            public void onClick(View v) {
                int randomNumber = random.nextInt(6);
                Log.i("TAG", "The button is pressed");
                Log.i("RANDOM", randomNumber+"");
                //Animation
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(0)
                        .playOn(diceImage1);

                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(0)
                        .playOn(diceImage2);

                //Playing the Sound Effect
                mp.start();
                // changing Dice Images
                diceImage1.setImageResource(diceImages[randomNumber]);
                randomNumber = random.nextInt(6);
                diceImage2.setImageResource(diceImages[randomNumber]);
            }
        });
    }
}