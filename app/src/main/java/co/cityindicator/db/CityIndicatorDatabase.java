package co.cityindicator.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Basic database class of the CityIndicator application.
 * Created by Kunal Bhavsar on 26/1/16.
 */
public class CityIndicatorDatabase extends SQLiteOpenHelper {

    private static final String TAG = CityIndicatorDatabase.class.getSimpleName();

    //Database name and its current version.
    private static final String DATABASE_NAME = "CityIndicator.sqlite";
    private static final int DATABASE_VERSION = 1;

    //Singleton instance of database.
    private static CityIndicatorDatabase dbHelper;

    //Database operation constants
    private static final String CREATE_TABLE = "CREATE TABLE ";
    private static final String INTEGER_PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT";
    private static final String TEXT_NOT_NULL = " TEXT NOT NULL";
    private static final String TEXT_NULL = " TEXT NULL";
    private static final String INTEGER_NOT_NULL = " INTEGER NOT NULL";
    private static final String INTEGER_NULL = " INTEGER NULL";
    private static final String DROP_TABLE_IF_EXIST = "DROP TABLE IF EXISTS ";
    private static final String FOREIGN_KEY = " FOREIGN KEY";
    private static final String REFERENCES = " REFERENCES ";

    //Local id and resource id constants
    private static final String KEY_LOCAL_ID = "_id";
    private static final String KEY_RESOURCE_ID = "resource_id";
    private static final String KEY_VERSION = "version";

    //City table related constants
    private static final String TABLE_CITY = "city";
    private static final String KEY_CITY_NAME = "name";
    private static final String KEY_SUPERCITY_LOCAL_ID = "supercity";
    private static final String KEY_CITY_DESCRIPTION = "description";

    //City table transactions related constants
    private static final String CREATE_TABLE_CITY = CREATE_TABLE + TABLE_CITY + "("
            + KEY_LOCAL_ID + INTEGER_PRIMARY_KEY + ", "+ KEY_RESOURCE_ID + INTEGER_NOT_NULL + ", "
            + KEY_CITY_NAME + TEXT_NOT_NULL + ", " + KEY_CITY_DESCRIPTION + TEXT_NULL + ", "
            + KEY_SUPERCITY_LOCAL_ID + INTEGER_NULL + ", "+ KEY_VERSION + INTEGER_NOT_NULL + ", "
            + FOREIGN_KEY + "(" + KEY_SUPERCITY_LOCAL_ID + ")" + REFERENCES + TABLE_CITY + "(" + KEY_LOCAL_ID + "));";
    private static final String DROP_TABLE_CITY = DROP_TABLE_IF_EXIST + TABLE_CITY;

    //Train table related constants
    private static final String TABLE_TRAIN = "train";
    private static final String KEY_TRAIN_NUMBER = "number";
    private static final String KEY_TRAIN_NAME = "name";
    private static final String KEY_TRAIN_DIRECTION = "direction";
    private static final String KEY_FROM_CITY_LOCAL_ID = "from_city";
    private static final String KEY_TO_CITY_LOCAL_ID = "to_city";

    //Train table transactions related constants
    private static final String CREATE_TABLE_TRAIN = CREATE_TABLE + TABLE_TRAIN + "("
            + KEY_LOCAL_ID + INTEGER_PRIMARY_KEY + ", "+ KEY_RESOURCE_ID + INTEGER_NOT_NULL + ", "
            + KEY_TRAIN_NAME + TEXT_NOT_NULL + ", " + KEY_TRAIN_NUMBER + TEXT_NOT_NULL + ", "
            + KEY_FROM_CITY_LOCAL_ID + INTEGER_NOT_NULL + ", " + KEY_TO_CITY_LOCAL_ID + INTEGER_NOT_NULL + ", "
            + KEY_TRAIN_DIRECTION + TEXT_NOT_NULL + ", "+ KEY_VERSION + INTEGER_NOT_NULL + ", "
            + FOREIGN_KEY + "(" + KEY_FROM_CITY_LOCAL_ID + ")" + REFERENCES + TABLE_CITY + "(" + KEY_LOCAL_ID + "),"
            + FOREIGN_KEY + "(" + KEY_TO_CITY_LOCAL_ID + ")" + REFERENCES + TABLE_CITY + "(" + KEY_LOCAL_ID + "));";
    private static final String DROP_TABLE_TRAIN = DROP_TABLE_IF_EXIST + TABLE_TRAIN;

