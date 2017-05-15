package com.example.contactlist.network.images;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.contactlist.R;

public class NetworkImage
{

  public static void getImage(Context context, String url, ImageView destination){
    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .placeholder(R.mipmap.ic_launcher)
        .crossFade()
        .into(destination);
  }
}
