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
public class EatingOutFragment extends Fragment {


    public EatingOutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragments_list, container, false);

        // Creating ArrayList
        final ArrayList<TourGuide> tourGuide = new ArrayList<>();
        tourGuide.add(new TourGuide(getString(R.string.tv_chacha_food_name), getString(R.string.tv_chacha_food_loc), getString(R.string.tv_chacha_food_desc), getString(R.string.tv_chacha_food_time), R.drawable.kamla_food));
        tourGuide.add(new TourGuide(getString(R.string.tv_juneja_name), getString(R.string.tv_juneja_loc), getString(R.string.tv_juneja_desc), getString(R.string.tv_juneja_time), R.drawable.juneja));
        tourGuide.add(new TourGuide(getString(R.string.tv_paan_name), getString(R.string.tv_paan_loc), getString(R.string.tv_paan_desc), getString(R.string.tv_paan_time), R.drawable.paan));
        tourGuide.add(new TourGuide(getString(R.string.tv_atul_name), getString(R.string.tv_atul_loc), getString(R.string.tv_atul_desc), getString(R.string.tv_atul_time), R.drawable.atul_chaat));
        tourGuide.add(new TourGuide(getString(R.string.tv_kulfi_name), getString(R.string.tv_kulfi_loc), getString(R.string.tv_kulfi_desc), getString(R.string.tv_kulfi_time), R.drawable.kulfi));

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
