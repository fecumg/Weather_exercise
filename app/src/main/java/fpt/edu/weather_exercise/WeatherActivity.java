package fpt.edu.weather_exercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fpt.edu.weather_exercise.adapters.HourlyWeatherAdapter;
import fpt.edu.weather_exercise.models.HourlyWeather;
import fpt.edu.weather_exercise.retrofit.RetrofitServiceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    List<HourlyWeather> hourlyWeatherList = new ArrayList<>();
    RecyclerView recyclerViewHourlyWeather;
    HourlyWeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        initView();
        getHourlyWeatherList(353412);
    }

    private void getHourlyWeatherList(int locationKey) {
        RetrofitServiceManager.getWeatherService().getHourlyWeatherList(locationKey)
                .enqueue(new Callback<List<HourlyWeather>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<HourlyWeather>> call, @NonNull Response<List<HourlyWeather>> response) {
                        hourlyWeatherList = response.body();
                        Log.d("TAG", "onResponse: " + response.body());
                        adapter.regenerateView(hourlyWeatherList);
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<HourlyWeather>> call, @NonNull Throwable t) {
                        Log.e("TAG", "onFailure: " + t.getMessage(), t);
                    }
                });
    }

    private void initView() {
        recyclerViewHourlyWeather = findViewById((R.id.recyclerViewHourlyWeather));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerViewHourlyWeather.setLayoutManager(layoutManager);

        adapter = new HourlyWeatherAdapter(WeatherActivity.this, hourlyWeatherList);
        recyclerViewHourlyWeather.setAdapter(adapter);
    }


}