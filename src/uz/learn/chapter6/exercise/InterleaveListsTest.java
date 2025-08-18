package uz.learn.chapter6.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static uz.learn.chapter5.ListUtils.interleaveLists;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class InterleaveListsTest {

 @Test(expected = NullPointerException.class)
 public void testNullAndNull(){
   interleaveLists(null, null);
 }

 @Test(expected = NullPointerException.class)
 public void testNullAndNonEmpty(){
   List<Integer> ls = List.of(3);
   interleaveLists(ls, null);
 }

 @Test
 public void testEmptyAndEmpty(){
   List<Integer> l1 = new ArrayList<>();
   List<Integer> l2 = new ArrayList<>();
   List<Integer> res =  interleaveLists(l1,l2);
   assertTrue(res.isEmpty());
 }
 @Test(expected = IllegalArgumentException.class)
 public void testNonEmptyAndEmpty(){
   List<Integer> l1 = List.of(3);
   List<Integer> l2 = new ArrayList<>();
    interleaveLists(l1,l2);
 }

 @Test
 public void testNonEmptyAndNonEmptyWithSameSize(){
   List<Integer> l1 = List.of(1,3,5);
   List<Integer> l2 = List.of(2,4,6);
   List<Integer> res =  interleaveLists(l1,l2);
   assertEquals(List.of(1,2,3,4,5,6), res);
 }
 @Test(expected = IllegalArgumentException.class)
 public void testNonEmptyAndNonEmptyWithDifferentSize(){
   List<Integer> l1 = List.of(1,3,5);
   List<Integer> l2 = List.of(2,4);
   interleaveLists(l1,l2);
 }
}
