package com.example.tippecanoe_county_sheriff_app;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.DateFormat;
import java.util.Locale;

import static android.util.Log.d;

public class WeatherAPI{
    MainActivity activity;

    private Typeface weatherFont;
    private String city;  //city method (city name, country)
    private String OPEN_WEATHER_MAP_API;  //API key

    public WeatherAPI(MainActivity activity) {
        this.activity = activity;
        city = "47906,us";
        OPEN_WEATHER_MAP_API = activity.getString(R.string.weatherAPIKey);

        activity.cityField = (TextView) activity.findViewById(R.id.city_field);
        activity.currentTemperatureField = (TextView) activity.findViewById(R.id.current_temperature_field); //temporature
        activity.weatherIcon = (TextView) activity.findViewById(R.id.weather_icon); //Weather Icon
        weatherFont = Typeface.createFromAsset(activity.getAssets(), "fonts/weathericons-regular-webfont.ttf");
        activity.weatherIcon.setTypeface(weatherFont);


        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        float textsize = activity.currentTemperatureField.getTextSize() / displayMetrics.density;
        activity.cityField.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textsize);
        d("jun","tempsize:"+ textsize);
        d("jun","citysize:"+activity.cityField.getTextSize());
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

    public void taskLoadUp(String query) {
        if (WeatherFunction.isNetworkAvailable(activity.getApplicationContext())) {
            DownloadWeather task = new DownloadWeather();
            task.execute(query);
        } else {
            Toast.makeText(activity.getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    class DownloadWeather extends AsyncTask < String, Void, String > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //loader.setVisibility(View.VISIBLE);
        }

        //need to check networking
        // if dont, then no internet ... stop :(
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

                    activity.cityField.setText(json.getString("name").toUpperCase(Locale.US) + ", " + json.getJSONObject("sys").getString("country"));
                    //detailsField.setText(details.getString("description").toUpperCase(Locale.US));
                    activity.currentTemperatureField.setText(String.format("%.1f", main.getDouble("temp")*0.1*1.8+32) + "°F");
                    //humidity_field.setText("Humidity: " + main.getString("humidity") + "%");
                    //pressure_field.setText("Pressure: " + main.getString("pressure") + " hPa");
                    //updatedField.setText(df.format(new Date(json.getLong("dt") * 1000)));
                    activity.weatherIcon.setText(Html.fromHtml(WeatherFunction.setWeatherIcon(details.getInt("id"),
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

