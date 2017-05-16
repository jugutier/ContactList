package com.example.contactlist.model;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Simulates a contact id that would come from the database or external API.
 */
public class FakeContactIdGenerator
{
  private static FakeContactIdGenerator instance;

  private AtomicInteger currentId;

  private FakeContactIdGenerator(){
    currentId = new AtomicInteger(0);
  }

  public static FakeContactIdGenerator getInstance(){
    if(instance == null)
    {
      synchronized (FakeContactIdGenerator.class)
      {
        if(instance == null)
        {
          instance = new FakeContactIdGenerator();
        }
      }
    }

    return instance;
  }

  public int generateId(){
    return currentId.incrementAndGet();
  }
}
