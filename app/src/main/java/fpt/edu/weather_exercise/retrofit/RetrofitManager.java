package fpt.edu.weather_exercise.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static final String ACCUWEATHER_DOMAIN = "http://dataservice.accuweather.com/";
    public static final String APIKEY = "fj73fGSwFqLC5L7XA7cKOc44Q4E1kwAw";

    private static Retrofit weatherRetrofitInstance;

    private static Retrofit getRetrofitInstance(String domain) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            return new Retrofit.Builder()
                    .baseUrl(domain)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    public static Retrofit getWeatherRetrofitInstance() {
        if (weatherRetrofitInstance == null) {
            weatherRetrofitInstance = getRetrofitInstance(ACCUWEATHER_DOMAIN);
        }
        return weatherRetrofitInstance;
    }
}
