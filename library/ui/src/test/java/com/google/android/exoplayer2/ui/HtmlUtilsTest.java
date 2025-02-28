/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer2.ui;

import static com.google.common.truth.Truth.assertThat;

import android.graphics.Color;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Tests for {@link HtmlUtils}. */
@RunWith(AndroidJUnit4.class)
public class HtmlUtilsTest {

  @Test
  public void toCssRgba_exactAlpha() {
    String cssRgba = HtmlUtils.toCssRgba(Color.argb(51, 13, 23, 37));
    assertThat(cssRgba).isEqualTo("rgba(13,23,37,0.200)");
  }

  @Test
  public void toCssRgba_truncatedAlpha() {
    String cssRgba = HtmlUtils.toCssRgba(Color.argb(100, 13, 23, 37));
    assertThat(cssRgba).isEqualTo("rgba(13,23,37,0.392)");
  }

  /**
   * Tests for an invalid ARGB value of all -1
   *This should default to the maximum values.
   */
  @Test
  public void toCssRgba_InavlidRGBA() {
    String cssRgba = HtmlUtils.toCssRgba(Color.argb(-1, -1, -1, -1));
    assertThat(cssRgba).isEqualTo("rgba(255,255,255,1.000)");
  }


  /**
   * Tests to see if expected returns the expected value instead of throwing an exception
   *This should default to expected value.
   */

  @Test
  public void InvalidExpectedCssRgba_truncatedAlpha() {
    String cssRgba = HtmlUtils.toCssRgba(Color.argb(100, 13, 23, 37));
    System.out.println(cssRgba);
    assertThat(cssRgba).isEqualTo("rgba(13,23,37,0.392)");
  }
}
