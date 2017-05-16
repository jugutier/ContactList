package com.example.contactlist.network.api;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.contactlist.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Datasource {
  private static final String TAG = Datasource.class.getSimpleName();
  private static final int FILE_LOCATION = R.raw.sample_contacts;
  private static final String FILE_ENCODING = "UTF-8";

  private Context context;

  /**
   * Initialize Datasource, simulates conectivity with a persintance or network API layer.
   * @param activity an activity from which local resources can be accessed.
   * Note that this parameter wouldn't be necessary if accessing a remote server.
  */
  public Datasource(Context context) {
    this.context = context;
  }

  InputStreamReader getRawReader() {
    InputStream is = context.getResources().openRawResource(FILE_LOCATION);
    InputStreamReader inputStreamReader = null;
    try {
      inputStreamReader = new InputStreamReader(is, FILE_ENCODING);
    } catch (IOException e){
      Log.e(TAG, "Error when parsing contacts");
    }
    return inputStreamReader;
  }
}
