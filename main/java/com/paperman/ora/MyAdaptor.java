package com.paperman.ora;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {
    private ArrayList<Model>mList;
    private Context context;
    private ItemClickListner mItemListner;
    public MyAdaptor(Context context,ArrayList<Model>mList,ItemClickListner itemClickListner){
        this.mItemListner=itemClickListner;
        this.context=context;
        this.mList=mList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getImageUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(view->{
            mItemListner.onitemClick(mList.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public interface ItemClickListner{
        void onitemClick(Model model);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
