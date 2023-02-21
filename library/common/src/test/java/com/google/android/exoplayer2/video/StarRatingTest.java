package com.google.android.exoplayer2.video;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.google.android.exoplayer2.HeartRating;
import com.google.android.exoplayer2.StarRating;
import com.google.common.base.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;


public class StarRatingTest {

  @Test
  //initiates check to make sure two objects do not equal each other.
  public void checkIfTwoObjectsDoNotEqualEachOther(){

    StarRating starRating = new StarRating(1000, 3.2f);
    StarRating starRating2 = new StarRating(2000, 4.2f);
    assertFalse(starRating.equals(starRating2));
  }

  @Test
  //initiates check to see if getMaxStars method is align with the object starRating
  //Tests to see if isRated returns true as a boolean.
  public void checkingIsRatedandGetMethodsandHashCode(){

    StarRating starRating = new StarRating(1000, 3.2f);
    assertThat(starRating.getMaxStars()).isEqualTo(1000);
    assertThat(starRating.getStarRating()).isEqualTo(3.2f);
    assertTrue(starRating.isRated());
    assertEquals(starRating.hashCode(), Objects.hashCode(1000, 3.2f));
  }



//checking the relationship between multiple objects for starrating
  //checking to see if one objects can be equal to a string.
  @Test
  public void checkingRelationshipBetweenObjects() {
    StarRating starRating = new StarRating(2000, 3.5f);
    StarRating starRating2 = new StarRating(2000, 3.5f);
    StarRating starRating3 = new StarRating(5000, 4.9f);
    assertTrue(starRating.equals(starRating2));
    assertFalse(starRating.equals(starRating3));
    assertFalse(starRating.equals("rabbit"));



  }



}
