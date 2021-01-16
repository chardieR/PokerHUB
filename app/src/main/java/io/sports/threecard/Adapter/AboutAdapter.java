package io.sports.threecard.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.sports.threecard.Model.AboutCardModel;
import io.sports.threecard.R;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder> {
        List<AboutCardModel> data;
        Context context;
    TextView aTitle,aDescription;

        public AboutAdapter (Context context, List<AboutCardModel>data){
            this.context = context;
            this.data = data;
        }
    @NonNull
    @Override
    public AboutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.aboutlist, parent, false);
        AboutAdapter.ViewHolder viewHolder= new AboutAdapter.ViewHolder(listItem);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull final AboutAdapter.ViewHolder holder,final int position) {
        holder.atitle.setText(data.get(position).getTitle());
        holder.adesc.setText(data.get(position).getDescription());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.aboutdesc);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        aTitle = myDialog.findViewById(R.id.atitle);
        aDescription = myDialog.findViewById(R.id.adesc);

        //
        for (int i = 0; i<data.size(); i++) {
            if(holder.atitle.getText() == data.get(position).getTitle()){
                aTitle.setText(data.get(position).getTitle());
                aDescription.setText(data.get(position).getDescription());

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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView atitle;
        public TextView adesc;

        public ViewHolder (@NonNull View itemView){
            super (itemView);

            atitle = itemView.findViewById(R.id.atitle);
            adesc = itemView.findViewById(R.id.adesc);
        }
    }
}
