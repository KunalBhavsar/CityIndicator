package co.cityindicator.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Basic database class of the CityIndicator application.
 * Created by Kunal Bhavsar on 26/1/16.
 */
public class CityIndicatorDatabase extends SQLiteOpenHelper {

    //Database name and its current version.
    private static final String DATABASE_NAME = CityIndicatorDatabase.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;

    //Singleton instance of database.
    private static CityIndicatorDatabase dbHelper;

    /**
     * Initialize the singleton instance of the database.
     * @param appContext - application context required to intialise the database
     */
    public static void initialize(Context appContext) {
        if(dbHelper == null) {
            dbHelper = new CityIndicatorDatabase(appContext);
        }
    }

    /**
     * Get the singleton instance of database.
     * @return -  return <i>CityIndicatorDatabase</i> instance if initialized else return <i>null</i>
     */
    public synchronized static CityIndicatorDatabase getInstance() {
        return dbHelper;
    }

    public CityIndicatorDatabase(Context appContext) {
        super(appContext, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
