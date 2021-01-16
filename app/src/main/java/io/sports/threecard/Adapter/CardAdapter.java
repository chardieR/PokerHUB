package io.sports.threecard.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.sports.threecard.Cardranking;
import io.sports.threecard.Model.CardRankModel;
import io.sports.threecard.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<CardRankModel> data;
    Context context;
    TextView bTitle;
    TextView bDesc;
    ImageView bImg;
    
    public CardAdapter(Context context, List<CardRankModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.rankinglist, parent, false);
        CardAdapter.ViewHolder viewHolder = new CardAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CardAdapter.ViewHolder holder, final int position) {
        holder.gname.setText(data.get(position).getName());
        holder.gdesc.setText(data.get(position).getDescription());
        holder.imahe.setImageResource((data.get(position).getImage()));

            final Dialog myDialog;
            myDialog = new Dialog (context);
            myDialog.setContentView(R.layout.rankinglistview);
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            bTitle = myDialog.findViewById(R.id.ctitle);
            bImg = myDialog.findViewById(R.id.cimg);
            bDesc = myDialog.findViewById(R.id.cdesc);

                for (int i = 0; i<data.size(); i++){
                    if (holder.gname.getText()==data.get(position).getName()); {
                        bTitle.setText(data.get(position).getName());
                        bImg.setImageResource(data.get(position).getImage());
                        bDesc.setText(data.get(position).getDescription());

                    }
                }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    myDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView gname;
        public TextView gdesc;
       public ImageView imahe;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imahe = itemView.findViewById(R.id.bimg);
            gname = itemView.findViewById(R.id.btitle);
            gdesc = itemView.findViewById(R.id.bdesc);
        }
    }
}

