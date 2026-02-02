package org.example.weather_app.Model;

import java.util.List;

public class CityReceiver {

    private List<City> results;
    private double generationtimeMs;

    public List<City> getResults() {
        return results;
    }

    public void setResults(List<City> results) {
        this.results = results;
    }

    public double getGenerationtimeMs() {
        return generationtimeMs;
    }

    public void setGenerationtimeMs(double generationtimeMs) {
        this.generationtimeMs = generationtimeMs;
    }

    public static class City {
        private long id;
        private String name;
        private double latitude;
        private double longitude;
        private int elevation;
        private String featureCode;
        private String countryCode;
        private long admin1Id;
        private long admin3Id;
        private long admin4Id;
        private String timezone;
        private int population;
        private List<String> postcodes;
        private long countryId;
        private String country;
        private String admin1;
        private String admin3;
        private String admin4;

        // Getters and setters
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

        public int getElevation() {
            return elevation;
        }

        public void setElevation(int elevation) {
            this.elevation = elevation;
        }

        public String getFeatureCode() {
            return featureCode;
        }

        public void setFeatureCode(String featureCode) {
            this.featureCode = featureCode;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public long getAdmin1Id() {
            return admin1Id;
        }

        public void setAdmin1Id(long admin1Id) {
            this.admin1Id = admin1Id;
        }

        public long getAdmin3Id() {
            return admin3Id;
        }

        public void setAdmin3Id(long admin3Id) {
            this.admin3Id = admin3Id;
        }

        public long getAdmin4Id() {
            return admin4Id;
        }

        public void setAdmin4Id(long admin4Id) {
            this.admin4Id = admin4Id;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public List<String> getPostcodes() {
            return postcodes;
        }

        public void setPostcodes(List<String> postcodes) {
            this.postcodes = postcodes;
        }

        public long getCountryId() {
            return countryId;
        }

        public void setCountryId(long countryId) {
            this.countryId = countryId;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAdmin1() {
            return admin1;
        }

        public void setAdmin1(String admin1) {
            this.admin1 = admin1;
        }

        public String getAdmin3() {
            return admin3;
        }

        public void setAdmin3(String admin3) {
            this.admin3 = admin3;
        }

        public String getAdmin4() {
            return admin4;
        }

        public void setAdmin4(String admin4) {
            this.admin4 = admin4;
        }

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", elevation=" + elevation +
                    ", featureCode='" + featureCode + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    ", admin1Id=" + admin1Id +
                    ", admin3Id=" + admin3Id +
                    ", admin4Id=" + admin4Id +
                    ", timezone='" + timezone + '\'' +
                    ", population=" + population +
                    ", postcodes=" + postcodes +
                    ", countryId=" + countryId +
                    ", country='" + country + '\'' +
                    ", admin1='" + admin1 + '\'' +
                    ", admin3='" + admin3 + '\'' +
                    ", admin4='" + admin4 + '\'' +
                    '}';
        }
    }
}