    //Train stop table related constants
    private static final String TABLE_TRAIN_STOP = "train_stop";
    private static final String KEY_ARRIAVAL_TIME = "arriaval_time";
    private static final String KEY_DEPARTURE_TIME = "departure_time";
    private static final String KEY_TRAIN_STOP_SUN = "sunday";
    private static final String KEY_TRAIN_STOP_MON = "monday";
    private static final String KEY_TRAIN_STOP_TUE = "tuesday";
    private static final String KEY_TRAIN_STOP_WED = "wednesday";
    private static final String KEY_TRAIN_STOP_THU = "thursday";
    private static final String KEY_TRAIN_STOP_FRI = "friday";
    private static final String KEY_TRAIN_STOP_SAT = "saturday";
    private static final String KEY_TRAIN_STOP_CITY_LOCAL_ID = "city";
    private static final String KEY_TRAIN_STOP_TRAIN_LOCAL_ID = "train";

    //Train stop table transactions related constants
    private static final String CREATE_TABLE_TRAIN_STOP = CREATE_TABLE + TABLE_TRAIN_STOP + "("
            + KEY_LOCAL_ID + INTEGER_PRIMARY_KEY + ", "+ KEY_RESOURCE_ID + INTEGER_NOT_NULL + ", "
            + KEY_ARRIAVAL_TIME + INTEGER_NOT_NULL + ", " + KEY_DEPARTURE_TIME + INTEGER_NOT_NULL + ", "
            + KEY_TRAIN_STOP_SUN + INTEGER_NOT_NULL + ", " + KEY_TRAIN_STOP_MON + INTEGER_NOT_NULL + ", "
            + KEY_TRAIN_STOP_TUE + INTEGER_NOT_NULL + ", " + KEY_TRAIN_STOP_WED + INTEGER_NOT_NULL + ", "
            + KEY_TRAIN_STOP_THU + INTEGER_NOT_NULL + ", " + KEY_TRAIN_STOP_FRI + INTEGER_NOT_NULL + ", "
            + KEY_TRAIN_STOP_SAT + INTEGER_NOT_NULL + ", " + KEY_TRAIN_STOP_TRAIN_LOCAL_ID + INTEGER_NOT_NULL + ", "
            + KEY_TRAIN_STOP_CITY_LOCAL_ID + INTEGER_NOT_NULL + ", "+ KEY_VERSION + INTEGER_NOT_NULL + ", "
            + FOREIGN_KEY + "(" + KEY_TRAIN_STOP_TRAIN_LOCAL_ID + ")" + REFERENCES + TABLE_TRAIN + "(" + KEY_LOCAL_ID + "),"
            + FOREIGN_KEY + "(" + KEY_TRAIN_STOP_CITY_LOCAL_ID + ")" + REFERENCES + TABLE_CITY + "(" + KEY_LOCAL_ID + "));";
    private static final String DROP_TABLE_TRAIN_STOP = DROP_TABLE_IF_EXIST + TABLE_TRAIN_STOP;

    //Entity group table related constants
    private static final String TABLE_ENTITY_GROUP = "entity_group";
    private static final String KEY_ENTITY_GROUP_TITLE = "title";

    //Entity group table operation related constants
    private static final String CREATE_TABLE_ENTITY_GROUP = CREATE_TABLE + TABLE_ENTITY_GROUP + "("
            + KEY_LOCAL_ID + INTEGER_PRIMARY_KEY + ", "+ KEY_RESOURCE_ID + INTEGER_NOT_NULL + ", "
            + KEY_VERSION + INTEGER_NOT_NULL + ", "+ KEY_ENTITY_GROUP_TITLE + TEXT_NOT_NULL + ");";
    private static final String DROP_TABLE_ENTITY_GROUP = DROP_TABLE_IF_EXIST + TABLE_ENTITY_GROUP;

    //Entity table related constants
    private static final String TABLE_ENTITY = "entity";
    private static final String KEY_ENTITY_NAME = "name";
    private static final String KEY_ENTITY_DESCRIPTION = "description";
    private static final String KEY_ENTITY_DOB = "dob";
    private static final String KEY_PRIVATE_ENTITY = "private_entity";

    //Entity table operation related constants
    private static final String CREATE_TABLE_ENTITY = CREATE_TABLE + TABLE_ENTITY + "("
            + KEY_LOCAL_ID + INTEGER_PRIMARY_KEY + ", "+ KEY_RESOURCE_ID + INTEGER_NOT_NULL + ", "
            + KEY_ENTITY_NAME + TEXT_NOT_NULL + ", " + KEY_ENTITY_DESCRIPTION + TEXT_NULL + ", "
            + KEY_ENTITY_DOB + INTEGER_NULL + ", " + KEY_PRIVATE_ENTITY + INTEGER_NOT_NULL + ", "
            + KEY_VERSION + INTEGER_NOT_NULL + ");";
    private static final String DROP_TABLE_ENTITY = DROP_TABLE_IF_EXIST + TABLE_ENTITY;

