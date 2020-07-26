package com.pubg.sensitivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class controladapter extends RecyclerView.Adapter<controladapter.ViewHolder> {


    private static  final  String Tag = "RecyclerView";
    private Context mContext;
    private int lastPosition = -1;

    private ArrayList<play> playlist;

    public controladapter(Context mContext, ArrayList<play> ramlist) {
        this.mContext = mContext;
        this.playlist = playlist;
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull controladapter.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.controllist, parent, false);

        return  new controladapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        //textview
        holder.textView.setText(playlist.get(position).getName());


        //imageview

        Picasso.get()
                .load(playlist.get(position).getImage())
                .into(holder.imageView);





    }

    @Override
    public int getItemCount() {
        return playlist.size();
    }


    public class ViewHolder  extends  RecyclerView.ViewHolder {
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
