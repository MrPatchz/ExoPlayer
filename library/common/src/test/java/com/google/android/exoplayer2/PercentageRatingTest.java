package com.google.android.exoplayer2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;
import org.junit.Test;

/**
 * Whole test suite added for MSWE261
 */

public class PercentageRatingTest {

  /**
   * Tests basic instantiation of the PercentageRating class
   */
  @Test
  public void checkDefaultPercentageInstantiation(){
    PercentageRating percentageRating = new PercentageRating();
    assertFalse(percentageRating.isRated());
  }

  /**
   * Tests instantiation of the PercentageRating class with negative value percent
   * Illegal Argument Exception is expected
   */

  @Test
  public void negativePercentageRating(){
    assertThrows(IllegalArgumentException.class, ()->{
          PercentageRating percentageRating = new PercentageRating(-10);
        });
  }

  /**
   * Tests instantiation of the PercentageRating class with edge value percent
   *
   */

  @Test
  public void upperEdgePercentage(){
   PercentageRating percentageRating = new PercentageRating(99.9f);
   float percent = percentageRating.getPercent();
   assertEquals(99.9f, 99.9f, 0);
  }


  /**
   * Tests instantiation with a predefined Percentage rating value
   * Also checks for proper function of the hash code method
   */

  @Test
  public void instantiateWithValidNumberAndCheckHash(){
    PercentageRating percentageRating = new PercentageRating(25);
    assertEquals(percentageRating.hashCode(), Objects.hashCode(percentageRating.getPercent()));
  }

  @Test
  public void instantiateAndBundle(){
    PercentageRating percentageRating = new PercentageRating();
    percentageRating.toBundle();

    }


  }



