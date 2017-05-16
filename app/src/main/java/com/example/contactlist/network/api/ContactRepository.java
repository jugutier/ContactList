package com.example.contactlist.network.api;

import com.example.contactlist.model.Contact;
import com.example.contactlist.model.Roster;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class ContactRepository {
  private static final String TAG = ContactRepository.class.getSimpleName();

  private List<Contact> contacts;

  /**
   * Simulates getting part of a list coming in an API --
   * Currently blocking, in production this would also be asynchronous.
   */
  public ContactRepository(Datasource datasource) {
    Gson gson = new GsonBuilder().create();
    Roster roster = gson.fromJson(datasource.getRawReader(), Roster.class);
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


}
