package com.example.contactlist.model;


public class Contact
{
  public static final transient String KEY = "Contact";
  private String name;
  private String image_url;
  private String position;

  public Contact()
  {

  }

  public String getName()
  {
    return name;
  }

  public String getImage_url()
  {
    return image_url;
  }

  public String getPosition()
  {
    return position;
  }

  @Override
  public String toString()
  {
    return "Contact{" +
        "name='" + name + '\'' +
        ", image_url='" + image_url + '\'' +
        ", position='" + position + '\'' +
        '}';
  }
}
