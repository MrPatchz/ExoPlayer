package com.google.android.exoplayer2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.google.common.base.Objects;
import org.junit.Test;

/**
 * Whole test suite added for MSWE261
 */
public class ThumbRatingTest {

  /**
   * Tests basic instantiation of the thumbs up class
   */
  @Test
  public void checkDefaultThumbInstantiation(){
    ThumbRating thumbRating = new ThumbRating();
    assertFalse(thumbRating.isRated());
    assertFalse(thumbRating.isThumbsUp());
  }

  /**
   * Tests instantiation with a predefined thumbs up value
   * Also checks for proper function of the hash code method against a true, true objects hashcode
   */
  @Test
  public void checkThumbInstantiationWithRating(){
    ThumbRating thumbRating = new ThumbRating(true);
    assertTrue(thumbRating.isRated());
    assertTrue(thumbRating.isThumbsUp());
    assertEquals(thumbRating.hashCode(), Objects.hashCode(true, true));
  }

  /**
   * Checks if two thumbs up objects will equal each other correctly
   */
  @Test
  public void checkThumbEqualsFunctionality() {
    ThumbRating thumbRatingFirst = new ThumbRating(true);
    ThumbRating thumbRatingSecond = new ThumbRating();
    ThumbRating thumbRatingThird = new ThumbRating(true);
    assertFalse(thumbRatingSecond.equals(thumbRatingFirst));
    assertTrue(thumbRatingFirst.equals(thumbRatingThird));
    //Check if its not even an instance of thumbsup
    assertFalse(thumbRatingFirst.equals("taco"));
  }
}
