package Models;

import com.google.gson.annotations.SerializedName;


public class Coord {
@SerializedName("lon")
private double longitude;
@SerializedName("lat")
private double latitude;

    public Coord(double longitude, double latitude) {
        setLongitude(longitude);
        setLatitude(latitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
