package com.myapp.rober.test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.net.URL;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<EntityNews> entityNewsArrayList;
    Context context;

    public CustomAdapter(ArrayList<EntityNews> entityNewsArrayList, Context context) {
        this.entityNewsArrayList = entityNewsArrayList;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img_thumb;
        TextView tv_country;
        TextView tv_headlines;
        ImageView img_more;

        MyViewHolder(View itemview){
            super(itemview);

            this.img_more = itemview.findViewById(R.id.img_more);
            this.img_thumb = itemview.findViewById(R.id.img_thumb);
            this.tv_country = itemview.findViewById(R.id.tv_country);
            this.tv_headlines = itemview.findViewById(R.id.tv_headlines);


        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View view = li.inflate(R.layout.entity_news,parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ImageView img_thumb = holder.img_thumb;
        TextView tv_country = holder.tv_country;
        TextView tv_headlines=holder.tv_headlines;
        ImageView img_more = holder.img_more;



        tv_country.setText(entityNewsArrayList.get(position).country+"");
        tv_headlines.setText(entityNewsArrayList.get(position).headlines+"");

        //===========set Image source from url

        try {

            URL image_url = new URL(entityNewsArrayList.get(position).thumb+"");
            Log.d("image_url", image_url+"");
            RequestOptions options= new RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);
            Glide.with(context).load(image_url).apply(options).into(img_thumb);

        }catch (Exception e){
            Log.d("error", e+"");
        }

        img_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

    }

    @Override
    public int getItemCount() {
        return entityNewsArrayList.size();
    }

    class submenuClickListeber implements PopupMenu.OnMenuItemClickListener{
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()){
                case R.id.action_bookmark:
                    Toast.makeText(context,"Bookmark is Clicked", Toast.LENGTH_LONG).show();
                    break;

                case R.id.action_more:
                    Toast.makeText(context,"More is Clicked", Toast.LENGTH_LONG).show();
                    break;
            }

            return false;
        }
    }

    private void showPopupMenu(View view){
      PopupMenu popup=new PopupMenu(context, view);
      MenuInflater inflater = popup.getMenuInflater();
      inflater.inflate(R.menu.menu_sub, popup.getMenu());
      popup.setOnMenuItemClickListener(new submenuClickListeber());
      popup.show();
    }

}
