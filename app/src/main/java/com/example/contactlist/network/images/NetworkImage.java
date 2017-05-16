package com.example.contactlist.network.images;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.contactlist.R;

public class NetworkImage
{
  private RequestManager requestManager;

  public NetworkImage(Context context){
      requestManager = Glide.with(context);
  }

  public void getImageAsync(String url, ImageView destination){
      requestManager
      .load(url)
      .centerCrop()
      .placeholder(R.mipmap.ic_launcher)
      .crossFade()
      .into(destination);
  }
}
