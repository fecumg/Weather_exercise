package fpt.edu.weather_exercise.retrofit;


import fpt.edu.weather_exercise.services.WeatherService;

public class RetrofitServiceManager {

    public static WeatherService getWeatherService() {
        return RetrofitManager
                .getWeatherRetrofitInstance()
                .create(WeatherService.class);
    }
}
