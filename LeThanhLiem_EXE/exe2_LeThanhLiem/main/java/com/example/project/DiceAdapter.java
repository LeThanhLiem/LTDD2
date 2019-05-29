package com.example.project;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DiceAdapter extends RecyclerView.Adapter<DiceAdapter.MyViewHolder> {
    Context context;
    ArrayList<Dices> data;
    int layout;

    public DiceAdapter(Context context, ArrayList<Dices> data) {
        this.context = context;
        this.data = data;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img1, img2;
        TextView score;

        public MyViewHolder(final View itemView){
            super(itemView);
            this.img1 = (ImageView)itemView.findViewById(R.id.imgdice1);
            this.img2 = (ImageView)itemView.findViewById(R.id.imgdice2);
            this.score = (TextView)itemView.findViewById(R.id.score);
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layout, viewGroup, false);

        return new MyViewHolder(row);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder,final int i) {

        myViewHolder.img1.setImageResource(data.get(i).getImg1());
        myViewHolder.img2.setImageResource(data.get(i).getImg2());
        myViewHolder.score.setText(data.get(i).getScore());


        myViewHolder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoveItem(i);
            }
        });

    }

    public void RemoveItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    public int getItemCount() {
        return data.size();
    }
}
