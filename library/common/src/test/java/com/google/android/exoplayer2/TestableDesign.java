package com.google.android.exoplayer2;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Unit tests for {@link PercentageRating}. */
/** Unit tests for {@link Bundle}. */
@RunWith(AndroidJUnit4.class)
public class TestableDesign {


  //dummy method for the private static method of PercentageRating fromBundle method
  public PercentageRating PercentageRatingDummy() {
    Bundle bundle = new Bundle();
    bundle.putInt("0", 1);
    return PercentageRating.CREATOR.fromBundle(bundle);
  }

  //Percentage Rating Bundle Test that test the functionality for private static method for PercentageRating fromBundle method
  @SuppressLint("CheckResult")
  @Test
  public void PercentageRatingBundleTest() {
    Bundle bundle = new Bundle();
    bundle.putInt("0", 1);
    new PercentageRating();
    PercentageRating pr, pr2;
    pr = PercentageRatingDummy();
    pr2 = PercentageRating.CREATOR.fromBundle(bundle);

    assertThat(pr == pr2);
  }


  /**
   * JUnit test which examines the functionality of the fromBundle() (private method) from PercentageRating.java by creating a
   * public copy.
   *
   **/
  @Test
  public void PublicPercentageRatingTest(){
    //instantiating new percentage rating
    PercentageRating percentageRating = new PercentageRating(20);

    //bundling the percentage rating with the public toBundle method
    Bundle percentageRatingBundle = percentageRating.toBundle();

    //unbundling the bundled percentage rating
    PercentageRating percentageRatingBundledThenUnbundled = percentageRating.publicFromBundle(percentageRatingBundle);

    //asserting that the get percent() method from the unbundled Percentage rating is consistent with instantiation
    assertEquals(20,percentageRatingBundledThenUnbundled.getPercent(), 0 );
  }

  /**
   * JUnit test which examines the functionality of the fromBundle() (private method) from HeartRating.java by creating a
   * public copy.
   *
   **/
  @Test
  public void PublicHeartRatingTest(){
    //instantiating new Heart rating with true = "isHeart"
    HeartRating heartRating = new HeartRating(true);

    //bundling the heart rating with the public toBundle method
    Bundle heartRatingBundle = heartRating.toBundle();

    //unbundling the bundled heart rating
    HeartRating heartRatingBundledThenUnbundled = heartRating.publicFromBundle(heartRatingBundle);

    //asserting that the isHeart() method from the unbundled Heart rating is consistent with instantiation "true"
   assertTrue(heartRatingBundledThenUnbundled.isHeart());
  }



}
