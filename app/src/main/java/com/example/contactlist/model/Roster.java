package com.example.contactlist.model;

import java.util.List;


public class Roster
{
  private List<Contact> roster;

  public Roster(){};

  public List<Contact> getContacts()
  {
    return roster;
  }

  public void setContacts(List<Contact> contacts)
  {
    this.roster = contacts;
  }
}
