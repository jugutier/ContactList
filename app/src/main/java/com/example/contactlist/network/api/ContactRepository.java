package com.example.contactlist.network.api;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.contactlist.R;
import com.example.contactlist.model.Contact;
import com.example.contactlist.model.Roster;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ContactRepository
{
  private static final String TAG = ContactRepository.class.getSimpleName();
  private static final int FILE_LOCATION = R.raw.sample_contacts;
  private static final String FILE_ENCODING = "UTF-8";
  private List<Contact> contacts;

  /**
   * Simulates getting part of a list coming in an API --
   * Currently blocking, in production this would also be asynchronous.
   * @param activity an activity from which local resources can be accessed.
   *                 Note that this parameter wouldn't be necessary if accessing a remote server.
   */
  public ContactRepository(Activity activity) {
    Gson gson = new GsonBuilder().create();
    Roster roster = gson.fromJson(getRawReader(activity), Roster.class);
    contacts = roster.getContacts();
  }

  public Contact getContactById(String contactId) {
    for (Contact contact: contacts) {
      if(contact.getId().equals(contactId)){
        return contact;
      }
    }
    return null;
  }

  public List<Contact> getAllContacts() {
    return contacts;
  }

  private static InputStreamReader getRawReader(Activity activity){
    InputStream is = activity.getResources().openRawResource(FILE_LOCATION);
    InputStreamReader inputStreamReader = null;
    try {
      inputStreamReader = new InputStreamReader(is, FILE_ENCODING);
    } catch (IOException e){
      Log.e(TAG, "Error when parsing contacts");
    }
    return inputStreamReader;
  }
}
