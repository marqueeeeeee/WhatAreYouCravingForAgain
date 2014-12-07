package com.aduhack.whatareyoucravingforagain.helper;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by jaggEd2 on 12/7/14.
 */
public class LocationListenerHelper  implements LocationListener {

        private Context _context;

        public LocationListenerHelper(Context context) {
            _context = context;
        }

        @Override
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            String loc = "My current location is: "
                    + location.getLatitude() + "-" + location.getLongitude();

            //Toast.makeText(_context, loc, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(_context, "Gps Disabled",
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(_context, "Gps Enabled",
                    Toast.LENGTH_SHORT).show();
        }




    }

