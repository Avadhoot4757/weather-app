package org.example.weather_app.Model;

public class WeatherSender {
    private Long id;
    private String cityName;
    private double lat;
    private double lon;
    private double min_temp_alert;
    private double max_temp_alert;
    private double last_known_temp;
    private boolean alert;
    private String last_updated;

    public WeatherSender(Long id, String cityName, double lat, double lon, double min_temp_alert, double max_temp_alert, double last_known_temp, boolean alert, String last_updated) {
        this.id = id;
        this.cityName = cityName;
        this.lat = lat;
        this.lon = lon;
        this.min_temp_alert = min_temp_alert;
        this.max_temp_alert = max_temp_alert;
        this.last_known_temp = last_known_temp;
        this.alert = alert;
        this.last_updated = last_updated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(long id) {
        this.cityName = cityName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getMin_temp_alert() {
        return min_temp_alert;
    }

    public void setMin_temp_alert(double min_temp_alert) {
        this.min_temp_alert = min_temp_alert;
    }

    public double getMax_temp_alert() {
        return max_temp_alert;
    }

    public void setMax_temp_alert(double max_temp_alert) {
        this.max_temp_alert = max_temp_alert;
    }

    public double getLast_known_temp() {
        return last_known_temp;
    }

    public void setLast_known_temp(double last_known_temp) {
        this.last_known_temp = last_known_temp;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
