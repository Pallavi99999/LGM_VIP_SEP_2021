package com.example.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Model> mData;

    public MyAdapter(Context mContext, List<Model> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.covid_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.district.setText(mData.get(position).getDistrict());
        holder.active.setText(mData.get(position).getActive());
        holder.recovered.setText(mData.get(position).getRecovered());
        holder.deceased.setText(mData.get(position).getDeceased());
        holder.deltaactive.setText(mData.get(position).getDeltaactive());
        holder.deltadeceased.setText(mData.get(position).getDeltadeceased());
        holder.deltarecovered.setText(mData.get(position).getDeltarecovered());

        String act = holder.active.getText().toString();
        String rec = holder.recovered.getText().toString();
        String dec =  holder.deceased.getText().toString();

        Integer tot = Integer.parseInt(act) + Integer.parseInt(rec) + Integer.parseInt(dec);
        holder.total.setText(String.valueOf(tot));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView district,active,recovered,deceased,total,deltaactive,deltarecovered,deltadeceased;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            district = itemView.findViewById(R.id.district);
            active = itemView.findViewById(R.id.active);
            recovered = itemView.findViewById(R.id.cured);
            deceased = itemView.findViewById(R.id.death);
            total = itemView.findViewById(R.id.total);
            deltaactive = itemView.findViewById(R.id.delta_active);
            deltarecovered = itemView.findViewById(R.id.delta_cured);
            deltadeceased = itemView.findViewById(R.id.delta_death);

        }
    }

}
