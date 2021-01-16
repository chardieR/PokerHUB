package io.sports.threecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

import io.sports.threecard.Model.AboutCardModel;

public class MainActivity extends AppCompatActivity {

    private Object View;
    Context context;
    LinearLayout mainlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declares();
        clicks(mainlayout);

    }

        // Calling other activity
    public void clicks(LinearLayout mainlayout)
    {
        for(int i = 0; i<mainlayout.getChildCount(); i++){
            CardView cardView = (CardView) mainlayout.getChildAt(i);
            final int clicked = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clicked ==0){
                        Intent aw = new Intent(MainActivity.this, Aboutcardpoker.class);
                        startActivity(aw);

                    } if(clicked ==1){
                        Intent aw = new Intent(MainActivity.this, Cardranking.class);
                        startActivity(aw);
                    }if(clicked ==2){
                        Intent aw = new Intent(MainActivity.this, Strategy.class);
                        startActivity(aw);
                    }

                }




        });
        }
    }
        //declare clicks
    public void declares() {

        Dialog myDialog = new Dialog(MainActivity.this);
        myDialog.setContentView(R.layout.activity_main);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mainlayout = findViewById(R.id.mainlayout12);
    }
}