package io.sports.threecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.sports.threecard.Adapter.AboutAdapter;
import io.sports.threecard.Model.AboutCardModel;

public class Aboutcardpoker extends AppCompatActivity {


    ProgressDialog rloading;
    TextView textView;

    private AboutCardModel aboutCard;
    private  AboutAdapter aboutAdapter;
    public static RecyclerView recyclerView ;

    String[] title = {"Ante Bet", "Play Bet", "PairPlus", "Both Ante and Pair Plus"};
    String[] description = {"To play an \"Ante Bet\" you simply put a chip on the betting icon mark in front of the table", "To play \"Play Bet\" is the just the same with Ante bet" +
            "but you only place a bet if you like the card in your hand", "The \"PairPlus\" bet can be made" +
            " with or without the Ante/Play bet. to bet on Pair Plus" +
            "you just need to place a chip on the Pair Plus betting icon mark in the front of the table", "To play Both Ante and Pair Plus you have to bet on \"Six Card Bonus\" to play facing" +
            "a separate posted payout table. Both the Ante and Pair plus bet are required."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutcardpoker);


        load();
        initialize();
        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                rloading.dismiss();
            }
        };

        // delay of progress bar
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 2000);



    }

    private void initialize() {
        List<AboutCardModel> aboutCard = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            aboutCard.add(new AboutCardModel(title[i],description[i]));
        }

        recyclerView = findViewById(R.id.makeBet);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        aboutAdapter = new AboutAdapter(Aboutcardpoker.this, aboutCard);
        recyclerView.setAdapter(aboutAdapter);

        textView =  findViewById(R.id.about2);
        textView.setText("This game was invented by Derek Webb of the United Kingdom in 1994, Three Card Poker is an newbie friendly card game" +
                "dealt from a single deck. Ranking of hands is distinct than in five-card poker games because the odds are different when" +
                "hands consist of three cards. Standard tables also have two choice of how to play: Pair Plus and Ante-Play." +
                "In this phase, you'll find the ranking of hands, methods for betting and how to play at both the Pair Plus and Ante-play options ");


    }


    //progress bar
    private void load(){
        rloading = new ProgressDialog(this);
        rloading.setMessage("\tPlease Wait...");
        rloading.setCancelable(false);
        rloading.show();
    }
    public void backClick(View view) {
        onBackPressed();
    }
}