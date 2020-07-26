package com.pubg.sensitivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ramadpater extends RecyclerView.Adapter<ramadpater.ViewHolder> {

    private static  final  String Tag = "RecyclerView";
    private Context mContext;
    private int lastPosition = -1;

    private ArrayList<play> playlist;

    public ramadpater(Context mContext, ArrayList<play> ramlist) {
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
    public ramadpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ramlist, parent, false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ramadpater.ViewHolder holder, int position) {


        //textview
        holder.textView.setText(playlist.get(position).getName());


        //imageview

        Picasso.get()
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

    public static class  ViewHolder extends  RecyclerView.ViewHolder {
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