    //Entity and city relation table related constants
    private static final String TABLE_ENTITY_AND_CITY_REL = "entity_and_entity_city_rel";
    private static final String KEY_ENTITY_LOCAL_ID = "entity_id";
    private static final String KEY_CITY_LOCAL_ID = "city_id";

    //Entity and city relation table related constants
    private static final String CREATE_TABLE_ENTITY_AND_CITY_REL = CREATE_TABLE + TABLE_ENTITY_AND_CITY_REL + "("
            + KEY_CITY_LOCAL_ID + INTEGER_NOT_NULL + ", " + KEY_ENTITY_LOCAL_ID + INTEGER_NOT_NULL + ", "
            + FOREIGN_KEY + "(" + KEY_CITY_LOCAL_ID + ")" + REFERENCES + TABLE_CITY + "(" + KEY_LOCAL_ID + "),"
            + FOREIGN_KEY + "(" + KEY_ENTITY_LOCAL_ID + ")" + REFERENCES + TABLE_ENTITY + "(" + KEY_LOCAL_ID + "));";
    private static final String DROP_TABLE_ENTITY_AND_CITY_REL = DROP_TABLE_IF_EXIST + TABLE_ENTITY_AND_CITY_REL;

    //Entity and Entity group relation table related constants
    private static final String TABLE_ENTITY_AND_ENTITY_GROUP_REL = "entity_and_entity_group_rel";
    private static final String KEY_GROUP_LOCAL_ID = "group_id";

    //Entity and Entity group relation table related constants
    private static final String CREATE_TABLE_ENTITY_AND_ENTITY_GROUP_REL = CREATE_TABLE + TABLE_ENTITY_AND_ENTITY_GROUP_REL + "("
            + KEY_GROUP_LOCAL_ID + INTEGER_NOT_NULL + ", " + KEY_ENTITY_LOCAL_ID + INTEGER_NOT_NULL + ", "
            + FOREIGN_KEY + "(" + KEY_GROUP_LOCAL_ID + ")" + REFERENCES + TABLE_ENTITY_GROUP + "(" + KEY_LOCAL_ID + "),"
            + FOREIGN_KEY + "(" + KEY_ENTITY_LOCAL_ID + ")" + REFERENCES + TABLE_ENTITY + "(" + KEY_LOCAL_ID + "));";
    private static final String DROP_TABLE_ENTITY_AND_ENTITY_GROUP_REL = DROP_TABLE_IF_EXIST + TABLE_ENTITY_AND_ENTITY_GROUP_REL;

    //Contact table related constants
    private static final String TABLE_ENTITY_CONTACT = "entity_contact";
    private static final String KEY_ENTITY_CONTACT_TYPE = "type";
    private static final String KEY_ENTITY_CONTACT_VALUE = "value";
    private static final String KEY_ENTITY_CONTACT_DATA_TYPE = "data_type";

    //Entity contact table operation related constants
    private static final String CREATE_TABLE_ENTITY_CONTACT = CREATE_TABLE + TABLE_ENTITY_CONTACT + "("
            + KEY_LOCAL_ID + INTEGER_PRIMARY_KEY + ", "+ KEY_RESOURCE_ID + INTEGER_NOT_NULL + ", "
            + KEY_ENTITY_CONTACT_TYPE + TEXT_NOT_NULL + ", " + KEY_ENTITY_CONTACT_VALUE + TEXT_NOT_NULL + ", "
            + KEY_ENTITY_CONTACT_DATA_TYPE + TEXT_NOT_NULL + ", " + KEY_ENTITY_LOCAL_ID + INTEGER_NOT_NULL + ", "
            + KEY_VERSION + INTEGER_NOT_NULL + ", "
            + FOREIGN_KEY + "(" + KEY_ENTITY_LOCAL_ID + ")" + REFERENCES + TABLE_ENTITY + "(" + KEY_LOCAL_ID + "));";
    private static final String DROP_TABLE_ENTITY_CONTACT = DROP_TABLE_IF_EXIST + TABLE_ENTITY_CONTACT;

