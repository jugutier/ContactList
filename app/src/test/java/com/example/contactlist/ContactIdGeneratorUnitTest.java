package com.example.contactlist;

import com.example.contactlist.model.FakeContactIdGenerator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class ContactIdGeneratorUnitTest {
  @Test
  public void contactIdGenerator_isIncremental() throws Exception  {
    int currentId = FakeContactIdGenerator.getInstance().generateId();
    int nextId = FakeContactIdGenerator.getInstance().generateId();
    assertThat("Contact Id is incremental", currentId < nextId);
  }

  @Test
  public void contactIdGenerator_isAtomic() throws Exception  {
    int numberOfTries = 50;
    int[] ids = new int[numberOfTries];
    for (int i=0; i< numberOfTries; i++){
      ThreadJigglePoint.jiggle();
      ids[i] = FakeContactIdGenerator.getInstance().generateId();
    }

    int acum = 0;
    for (int j = 0; j < numberOfTries; j++) {
     acum += ids[j];
    }
    assertThat(acum, is( (ids.length * (ids.length +1))/2) ) ; //Telescopic Sum.
  }

}