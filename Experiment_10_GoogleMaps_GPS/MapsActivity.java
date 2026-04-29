package com.example.googlemapdemo;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// OnMapReadyCallback = interface called when Google Map is ready to use
public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback {

    // GoogleMap object = reference to the actual map
    private GoogleMap mMap;

    Button btnNormal, btnSatellite, btnHybrid, btnTerrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Link buttons
        btnNormal    = findViewById(R.id.btnNormal);
        btnSatellite = findViewById(R.id.btnSatellite);
        btnHybrid    = findViewById(R.id.btnHybrid);
        btnTerrain   = findViewById(R.id.btnTerrain);

        // -------------------------------------------------------
        // Get the SupportMapFragment from layout
        // Then call getMapAsync() → triggers onMapReady() when ready
        // -------------------------------------------------------
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this); // 'this' = MapsActivity implements callback

        // ---- Map Type Buttons ----
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Normal = standard road map
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Satellite = real satellite photo (no labels)
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hybrid = satellite + road labels
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        btnTerrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Terrain = topographic/contour map
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
    }

    // -------------------------------------------------------
    // onMapReady() — Called automatically when map is ready
    // This is where we add markers, set camera, configure map
    // -------------------------------------------------------
    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Store the GoogleMap reference
        mMap = googleMap;

        // -------------------------------------------------------
        // LatLng = Latitude + Longitude coordinates
        // SKNCOE Pune coordinates
        // Latitude = North-South position
        // Longitude = East-West position
        // -------------------------------------------------------
        LatLng skncoe = new LatLng(18.4529, 73.8572); // SKNCOE, Pune

        // -------------------------------------------------------
        // MarkerOptions = configuration for a map pin/marker
        // .position() = where to place marker
        // .title() = text shown when marker is clicked
        // .snippet() = sub-text below title
        // -------------------------------------------------------
        mMap.addMarker(new MarkerOptions()
                .position(skncoe)
                .title("SKNCOE Pune")
                .snippet("Smt. Kashibai Navale College of Engineering"));

        // -------------------------------------------------------
        // moveCamera() = moves map view to location
        // CameraUpdateFactory.newLatLngZoom(location, zoomLevel)
        // Zoom: 1=world, 5=country, 10=city, 15=streets, 20=building
        // -------------------------------------------------------
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(skncoe, 15));

        // Enable zoom controls on map
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Enable compass on map
        mMap.getUiSettings().setCompassEnabled(true);

        // Set initial map type to Normal
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}