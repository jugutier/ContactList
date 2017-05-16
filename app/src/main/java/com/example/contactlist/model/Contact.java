package com.example.contactlist.model;

/**
 * Models a Contact from our contact list.
 */
@SuppressWarnings({"unused"})
public class Contact {
  public static final transient String KEY = "Contact";
  private String id;
  private String name;
  private String image_url;
  private String position;

  public Contact() {
    id = String.valueOf(FakeContactIdGenerator.getInstance().generateId());
  }

  public String getId() {
    return id;
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
  public String toString() {
    return "Contact{" +
        "id= '" + id + '\'' +
        ", name='" + name + '\'' +
        ", image_url='" + image_url + '\'' +
        ", position='" + position + '\'' +
        '}';
  }
}
