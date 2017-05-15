package com.example.contactlist.model;


public class Contact
{
  private String name;
  private String image_url;
  private String position;

  public Contact()
  {

  }

  public String getName()
  {
    return "John Doe No." + (Math.random() * 100);
  }

  public String getImage_url()
  {
    return "http://3.cdn.nhle.com/canucks/v2/photos/mugs/8471266.jpg";
  }

  public String getPosition()
  {
    return "N/A";
  }
}
