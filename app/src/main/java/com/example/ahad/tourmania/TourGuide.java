package com.example.ahad.tourmania;

class TourGuide {

    /**
     * Constant value that represents no image was provided for this Tourguide
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Place Name for the TourGuide
     */
    private String mPlaceName;
    /**
     * Location Name for the TourGuide
     */
    private String mLocationName;
    /**
     * Description of the place for the TourGuide
     */
    private String mDescription;
    /**
     * Timings of the place for the TourGuide
     */
    private String mTimings;
    /**
     * Image resource ID for the TourGuide
     */
    private int mImageResourceId;


    // Public constructor
    public TourGuide(String mPlaceName, String mLocationName, String mDescription, String mTimings, int mImageResourceId) {
        this.mPlaceName = mPlaceName;
        this.mLocationName = mLocationName;
        this.mDescription = mDescription;
        this.mTimings = mTimings;
        this.mImageResourceId = mImageResourceId;
    }

    // Getters Methods
    public String getmPlaceName() {
        return mPlaceName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmTimings() {
        return mTimings;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmLocationName() {
        return mLocationName;
    }
}
