package com.example.tippecanoe_county_sheriff_app.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tippecanoe_county_sheriff_app.main.MainActivity;
import com.example.tippecanoe_county_sheriff_app.R;

import org.json.JSONException;
import org.json.JSONObject;
import java.text.DateFormat;
import java.util.Locale;

import static android.util.Log.d;


//need to fix
public class WeatherAPI{
    MainActivity activity;      //danger
    private Typeface weatherFont;
    private String city;  //city method (city name, country)
    private String OPEN_WEATHER_MAP_API;  //API key

    private TextView cityField, currentTemperatureField, weatherIcon;

    //Constructor
    public WeatherAPI(MainActivity activity) {
        this.activity = activity;
        city = "47906,us";
        OPEN_WEATHER_MAP_API = activity.getResources().getString(R.string.weatherAPIKey);


        cityField = activity.findViewById(R.id.city_field); //city
        currentTemperatureField =  activity.findViewById(R.id.current_temperature_field); //temporature
        weatherIcon = activity.findViewById(R.id.weather_icon); //Weather Icon
        weatherFont = Typeface.createFromAsset(activity.getAssets(), "fonts/weathericons-regular-webfont.ttf");
        weatherIcon.setTypeface(weatherFont);

        taskLoadUp(city);

        /* comment cause not used
        *  This is Views can used by api
        * */
        //selectCity = (TextView) findViewById(R.id.selectCity); //select city (can be not available)
        //humidity_field = (TextView) findViewById(R.id.humidity_field); //not used
        // pressure_field = (TextView) findViewById(R.id.pressure_field); //not used
        //updatedField = (TextView) findViewById(R.id.updated_field);
        //detailsField = (TextView) findViewById(R.id.details_field);
    }

    private void taskLoadUp(String query) {
        if (WeatherFunction.isNetworkAvailable(activity.getApplicationContext())) {
            DownloadWeather task = new DownloadWeather();
            task.execute(query);
        } else {
            Toast.makeText(activity.getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    private class DownloadWeather extends AsyncTask < String, Void, String > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //need to check networking
        //if dont, then no internet ... stop :(
        //checked in android version 5.1
        protected String doInBackground(String...args) {
            String xml = WeatherFunction.excuteGet("http://api.openweathermap.org/data/2.5/weather?zip=" + args[0] +
                    "&appid=" + OPEN_WEATHER_MAP_API);
            return xml;
        }

        @Override
        protected void onPostExecute(String xml) {
            try {
                JSONObject json = new JSONObject(xml);
                if (json != null) {
                    JSONObject details = json.getJSONArray("weather").getJSONObject(0);
                    JSONObject main = json.getJSONObject("main");
                    DateFormat df = DateFormat.getDateTimeInstance();

                    cityField.setText(json.getString("name").toUpperCase(Locale.US) + ", " + json.getJSONObject("sys").getString("country"));
                    //detailsField.setText(details.getString("description").toUpperCase(Locale.US));
                    currentTemperatureField.setText(String.format("%.1f", main.getDouble("temp")*0.1*1.8+32) + "°F");
                    //humidity_field.setText("Humidity: " + main.getString("humidity") + "%");
                    //pressure_field.setText("Pressure: " + main.getString("pressure") + " hPa");
                    //updatedField.setText(df.format(new Date(json.getLong("dt") * 1000)));
                    weatherIcon.setText(Html.fromHtml(WeatherFunction.setWeatherIcon(details.getInt("id"),
                            json.getJSONObject("sys").getLong("sunrise") * 1000,
                            json.getJSONObject("sys").getLong("sunset") * 1000)));

                    //loader.setVisibility(View.GONE);

                }
            } catch (JSONException e) {
                d("Error Message", e.toString());
                Toast.makeText(activity.getApplicationContext(), "Error, Check City", Toast.LENGTH_SHORT).show();
            }

        }
    }
}




/* selectCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Change City");
                final EditText input = new EditText(MainActivity.this);
                input.setText(city);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("Change",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                city = input.getText().toString();
                                taskLoadUp(city);
                            }
                        });
                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alertDialog.show();
            }
        });*/

