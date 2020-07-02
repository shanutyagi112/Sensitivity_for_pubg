package com.pubg.sensitivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
import java.util.List;

public class charadapter extends  RecyclerView.Adapter<charadapter.ViewHolder> {

    private static  final  String Tag = "RecyclerView";
    private Context mContext;
    private int lastPosition = -1;

    private ArrayList<charact> charactlist;

    public charadapter(Context mContext, ArrayList<charact> charactlist) {
        this.mContext = mContext;
        this.charactlist = charactlist;
    }
    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();

    }

    @NonNull
    @Override
    public charadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.charlist, parent, false);
        return  new ViewHolder(view);


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //textview
        holder.textView.setText(charactlist.get(position).getPlayer());
        holder.textView1.setText(charactlist.get(position).getCharacter());
        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;

    }

    @Override
    public int getItemCount() {
        return charactlist.size();
    }

    public void filteredlist(ArrayList<charact> filterlist) {
        charactlist = filterlist;
        notifyDataSetChanged();
    }

    public static class  ViewHolder extends  RecyclerView.ViewHolder{
        //widget

        TextView textView ,textView1;








        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textView = itemView.findViewById(R.id.textview);
            textView1 = itemView.findViewById(R.id.textview1);


        }

    }
}
