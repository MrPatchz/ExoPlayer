package com.google.android.exoplayer2.database;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.database.sqlite.SQLiteDatabase;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.google.android.exoplayer2.testutil.TestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/** Unit tests for {@link VersionTable}. */
@RunWith(AndroidJUnit4.class)
public class MockDataBaseTest {
  private SQLiteDatabase database;

  private SQLiteDatabase spyDatabase;

  @Before
  public void setUp() {
    database = Mockito.mock(SQLiteDatabase.class);
    database.setVersion(-4);
    spyDatabase = spy(database);
  }

  @Test
  public void MockDataBaseTesterGetVersion(){
    when(database.getVersion()).thenReturn(9);
    assertEquals(database.getVersion(), 9);
    verify(database, atLeastOnce()).getVersion();
  }

  @Test
  public void MockDataBaseTesterGetSize(){
    when(database.getMaximumSize()).thenReturn((long) 9000);
    assertEquals(database.getMaximumSize(), 9000);
  }

  @Test
  public void MockDataBaseVerifySetArgument(){
    verify(database).setVersion(eq(-4));
  }

}
