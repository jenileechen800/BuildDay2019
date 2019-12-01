package com.example.testingforbuildday;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

import com.example.testingforbuildday.*;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private boolean start;
    private List<LatLng> ramps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        start = true;
        ramps = new ArrayList<>();
        ramps.add(new LatLng(49.268531, 123.249069)); //Testing with Src
        ramps.add(new LatLng(49.263503, -123.249710)); //Testing with Beaty Biodiversity

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng Home = new LatLng(49.262445,-123.250695);

        if (start) { //Startup procedure
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Home, (float) 14.5));
            start = false;
        }
        else {
            mMap.clear();
            //drawRoute(new LatLng(49.262445,-123.250695), new LatLng(49.262445, -123.249810), mMap);
            Polyline route;
            LatLng ramp = chooseRamp(new LatLng(49.264147, -123.247815),new LatLng(49.262230, -123.250687));
            route = googleMap.addPolyline(new PolylineOptions().clickable(true).add(
                    new LatLng(49.264147, -123.247815),ramp,new LatLng(49.262230, -123.250687))
            );

            googleMap.addMarker(new MarkerOptions().position(new LatLng(49.262230, -123.250687)));
           googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(49.262445, -123.249810), (float) 14.5));

        }

        googleMap.setOnMapClickListener(this); //Change this event listener to something else
    }


    public void onMapClick(LatLng temp) {
        onMapReady(mMap);
    }


//    private void drawRoute(LatLng start, LatLng end, GoogleMap googleMap) {
//        Polyline route;
//        LatLng ramp = chooseRamp(start, end);
//        route = googleMap.addPolyline(new PolylineOptions().clickable(true).add(
//                start,ramp,end)
//        );
//
//    }


    private LatLng chooseRamp(LatLng start, LatLng end) {
        LatLng rampToUse = null;
        double x;
        double y;
        double distance;
        double rampDistance = 0;

        for (LatLng temp : ramps) {
            x = Math.abs(start.latitude - temp.latitude) + Math.abs(temp.latitude - end.latitude);
            y = Math.abs(start.longitude - temp.longitude) + Math.abs(temp.longitude - end.longitude);
            distance = Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2));

            if (rampToUse == null) {
                rampToUse = temp;
                rampDistance = distance;
            }
            else if (rampDistance > distance) {
                rampDistance = distance;
                rampToUse = temp;
            }
        }

        return rampToUse;
    }


    public static void getRoute (LatLng start, LatLng end)throws Exception {
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + start.latitude + "," + start.longitude +
                "&destination=" + end.latitude + "," + end.longitude + "&key=AIzaSyDSo94NpQGUnyQgEwKHx-EwdPMSG2QO53U";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        //System.out.println(response.toString());
        //Read JSON response and print
        String lol = response.toString();
        //JsonObject myResponse = new JSONObject(lol);

        List<String> list = new ArrayList<String>();
       // JSONArray jsonArray = myResponse.getJSONArray("routes");
        //JSONObject legs = jsonArray.getJSONObject(2);
        //JSONArray jsonArray1 = legs.getJSONArray("");
//        for (int i = 0; i < jsonArray.length(); i++) {
//
//        }

        //System.out.println("routes- "+ jsonArray.getString(0));

    }

    public static void main(String[] args) {
        LatLng start = new LatLng(49.264845,-123.255695);
        LatLng stop = new LatLng(49.262445, -123.249810);

        try {
            getRoute(start, stop);
        }
        catch (Exception e) {
            System.out.println("fail");
        }
    }



}
