package co.cityindicator.db;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by root on 26/1/16.
 */
public class CityIndicatorDatabase extends SQLiteDatabase {

    public CityIndicatorDatabase() {
        super("", 1, new CursorFactory(),  null);
    }
}
