package fpt.edu.weather_exercise.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HourlyWeather implements Serializable {
    @SerializedName("DateTime")
    private String dateTime;

    @SerializedName("EpochDateTime")
    private String epochDateTime;

    @SerializedName("WeatherIcon")
    private int weatherIcon;

    @SerializedName("IconPhrase")
    private String iconPhrase;

    @SerializedName("HasPrecipitation")
    private boolean hasPrecipitation;

    @SerializedName("IsDaylight")
    private boolean isDaylight;

    @SerializedName("Temperature")
    private Temperature temperature;

    @SerializedName("PrecipitationProbability")
    private int precipitationProbability;

    @SerializedName("MobileLink")
    private String mobileLink;

    @SerializedName("Link")
    private String link;

    public HourlyWeather(String dateTime, String epochDateTime, int weatherIcon, String iconPhrase, boolean hasPrecipitation, boolean isDaylight, Temperature temperature, int precipitationProbability, String mobileLink, String link) {
        this.dateTime = dateTime;
        this.epochDateTime = epochDateTime;
        this.weatherIcon = weatherIcon;
        this.iconPhrase = iconPhrase;
        this.hasPrecipitation = hasPrecipitation;
        this.isDaylight = isDaylight;
        this.temperature = temperature;
        this.precipitationProbability = precipitationProbability;
        this.mobileLink = mobileLink;
        this.link = link;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getEpochDateTime() {
        return epochDateTime;
    }

    public void setEpochDateTime(String epochDateTime) {
        this.epochDateTime = epochDateTime;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public boolean isDaylight() {
        return isDaylight;
    }

    public void setDaylight(boolean daylight) {
        isDaylight = daylight;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public int getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public class Temperature {
        @SerializedName("Value")
        private int value;

        @SerializedName("Unit")
        private String unit;

        @SerializedName("UnitType")
        private int unitType;

        public Temperature(int value, String unit, int unitType) {
            this.value = value;
            this.unit = unit;
            this.unitType = unitType;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getUnitType() {
            return unitType;
        }

        public void setUnitType(int unitType) {
            this.unitType = unitType;
        }
    }
}
