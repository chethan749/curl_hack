package com.example.android.savaari;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.location.Location.distanceBetween;




/*public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    double latitude = 0.0;
    double longitude = 0.0;

    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return  ;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            latitude = location.getLatitude();
                            Log.e("Latitude", "" + latitude);
                            longitude = location.getLongitude();
                            Log.e("Longitude", "" + longitude);

                            // Logic to handle location object
                        }
                    }
                });

       *//* mMap.addMarker(new MarkerOptions()
                .position(new LatLng(10, 10))
                .title("Hello world"));*//*
    }


    *//**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     *//*
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}*/
public class MapsActivity extends FragmentActivity {
    double latitude = 0.0;
    double longitude = 0.0;
    Button goButton;
    EditText from;
    EditText to;
    String custname="XXX";
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;
    TextView latLongTV;
    String toDisplay = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        latLongTV = (TextView) findViewById(R.id.withText);
        goButton = (Button) findViewById(R.id.button);
        goButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                final TextView display = (TextView) findViewById(R.id.withText);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference customers = database.getReference("Customers");
                customers.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> customerList = dataSnapshot.getChildren();
                        for (DataSnapshot customer : customerList) {
                            Iterable<DataSnapshot> dataFields = customer.getChildren();
                            toDisplay = toDisplay + customer.getKey() + "\n";
                            for (DataSnapshot dataField : dataFields) {
                                if (dataField.getValue() == custname) {
                                    DatabaseReference myReference = customerList.child(custname).child("Ride Requested");

                            }
                        }

                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.e("Main.java","Cancelled");
                });
                }

/*
            @Override
            public void onClick(View view) {
                float results[] = {0};
                String fromAddress = from.getText().toString();
                String toAddress = to.getText().toString();
                Location location = new Location("Bengaluru");
                Location location1 = new Location("Sydney");
                //distanceBetween(72,73,72,74,results);
           //     float dist = location1.distanceTo(location);
            //    latLongTV.setText(dist+"");
                /*GeocodingLocation locationAddress = new GeocodingLocation();
                locationAddress.getAddressFromLocation(fromAddress,
                        getApplicationContext(), new GeocoderHandler());*/

*/
    }
    /*
    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {

            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            latLongTV.setText(locationAddress);
        }
    }*/
}
