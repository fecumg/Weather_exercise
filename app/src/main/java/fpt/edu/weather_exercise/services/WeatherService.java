package fpt.edu.weather_exercise.services;

import java.util.List;

import fpt.edu.weather_exercise.models.HourlyWeather;
import fpt.edu.weather_exercise.retrofit.RetrofitManager;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {

    @GET("/forecasts/v1/hourly/12hour/{locationKey}?apikey=" + RetrofitManager.APIKEY)
    Call<List<HourlyWeather>> getHourlyWeatherList(@Path("locationKey") int locationKey);
}
