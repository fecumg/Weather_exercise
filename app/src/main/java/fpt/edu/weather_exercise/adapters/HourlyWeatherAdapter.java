package fpt.edu.weather_exercise.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fpt.edu.weather_exercise.R;
import fpt.edu.weather_exercise.models.HourlyWeather;
import fpt.edu.weather_exercise.utilities.DateTimeUtils;

public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.ItemHolder> {

    private static final String TEMPERATURE_SUFFIX = "\u00B0";

    private Activity activity;
    private List<HourlyWeather> hourlyWeatherList;

    public HourlyWeatherAdapter(Activity activity, List<HourlyWeather> hourlyWeatherList) {
        this.activity = activity;
        this.hourlyWeatherList = hourlyWeatherList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = activity.getLayoutInflater().inflate(R.layout.item_weather_hourly, parent, false);
        return new ItemHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        HourlyWeather hourlyWeather = hourlyWeatherList.get(position);

        holder.textViewHour.setText(DateTimeUtils.epochToHour(hourlyWeather.getEpochDateTime()));

        if (hourlyWeather.isHasPrecipitation()) {
            holder.textViewPrecipitation.setText(hourlyWeather.getPrecipitationProbability());
        } else {
            holder.textViewPrecipitation.setText("");
        }

        Glide.with(holder.imageViewWeatherIcon)
                .load("https://developer.accuweather.com/sites/default/files/" + formatIconName(hourlyWeather.getWeatherIcon()) + "-s.png")
                .into(holder.imageViewWeatherIcon);

        holder.textViewTemperature.setText(hourlyWeather.getTemperature().getValue() + TEMPERATURE_SUFFIX);
    }

    @Override
    public int getItemCount() {

        return hourlyWeatherList == null ? 0 : hourlyWeatherList.size();
    }

    public void regenerateView(List<HourlyWeather> hourlyWeatherList) {
        this.hourlyWeatherList = hourlyWeatherList;
        notifyDataSetChanged();
    }

    private String formatIconName(int icon) {
        DecimalFormat formatter = new DecimalFormat("00");
        return formatter.format(icon);
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView textViewHour;
        TextView textViewPrecipitation;
        ImageView imageViewWeatherIcon;
        TextView textViewTemperature;


        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            textViewHour = itemView.findViewById(R.id.textViewHour);
            textViewPrecipitation = itemView.findViewById(R.id.textViewPrecipitation);
            imageViewWeatherIcon = itemView.findViewById(R.id.imageViewWeatherIcon);
            textViewTemperature = itemView.findViewById(R.id.textViewTemperature);
        }
    }
}
