package com.example.ahad.tourmania;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragments_list, container, false);

        // Creating ArrayList
        final ArrayList<TourGuide> tourGuide = new ArrayList<>();
        tourGuide.add(new TourGuide(getString(R.string.tv_dilli_haat_place), getString(R.string.tv_dilli_haat_loc), getString(R.string.tv_dilli_haat_desc), getString(R.string.tv_dilli_haat_time), R.drawable.dilli_haat));
        tourGuide.add(new TourGuide(getString(R.string.tv_janpath_place), getString(R.string.tv_janpath_loc), getString(R.string.tv_janpath_desc), getString(R.string.tv_janpath_time), R.drawable.janpath_market));
        tourGuide.add(new TourGuide(getString(R.string.tv_khan_mkt_name), getString(R.string.tv_khan_mkt_loc), getString(R.string.khan_mkt_desc), getString(R.string.tv_khan_mkt_time), R.drawable.khan_market));
        tourGuide.add(new TourGuide(getString(R.string.tv_chandi_place), getString(R.string.tv_chandni_loc), getString(R.string.tv_chandni_desc), getString(R.string.tv_chandni_time), R.drawable.chandni_chowk_mkt));
        tourGuide.add(new TourGuide(getString(R.string.tv_saroj_name), getString(R.string.tv_saroj_loc), getString(R.string.tv_saroj_desc), getString(R.string.tv_saroj_time), R.drawable.sarojini));
        tourGuide.add(new TourGuide(getString(R.string.tv_karol_name), getString(R.string.tv_karol_loc), getString(R.string.tv_karol_desc), getString(R.string.tv_karol_time), R.drawable.karol_bagh));

// Create an {@link TourGuideAdapter}, whose data source is a list of {@link tourGuide}s. The
        // adapter knows how to create list items for each item in the list.
        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuide);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link TourGuideAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link TourGuide} in the list.
        listView.setAdapter(adapter);
        // Set a click listener to open the details activity when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                // Get the {@link TourGuide} object attributes at the given position the user clicked on
                String placeNameClicked = tourGuide.get(position).getmPlaceName();
                // Get the {@link TourGuide} object attributes at the given position the user clicked on
                String locationNameClicked = tourGuide.get(position).getmLocationName();
                // Get the {@link TourGuide} object attributes at the given position the user clicked on
                String timingsClicked = tourGuide.get(position).getmTimings();
                // Get the {@link TourGuide} object attributes at the given position the user clicked on
                String descriptionNameClicked = tourGuide.get(position).getmDescription();
                // Get the {@link TourGuide} object attributes at the given position the user clicked on
                int tourGuideImageClicked = tourGuide.get(position).getmImageResourceId();

                // Creating the explicit intent so that when any item in the list is clicked, It will open the Details Activity
                Intent detailsActivityIntent = new Intent(getActivity(), DetailsActivity.class);
                // putting the TourGuide attribute so that can be recovered in the Details activity
                detailsActivityIntent.putExtra("clickedPlaceName", placeNameClicked);
                detailsActivityIntent.putExtra("ClickedLocationImage", locationNameClicked);
                detailsActivityIntent.putExtra("clickedTimings", timingsClicked);
                detailsActivityIntent.putExtra("clickedDescriptionName", descriptionNameClicked);
                detailsActivityIntent.putExtra("clickedTourGuideImage", tourGuideImageClicked);
                startActivity(detailsActivityIntent);
            }

        });
        return rootView;
    }
}
