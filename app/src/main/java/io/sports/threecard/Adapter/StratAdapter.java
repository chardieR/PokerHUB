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
import io.sports.threecard.Model.StratModel;
import io.sports.threecard.R;

public class StratAdapter extends RecyclerView.Adapter<StratAdapter.ViewHolder> {

    List<StratModel> data;
    Context context;
    TextView drule, ddesc;

    public StratAdapter(Context context, List<StratModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public StratAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.ruleslist, parent, false);
        StratAdapter.ViewHolder viewHolder = new StratAdapter.ViewHolder(listItem);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull StratAdapter.ViewHolder holder, final int position) {
        holder.dstrat.setText(data.get(position).getName());
        holder.ddesc.setText(data.get(position).getDescription());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.ruleslistview);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        drule = myDialog.findViewById(R.id.dstrat);
        ddesc = myDialog.findViewById(R.id.ddesc);

        //
        for (int i = 0; i<data.size(); i++) {
            if(holder.dstrat.getText() == data.get(position).getName()){
                drule.setText(data.get(position).getName());
                ddesc.setText(data.get(position).getDescription());

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

        public TextView dstrat;
        public TextView ddesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dstrat = itemView.findViewById(R.id.dstrat);
            ddesc = itemView.findViewById(R.id.ddesc);
        }
    }
}



