package co.cityindicator;

import android.app.Application;
import android.util.Log;

import co.cityindicator.db.CityIndicatorDatabase;

/**
 * Basic application class of the CityIndicator application.
 * Created by Kunal Bhavsar on 26/1/16.
 */
public class CityIndicatorApplication extends Application {
    private static final String TAG = CityIndicatorApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        CityIndicatorDatabase.initialize(this);
    }
}
