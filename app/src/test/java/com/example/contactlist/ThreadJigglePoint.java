package com.example.contactlist;
//Utility function to test for thread safe. Idea from Clean Code Page 189.

public class ThreadJigglePoint {

  public static void jiggle() {
    int randomValue = randomFrom(1, 3);
    if(1 == randomValue)
    {
      Thread.yield();
    }
    else if(2 == randomValue)
      try {
        Thread.sleep(5);
      } catch(InterruptedException e) {

      }
    else{
      //NO-OP
    }
  }

  private static int randomFrom(int a, int b) {
    int result = (int) ((a-b)*Math.random() + b);
    return result;
  }
}