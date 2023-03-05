package com.google.android.exoplayer2.database;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
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

  private DatabaseProvider databaseProvider;

  private static final String TABLE_NAME = DatabaseProvider.TABLE_PREFIX + "Versions";

  private static final String COLUMN_FEATURE = "feature";
  private static final String COLUMN_INSTANCE_UID = "instance_uid";
  private static final String COLUMN_VERSION = "version";
  private static final String PRIMARY_KEY =
      "PRIMARY KEY (" + COLUMN_FEATURE + ", " + COLUMN_INSTANCE_UID + ")";


  /**
   * 261 Unit test
   */
  @Before
  public void setUp() {
    database = Mockito.mock(SQLiteDatabase.class);
    database.setVersion(-4);
    databaseProvider = TestUtil.getInMemoryDatabaseProvider();
    spyDatabase = spy(databaseProvider.getWritableDatabase());
  }

  /**
   * 261 Unit test
   */
  @Test
  public void MockDataBaseTesterGetVersion(){
    when(database.getVersion()).thenReturn(9);
    assertEquals(database.getVersion(), 9);
    verify(database, atLeastOnce()).getVersion();
  }
  /**
   * 261 Unit test
   */
  @Test
  public void MockDataBaseTesterGetSize(){
    when(database.getMaximumSize()).thenReturn((long) 9000);
    assertEquals(database.getMaximumSize(), 9000);
  }
  /**
   * 261 Unit test
   */
  @Test
  public void MockDataBaseVerifySetArgument(){
    verify(database).setVersion(eq(-4));
  }
  /**
   * 261 Unit test
   */
  @Test
  public void MockDataBaseVerifyTableCreatedTwiceVersionTable() throws DatabaseIOException {
    VersionTable.setVersion(spyDatabase, 1, "1", 1);
    VersionTable.setVersion(spyDatabase, 1, "2", 2);
    verify(spyDatabase, times(2)).execSQL("CREATE TABLE IF NOT EXISTS "
        + TABLE_NAME
        + " ("
        + COLUMN_FEATURE
        + " INTEGER NOT NULL,"
        + COLUMN_INSTANCE_UID
        + " TEXT NOT NULL,"
        + COLUMN_VERSION
        + " INTEGER NOT NULL,"
        + PRIMARY_KEY
        + ")");
  }
}
