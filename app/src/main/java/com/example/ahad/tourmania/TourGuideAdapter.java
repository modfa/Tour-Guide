package com.example.ahad.tourmania;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class TourGuideAdapter extends ArrayAdapter<TourGuide> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param tourGuide A List of Word objects to display in a list
     */
    public TourGuideAdapter(Activity context, ArrayList<TourGuide> tourGuide) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // Because this is a custom adapter, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, tourGuide);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        // Get the {@link TourGuide} object located at this position in the list
        TourGuide currentTourGuide = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID imageView.
        ImageView imageView = listItemView.findViewById(R.id.imageView);
        // display the provided image based on the resource ID
        imageView.setImageResource(currentTourGuide.getmImageResourceId());
        // Find the TextView in the list_item.xml layout with the ID tv_place_name
        TextView placeTextView = listItemView.findViewById(R.id.tv_place_name);
        // Get the place name from the current TourGuide object and
        // set this text on the  placeTextView
        placeTextView.setText(currentTourGuide.getmPlaceName());

        // Find the TextView in the list_item.xml layout with the ID tv_place_name
        TextView locationTextView = listItemView.findViewById(R.id.tv_location);
        // Get the place name from the current TourGuide object and
        // set this text on the  placeTextView
        locationTextView.setText(currentTourGuide.getmLocationName());

        return listItemView;
    }
}
