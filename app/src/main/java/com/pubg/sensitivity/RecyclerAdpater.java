package com.pubg.sensitivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;

public class RecyclerAdpater extends RecyclerView.Adapter<RecyclerAdpater.ViewHolder> {

    private static  final  String Tag = "RecyclerView";
    private Context mContext;
    private int lastPosition = -1;

    private ArrayList<play> playlist;

    public RecyclerAdpater(Context mContext, ArrayList<play> playlist) {
        this.mContext = mContext;
        this.playlist = playlist;
    }
    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @NonNull
    @Override
    public RecyclerAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playitem, parent, false);
       return  new ViewHolder(view);


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //textview
        holder.textView.setText(playlist.get(position).getName());


        //imageview

        Glide.with(mContext)
                .load(playlist.get(position).getImage())
                .into(holder.imageView);



        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;





    }

    @Override
    public int getItemCount() {
        return playlist.size();
    }

    public void filteredlist(ArrayList<play> filterlist) {
        playlist = filterlist;
        notifyDataSetChanged();
    }

    public static class  ViewHolder extends  RecyclerView.ViewHolder{
        //widget
        ImageView imageView;
        TextView textView;








        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);


        }

    }
}
