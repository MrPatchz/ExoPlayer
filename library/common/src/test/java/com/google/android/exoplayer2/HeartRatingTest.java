package com.google.android.exoplayer2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.common.base.Objects;
import org.junit.Test;

/**
 * Whole test suite added for MSWE261
 */
public class HeartRatingTest {

  /**
   * Tests basic instantiation of the HeartRating class
   */
  @Test
  public void checkDefaultThumbInstantiation(){
    HeartRating heartRating = new HeartRating();
    assertFalse(heartRating.isRated());
    assertFalse(heartRating.isHeart());
  }

  /**
   * Tests instantiation with a predefined HeartRating value
   * Also checks for proper function of the hash code method against a true, true objects hashcode
   */
  @Test
  public void checkThumbInstantiationWithRating(){
    HeartRating heartRating = new HeartRating(true);
    assertTrue(heartRating.isRated());
    assertTrue(heartRating.isHeart());
    assertEquals(heartRating.hashCode(), Objects.hashCode(true, true));
  }

  /**
   * Checks if two HeartRating objects will equal each other correctly
   */
  @Test
  public void checkThumbEqualsFunctionality() {
    HeartRating heartRatingFirst = new HeartRating(true);
    HeartRating heartRatingSecond = new HeartRating();
    HeartRating heartRatingThird = new HeartRating(true);
    assertFalse(heartRatingSecond.equals(heartRatingFirst));
    assertTrue(heartRatingFirst.equals(heartRatingThird));
    //Check if its not even an instance of thumbsup
    assertFalse(heartRatingFirst.equals("taco"));
  }
}
