package uz.learn.chapter6.exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndexOfTest {

  @Test
  public void positiveCharPositiveIndex(){
    String a = "salom";
    int index = a.indexOf('l', 0);
    assertEquals(2, index);
  }
  @Test
  public void zeroCharPositiveIndex(){
    String a = "salom0";
    int index = a.indexOf(0, 0);
    assertEquals(-1, index);
  }
  @Test
  public void positiveCharNegativeIndex(){
    String a = "salom";
    int index = a.indexOf('l', -8);
    assertEquals(2, index);
  }
  @Test
  public void positiveCharOutofBoundIndex(){
    String a = "salom";
    int index = a.indexOf('l', 20);
    assertEquals(-1, index);
  }
  @Test
  public void negativeCharPositiveIndex(){
    String a = "salom";
    int index = a.indexOf(-1, 0);
    assertEquals(-1, index);
  }
}
