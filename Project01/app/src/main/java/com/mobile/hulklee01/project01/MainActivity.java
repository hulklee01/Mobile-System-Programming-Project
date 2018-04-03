package com.mobile.hulklee01.project01;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locManager;
    BroadcastReceiver receiver;
    TextView info01, info02, info03;
    PendingIntent proximityIntent;
    private LocationInfo info = null;
    boolean isPermitted = false;
    boolean isLocRequested = false;
    boolean isAlertRegistered = false;
    final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = (LocationInfo) getApplicationContext();

        System.out.println("----------------< onCreate!!! >--------------" );
        info01 = (TextView)findViewById(R.id.Info01);
        info02 = (TextView)findViewById(R.id.Info02);
        info03 = (TextView)findViewById(R.id.Info03);

        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(info.getName1() != null) {
            info01.setText("1. " + info.getName1());
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    boolean isEntering = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);

                    if(isEntering)
                        Toast.makeText(context,  info.getName1() + "에 접근중입니다..", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(context, info.getName1() + "에서 벗어납니다..", Toast.LENGTH_LONG).show();
                }
            };
            IntentFilter filter = new IntentFilter("kr.ac.koreatech.msp.locationAlert");
            registerReceiver(receiver, filter);

            Intent intent = new Intent("kr.ac.koreatech.msp.locationAlert");
            proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            try {
                locManager.addProximityAlert(info.getLatitude1(), info.getLongitude1(), info.getRadius1(), -1, proximityIntent);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            isAlertRegistered = true;
        }

        if(info.getName2() != null) {
            info02.setText("2. " + info.getName2());
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    boolean isEntering = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);

                    if(isEntering)
                        Toast.makeText(context,  info.getName2() + "에 접근중입니다..", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(context, info.getName2() + "에서 벗어납니다..", Toast.LENGTH_LONG).show();
                }
            };
            IntentFilter filter = new IntentFilter("kr.ac.koreatech.msp.locationAlert");
            registerReceiver(receiver, filter);

            Intent intent = new Intent("kr.ac.koreatech.msp.locationAlert");
            proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            try {
                locManager.addProximityAlert(info.getLatitude2(), info.getLongitude2(), info.getRadius2(), -1, proximityIntent);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            isAlertRegistered = true;
        }

        if(info.getName3() != null) {
            info03.setText("3. " + info.getName3());
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    boolean isEntering = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);

                    if(isEntering)
                        Toast.makeText(context,  info.getName3() + "에 접근중입니다..", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(context, info.getName3() + "에서 벗어납니다..", Toast.LENGTH_LONG).show();
                }
            };
            IntentFilter filter = new IntentFilter("kr.ac.koreatech.msp.locationAlert");
            registerReceiver(receiver, filter);

            Intent intent = new Intent("kr.ac.koreatech.msp.locationAlert");
            proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            try {
                locManager.addProximityAlert(info.getLatitude3(), info.getLongitude3(), info.getRadius3(), -1, proximityIntent);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            isAlertRegistered = true;
        }
        requestRuntimePermission();
    }

    //*******************************************************************
    // Runtime permission check
    //*******************************************************************

    private void requestRuntimePermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this,
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

    public void onClickAdd(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void onClickRemove(View view) {
        Intent intent = new Intent(this, RemoveActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLocationChanged(Location location) {}

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

}