    //Entity rating table related constants
    private static final String TABLE_ENTITY_RATING = "entity_rating";
    private static final String KEY_ENTITY_RATING = "rating";
    private static final String KEY_RATING_COMMENT = "comment";
    private static final String KEY_BY_ENTITY_LOCAL_ID = "by_entity";
    private static final String KEY_TO_ENTITY_LOCAL_ID = "to_entity";

    //Entity rating table operation related constants
    private static final String CREATE_TABLE_ENTITY_RATING = CREATE_TABLE + TABLE_ENTITY_RATING + "("
            + KEY_LOCAL_ID + INTEGER_PRIMARY_KEY + ", "+ KEY_RESOURCE_ID + INTEGER_NOT_NULL + ", "
            + KEY_ENTITY_RATING + INTEGER_NOT_NULL + ", " + KEY_RATING_COMMENT + TEXT_NULL + ", "
            + KEY_BY_ENTITY_LOCAL_ID + INTEGER_NOT_NULL + ", " + KEY_TO_ENTITY_LOCAL_ID + INTEGER_NOT_NULL + ", "
            + KEY_VERSION + INTEGER_NOT_NULL + ", "
            + FOREIGN_KEY + "(" + KEY_BY_ENTITY_LOCAL_ID + ")" + REFERENCES + TABLE_ENTITY + "(" + KEY_LOCAL_ID + "), "
            + FOREIGN_KEY + "(" + KEY_TO_ENTITY_LOCAL_ID + ")" + REFERENCES + TABLE_ENTITY + "(" + KEY_LOCAL_ID + "));";
    private static final String DROP_TABLE_ENTITY_RATING = DROP_TABLE_IF_EXIST + TABLE_ENTITY_RATING;

    /**
     * Initialize the singleton instance of the database.
     * @param appContext - <i>application context</i> required to intialise the database
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
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        logOperation(CREATE_TABLE_CITY);
        db.execSQL(CREATE_TABLE_CITY);
        logOperation(CREATE_TABLE_TRAIN);
        db.execSQL(CREATE_TABLE_TRAIN);
        logOperation(CREATE_TABLE_TRAIN_STOP);
        db.execSQL(CREATE_TABLE_TRAIN_STOP);
        logOperation(CREATE_TABLE_ENTITY_GROUP);
        db.execSQL(CREATE_TABLE_ENTITY_GROUP);
        logOperation(CREATE_TABLE_ENTITY);
        db.execSQL(CREATE_TABLE_ENTITY);
        logOperation(CREATE_TABLE_ENTITY_CONTACT);
        db.execSQL(CREATE_TABLE_ENTITY_CONTACT);
        logOperation(CREATE_TABLE_ENTITY_RATING);
        db.execSQL(CREATE_TABLE_ENTITY_RATING);
        logOperation(CREATE_TABLE_ENTITY_AND_CITY_REL);
        db.execSQL(CREATE_TABLE_ENTITY_AND_CITY_REL);
        logOperation(CREATE_TABLE_ENTITY_AND_ENTITY_GROUP_REL);
        db.execSQL(CREATE_TABLE_ENTITY_AND_ENTITY_GROUP_REL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public synchronized  void dropAllTables() {
        logOperation(DROP_TABLE_ENTITY_AND_CITY_REL);
        getWritableDatabase().execSQL(DROP_TABLE_ENTITY_AND_CITY_REL);
        logOperation(DROP_TABLE_ENTITY_AND_ENTITY_GROUP_REL);
        getWritableDatabase().execSQL(DROP_TABLE_ENTITY_AND_ENTITY_GROUP_REL);
        logOperation(DROP_TABLE_ENTITY_CONTACT);
        getWritableDatabase().execSQL(DROP_TABLE_ENTITY_CONTACT);
        logOperation(DROP_TABLE_ENTITY_RATING);
        getWritableDatabase().execSQL(DROP_TABLE_ENTITY_RATING);
        logOperation(DROP_TABLE_ENTITY_GROUP);
        getWritableDatabase().execSQL(DROP_TABLE_ENTITY_GROUP);
        logOperation(DROP_TABLE_ENTITY);
        getWritableDatabase().execSQL(DROP_TABLE_ENTITY);
        logOperation(DROP_TABLE_TRAIN_STOP);
        getWritableDatabase().execSQL(DROP_TABLE_TRAIN_STOP);
        logOperation(DROP_TABLE_TRAIN);
        getWritableDatabase().execSQL(DROP_TABLE_TRAIN);
        logOperation(DROP_TABLE_CITY);
        getWritableDatabase().execSQL(DROP_TABLE_CITY);
    }

    private void logOperation(String operation) {
        Log.d(TAG, "Executing database operation : " + operation);
    }
}
