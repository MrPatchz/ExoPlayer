package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Unit tests for {@link PercentageRating}. */
/** Unit tests for {@link Bundle}. */
@RunWith(AndroidJUnit4.class)
public class TestableDesign {
  @SuppressLint("CheckResult")
  @Test
  public void PercentageRatingBundleTest() {
    Bundle bundle = new Bundle();
    bundle.putInt("0", 1);
    PercentageRating.CREATOR.fromBundle(bundle);
  }
}
