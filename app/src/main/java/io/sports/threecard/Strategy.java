package io.sports.threecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.sports.threecard.Adapter.AboutAdapter;
import io.sports.threecard.Adapter.CardAdapter;
import io.sports.threecard.Adapter.StratAdapter;
import io.sports.threecard.Model.CardRankModel;
import io.sports.threecard.Model.StratModel;

public class Strategy extends AppCompatActivity {

    ProgressDialog rLoading;
    Context context;
    private StratModel cardRanking;
    private StratAdapter stratAdapter;
    public static RecyclerView recyclerView;
    //int counter;

    String[] name = {"Rule #1", "Rule #2", "Rule #3", "Rule #4", "Rule #5", "Rule #6", "Rule #7", "Rule #8", "Rule #9", "Rule #10", "Rule #11", "Rule #12", "Rule #13"};

    String[] description = {"At the beginning of each round, each player should be asked to placed a forehead bet." +
            "Every player can choose to place a bet after checking their hand. must be equal to previous bet",

            "All bets in Three Card Poker shall be made by placing the chips on the applicable betting areas" +
                    "of the table layout. keep that in mind that the table has minimum and maximum wager limits",

            "Betting without the knowledge of the dealer in any wager is not allowed",

            "The house agent shall wait for each of the player to place their Ante wagers as well as any kind of wager." +
                    "After the player placed their wagers. The house agent will declared that \"no more bets\"",

            "Prior to the initiation of play, the house dealer will determine where will the action start on the table",

            "After all wager have been placed, the house dealer will shuffle the cards by use of a shuffle machine so that cards will be randomized" +
                    "Upon the completion of the shuffle. The machine shall dispense cards in stacks of three",

            "After the stacks delivered to each players, the player need to flip the card and the house dealer shall unload the" +
                    "remaining cards in the machine and placed it into the discard rack without showing the card",

            "After the dealing protocol have been completed, each player need to examine his/her cards",

            "Each player who bet in Three Card Poker will be responsible for his/her own hand and no person other than the" +
                    "player or the hosue agent may touch the cards of that player. Each player is required to keep his/her three cards" +
                    "in showed the eyes of the house dealer at all times",

            "After examination of the cards, each player who has placed an Ante wager will have the option to either continue or to make " +
                    "a Play wager in same amount equal to the player's Ante wager or cancelled the Ante wager and finish his/her participation" +
                    "in the round of play. The house dealer will offer this option to each of the player, starting with the player to the left of the player-dealer",

            "If the player placed a Pair Plus bet, but did not make a Play wager, The player needs to forfeit the wager, as well as, the Ante wager",

            "After each player either placed a bet on the table in the Play wager area or withdraw his/her wager and hand, the house dealer will collect all" +
                    "forfeited bet and associated cards, placing them in the discard rack",

            "The house dealer will reveal the remaining player-dealers card and then place the cards to form the best possible ranking hand." +
                    "The player- dealer must qualify to play with a merest of queen-high"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stratlist);

        load();
        initialize();


        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                rLoading.dismiss();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 2000);
    }

    private void initialize() {
        List<StratModel> stratAdapters = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            stratAdapters.add(new StratModel(name[i], description[i]));
        }

        recyclerView = findViewById(R.id.stratView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        stratAdapter = new StratAdapter(Strategy.this, stratAdapters);

        recyclerView.setAdapter(stratAdapter);

    }

    private void load() {
        rLoading = new ProgressDialog(this);
        rLoading.setMessage("\tPlease Wait...");
        rLoading.setCancelable(false);
        rLoading.show();
    }

    public void backClick(View view) {
        onBackPressed();
    }
}