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
            // 근접 경보를 받을 브로드캐스트 리시버 객체 생성 및 등록
            // 액션이 kr.ac.koreatech.msp.locationAlert인 브로드캐스트 메시지를 받도록 설정
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    boolean isEntering = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
                    // boolean getBooleanExtra(String name, boolean defaultValue)

                    if(isEntering)
                        Toast.makeText(context,  info.getName1() + "에 접근중입니다..", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(context, info.getName1() + "에서 벗어납니다..", Toast.LENGTH_LONG).show();
                }
            };
            IntentFilter filter = new IntentFilter("kr.ac.koreatech.msp.locationAlert");
            registerReceiver(receiver, filter);

            // ProximityAlert 등록을 위한 PendingIntent 객체 얻기
            Intent intent = new Intent("kr.ac.koreatech.msp.locationAlert");
            proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            try {
                // 근접 경보 등록 메소드
                // void addProximityAlert(double latitude, double longitude, float radius, long expiration, PendingIntent intent)
                // 아래 위도, 경도 값의 위치는 2공학관 420호 창가 부근
                locManager.addProximityAlert(info.getLatitude1(), info.getLongitude1(), info.getRadius1(), -1, proximityIntent);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            isAlertRegistered = true;
        }

        if(info.getName2() != null) {
            info02.setText("2. " + info.getName2());
            // 근접 경보를 받을 브로드캐스트 리시버 객체 생성 및 등록
            // 액션이 kr.ac.koreatech.msp.locationAlert인 브로드캐스트 메시지를 받도록 설정
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    boolean isEntering = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
                    // boolean getBooleanExtra(String name, boolean defaultValue)

                    if(isEntering)
                        Toast.makeText(context,  info.getName2() + "에 접근중입니다..", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(context, info.getName2() + "에서 벗어납니다..", Toast.LENGTH_LONG).show();
                }
            };
            IntentFilter filter = new IntentFilter("kr.ac.koreatech.msp.locationAlert");
            registerReceiver(receiver, filter);

            // ProximityAlert 등록을 위한 PendingIntent 객체 얻기
            Intent intent = new Intent("kr.ac.koreatech.msp.locationAlert");
            proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            try {
                // 근접 경보 등록 메소드
                // void addProximityAlert(double latitude, double longitude, float radius, long expiration, PendingIntent intent)
                // 아래 위도, 경도 값의 위치는 2공학관 420호 창가 부근
                locManager.addProximityAlert(info.getLatitude2(), info.getLongitude2(), info.getRadius2(), -1, proximityIntent);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            isAlertRegistered = true;
        }

        if(info.getName3() != null) {
            info03.setText("3. " + info.getName3());
            // 근접 경보를 받을 브로드캐스트 리시버 객체 생성 및 등록
            // 액션이 kr.ac.koreatech.msp.locationAlert인 브로드캐스트 메시지를 받도록 설정
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    boolean isEntering = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
                    // boolean getBooleanExtra(String name, boolean defaultValue)
                    if(isEntering)
                        Toast.makeText(context,  info.getName3() + "에 접근중입니다..", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(context, info.getName3() + "에서 벗어납니다..", Toast.LENGTH_LONG).show();
                }
            };
            IntentFilter filter = new IntentFilter("kr.ac.koreatech.msp.locationAlert");
            registerReceiver(receiver, filter);

            // ProximityAlert 등록을 위한 PendingIntent 객체 얻기
            Intent intent = new Intent("kr.ac.koreatech.msp.locationAlert");
            proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            try {
                // 근접 경보 등록 메소드
                // void addProximityAlert(double latitude, double longitude, float radius, long expiration, PendingIntent intent)
                // 아래 위도, 경도 값의 위치는 2공학관 420호 창가 부근
                locManager.addProximityAlert(info.getLatitude3(), info.getLongitude3(), info.getRadius3(), -1, proximityIntent);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            isAlertRegistered = true;
        }

        System.out.println(info.toString());

        requestRuntimePermission();
    }

    private void requestRuntimePermission() {
        //*******************************************************************
        // Runtime permission check
        //*******************************************************************
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }
        } else {
            // ACCESS_FINE_LOCATION 권한이 있는 것
            isPermitted = true;
        }
        //*********************************************************************
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // read_external_storage-related task you need to do.

                    // ACCESS_FINE_LOCATION 권한을 얻음
                    isPermitted = true;

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    // 권한을 얻지 못 하였으므로 location 요청 작업을 수행할 수 없다
                    // 적절히 대처한다
                    isPermitted = false;

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
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
    public void onLocationChanged(Location location) {
//        locationText.setText("위도 : " + location.getLatitude()
//                + " 경도 : " + location.getLongitude());
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

}
