package com.google.android.exoplayer2;

import static com.google.common.truth.Truth.assertThat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.test.ext.junit.runners.AndroidJUnit4;
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
}
