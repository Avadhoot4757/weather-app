package org.example.weather_app.Model;

public class WeatherReceiver {
    private double latitude;
    private double longitude;
    private double elevation;
    private String timezone;
    private String timezoneAbbreviation;
    private CurrentUnits currentUnits;
    private CurrentWeather current;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public CurrentUnits getCurrentUnits() {
        return currentUnits;
    }

    public void setCurrentUnits(CurrentUnits currentUnits) {
        this.currentUnits = currentUnits;
    }

    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "WeatherReceiver{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", elevation=" + elevation +
                ", timezone='" + timezone + '\'' +
                ", timezoneAbbreviation='" + timezoneAbbreviation + '\'' +
                ", current=" + current +
                '}';
    }

    public static class CurrentUnits {
        private String time;
        private String interval;
        private String temperature_2m;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getInterval() {
            return interval;
        }

        public void setInterval(String interval) {
            this.interval = interval;
        }

        public String getTemperature_2m() {
            return temperature_2m;
        }

        public void setTemperature_2m(String temperature_2m) {
            this.temperature_2m = temperature_2m;
        }

        @Override
        public String toString() {
            return "CurrentUnits{" +
                    "time='" + time + '\'' +
                    ", interval='" + interval + '\'' +
                    ", temperature_2m='" + temperature_2m + '\'' +
                    '}';
        }
    }

    public static class CurrentWeather {
        private String time;
        private int interval;
        private double temperature_2m;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getInterval() {
            return interval;
        }

        public void setInterval(int interval) {
            this.interval = interval;
        }

        public double getTemperature_2m() {
            return temperature_2m;
        }

        public void setTemperature_2m(double temperature_2m) {
            this.temperature_2m = temperature_2m;
        }

        @Override
        public String toString() {
            return "CurrentWeather{" +
                    "time='" + time + '\'' +
                    ", interval=" + interval +
                    ", temperature_2m=" + temperature_2m +
                    '}';
        }
    }
}
