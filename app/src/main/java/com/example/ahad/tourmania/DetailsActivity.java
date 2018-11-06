package com.example.ahad.tourmania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Finding all the views in the layout file
        TextView placeName = findViewById(R.id.tv_place_name_details);
        TextView location = findViewById(R.id.tv_location_detail);
        TextView timings = findViewById(R.id.tv_timings_details);
        TextView desciption = findViewById(R.id.tv_details);
        ImageView imageViewDetails = findViewById(R.id.imageViewDetail);


        // getting the intent object
        Bundle bundle = getIntent().getExtras();

// extracting the attributes values
        String detailsPlaceName = bundle.getString("clickedPlaceName");
        String detailsLocationName = bundle.getString("ClickedLocationImage");
        String detailsTimings = bundle.getString("clickedTimings");
        String detailsDescription = bundle.getString("clickedDescriptionName");
        int detailsImage = bundle.getInt("clickedTourGuideImage");

        // Setting up the textViews and Imagesview with the corresponding tourguide object attribute.
        placeName.setText(detailsPlaceName);
        location.setText(detailsLocationName);
        timings.setText(detailsTimings);
        desciption.setText(detailsDescription);

        imageViewDetails.setImageResource(detailsImage);
    }
}
