package com.mobile.hulklee01.project01;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class AddActivity extends Activity implements LocationListener {
    LocationManager locManager;
    TextView latitudeText, addLatitudeText;
    TextView longitudeText, addLongitudeText;
    LocationInfo info;
    double latitude, longitude;
    boolean isPermitted = false;
    boolean isLocRequested = false;
    final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        info = (LocationInfo)getApplicationContext();

        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        latitudeText = (TextView) findViewById(R.id.Latitude);
        longitudeText = (TextView) findViewById(R.id.Longitude);
        addLatitudeText = (TextView) findViewById(R.id.AddLatitude);
        addLongitudeText = (TextView) findViewById(R.id.AddLongitude);

        requestRuntimePermission();

        try {
            if(isPermitted) {
                locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, this);
                isLocRequested = true;
            } else
                Toast.makeText(this, "Permission이 없습니다..", Toast.LENGTH_LONG).show();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    //*******************************************************************
    // Runtime permission check
    //*******************************************************************

    private void requestRuntimePermission() {

        if (ContextCompat.checkSelfPermission(AddActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(AddActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(AddActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }
        } else {
            isPermitted = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isPermitted = true;
                } else {
                    isPermitted = false;
                }
                return;
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        latitudeText.setText("   " + location.getLatitude());
        latitude = location.getLatitude();
        longitudeText.setText("   " + location.getLongitude());
        longitude = location.getLongitude();
        addLatitudeText.setText("  위도   " + location.getLatitude());
        addLongitudeText.setText("  경도   " + location.getLongitude());
    }

    public void onClickAddLocation(View view) {
        EditText editTextName = (EditText)findViewById(R.id.editTextName);
        EditText editTextRadius = (EditText)findViewById(R.id.editTextRadius);

        if(info.getName1() == null) {
            info.setName1(editTextName.getText().toString());
            info.setRadius1(Integer.parseInt(editTextRadius.getText().toString()));
            info.setLatitude1(latitude);
            info.setLongitude1(longitude);
        } else if(info.getName2() == null) {
            info.setName2(editTextName.getText().toString());
            info.setRadius2(Integer.parseInt(editTextRadius.getText().toString()));
            info.setLatitude2(latitude);
            info.setLongitude2(longitude);
        } else if(info.getName3() == null) {
            info.setName3(editTextName.getText().toString());
            info.setRadius3(Integer.parseInt(editTextRadius.getText().toString()));
            info.setLatitude3(latitude);
            info.setLongitude3(longitude);
        } else
            Toast.makeText(this, "저장소가 꽉 찼습니다!!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}
}
