package com.aduhack.whatareyoucravingforagain.helper;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

/**
 * Created by jaggEd2 on 12/7/14.
 */
public class LocationHelper {
    Location location = null;
    protected LocationManager mlocManager;
    protected LocationListener mlocListener;
    private Context _context;
    private double selflat;
    private double selflong;

    public LocationHelper(Context context){
        _context = context;
    }

    public void setUpGPS() {
        mlocManager = (LocationManager) _context.getSystemService(Context.LOCATION_SERVICE);
        mlocListener = new LocationListenerHelper(_context);
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5, 0, mlocListener);
    }

    public Location showCurrentLocation() {

        if (mlocManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            location = mlocManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }

        if (location != null) {
            selflat = location.getLatitude();
            selflong = location.getLongitude();
        }
        return location;
    }

    public float getDistanceInMiles(String geolocation) {
        String[] geoResto = geolocation.split(", ");
        double lat1 = Double.parseDouble(geoResto[0]);
        double lng1 = Double.parseDouble(geoResto[1]);
        float [] dist = new float[1];
        Location.distanceBetween(lat1, lng1, selflat, selflong, dist);
        return dist[0];
    }
}
