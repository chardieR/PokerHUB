package io.sports.threecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.sports.threecard.Adapter.CardAdapter;
import io.sports.threecard.Model.CardRankModel;

public class Cardranking extends AppCompatActivity {

   ProgressDialog rLoading;

    Context context;
    private CardRankModel cardRanking;
    private CardAdapter cardAdapter;
    public static RecyclerView recyclerView ;
    //int counter;

    String[] name = {"Mini Royal Flush","Straight Flush", "Three of a kind", "Straight card","Flush", "One Pair", "High card"};
    String[] description = {"A hand composed of aces, king and queen of the same suit","A card composed of three cards of the same suit in a consecutive ranking. Ace, the king and queen are the highest\n" +
            "Ranked straight flushes, and 4, 3 and 2 are the lowest ranked straight flushes.","A hand composed of three cards of the same rank. The three aces are the top three in their class,\n" +
            "Three 2s are the lowest three in their class","A deck that has three cards that are in chronological ranking, but are not in the same suit.\n" +
            " Ace, king, and queen are the best rank straight and ace, 2 ,3 is the lowest ranked straight","A card composed of three cards of the same suit, but not ranked consecutively.\n" +
            "Aces, king and jack are the highest ranked flushes, while 5, 3 and 2 are the lowest ranked flushes.","A hand composed of two cards of the same rank.\n" +
            "Two A's are the highest-ranked pair, and two 2's are the lowest-ranked pair","a hand composed of three cards, without any of the hands listed above. Ace, ace and 9\n" +
            "Is the highest ranked high player and 5,3, and 2 is the lowest ranked high player"};
    Integer[] image = {R.drawable.miniroyalflush,R.drawable.straightflush,R.drawable.threeofakind,R.drawable.straight,R.drawable.flush,R.drawable.pair,R.drawable.highcard};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardranking);

        load();
        initialize();
        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                rLoading.dismiss();
            }
        };

        // delay of progress bar
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 2000);
        initialize();
    }

    private void initialize(){
        List<CardRankModel> cardRank = new ArrayList<>();
        for (int i = 0; i <name.length; i ++ ){
            cardRank.add (new CardRankModel(name[i],description[i],image[i]));
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        cardAdapter = new CardAdapter(Cardranking.this,cardRank);
        recyclerView.setAdapter(cardAdapter);


//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        cardAdapter = new CardAdapter(cardRank);
//        recyclerView.setAdapter(cardAdapter);

    }

    private void load(){
        rLoading = new ProgressDialog(this);
        rLoading.setMessage("\tPlease Wait...");
        rLoading.setCancelable(false);
        rLoading.show();
    }
    public void backClick(View view) {
        onBackPressed();
    }
}