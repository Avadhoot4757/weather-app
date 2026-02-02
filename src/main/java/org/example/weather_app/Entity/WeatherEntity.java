package org.example.weather_app.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather_data")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lat", nullable = false)
    private double lat;

    @Column(name = "lon", nullable = false)
    private double lon;

    @Column(name = "min_temp_alert", nullable = false)
    private double min_temp_alert;

    @Column(name = "max_temp_alert", nullable = false)
    private double max_temp_alert;

    @Column(name = "last_known_temp")
    private double last_known_temp;

    @Column(name = "alert", nullable = false)
    private boolean alert;

    @Column(name = "last_updated", nullable = false)
    private String last_updated;

    @Column(name = "favorite" , nullable = true )
    private boolean favorite;

    public WeatherEntity() {}

    public WeatherEntity(Long id, double lat, double lon, double min_temp_alert, double max_temp_alert, double last_known_temp, boolean alert, String last_updated ) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.min_temp_alert = min_temp_alert;
        this.max_temp_alert = max_temp_alert;
        this.last_known_temp = last_known_temp;
        this.alert = alert;
        this.last_updated = last_updated;
        this.favorite = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
