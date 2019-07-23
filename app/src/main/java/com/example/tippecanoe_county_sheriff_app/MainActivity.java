package com.example.tippecanoe_county_sheriff_app;

/* File name : MainActivity.java
 * Description : Main Activity for app module
 * */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnActivityAction {

    //Fragments where to use menus
    private MenuFramentMain fragmentMain;
    private MenuFragmentAdmin fragmentAdmin;
    private MenuFragmentCorrections fragmentCorrections;
    private MenuFragmentEnforcement fragmentEnforcement;
    private MenuFragmentServices fragmentServices;
    private MenuFragmentSocialMedia fragmentSocialMedia;

    //weather views
    TextView cityField, currentTemperatureField, weatherIcon;
    Typeface weatherFont;
    String city;  //city method (city name, country)
    String OPEN_WEATHER_MAP_API;  //API key

    private WeatherAPI weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        setContentView(R.layout.activity_main);

        city = "Lafayette, usa"; //default city
        OPEN_WEATHER_MAP_API = getString(R.string.weatherAPIKey);

        //initializing menus
        fragmentMain = new MenuFramentMain();
        fragmentAdmin = new MenuFragmentAdmin();
        fragmentCorrections = new MenuFragmentCorrections();
        fragmentEnforcement = new MenuFragmentEnforcement();
        fragmentServices = new MenuFragmentServices();
        fragmentSocialMedia = new MenuFragmentSocialMedia();

        weatherView = new WeatherAPI(this);
        /*init page
        * load all page and hide sub menu
        * when you click the button, just hide and show it
        */
        initMenus();
    }

    /* Listener of MainActivity
    *  MainActivity - Fragment(ViewPager) - PagerAdapter - GridView - ButtonAdapter
    *  to link between ButtonAdapter's onClick Listener and Activity
    * */
    @Override
    public void getSubMenu(String menu){
        if(menu == null){
            Log.d(this.getClass().getName(), "sub menu parameter error");
        }

        Fragment fr;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(menu == "redirection"){                                                                  //when need to get back to the main menu
            hideSubMenu();
            transaction.show(fragmentMain);
        } else {                                                                                    //sub menus
            if(menu == "Admin"){
                fr = fragmentAdmin;
            } else if(menu == "Corrections"){
                fr = fragmentCorrections;
            } else if(menu == "SocialMedia"){
                fr = fragmentSocialMedia;
            } else if(menu == "Services"){
                fr = fragmentServices;
            } else if(menu == "Enforcement"){
                fr = fragmentEnforcement;
            } else {
                Log.d(this.getClass().getName(), "incorrect parameter error redirect to main");
                fr = fragmentMain;
            }

            transaction.hide(fragmentMain);                                                         //Algorithm - hide Main show Sub in V 1.0 (need to evolve)
            transaction.show(fr);
            transaction.addToBackStack(fr.getClass().getSimpleName());
        }
        transaction.commit();
    }

    //hide all sub menus
    public void hideSubMenu(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragmentAdmin);
        transaction.hide(fragmentCorrections);
        transaction.hide(fragmentEnforcement);
        transaction.hide(fragmentServices);
        transaction.hide(fragmentSocialMedia);
        transaction.commit();
    }

    //initializing menus (initial version need to evolve)
    public void initMenus(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer, fragmentMain);
        transaction.add(R.id.fragmentContainer, fragmentAdmin);
        transaction.add(R.id.fragmentContainer, fragmentCorrections);
        transaction.add(R.id.fragmentContainer, fragmentEnforcement);
        transaction.add(R.id.fragmentContainer, fragmentServices);
        transaction.add(R.id.fragmentContainer, fragmentSocialMedia);
        hideSubMenu();
        transaction.commit();
    }

    public void setCityField(TextView cityField) {
        this.cityField = cityField;
    }

    public String getOPEN_WEATHER_MAP_API() {
        return OPEN_WEATHER_MAP_API;
    }

    public void setCurrentTemperatureField(TextView currentTemperatureField) {
        this.currentTemperatureField = currentTemperatureField;
    }

    public void setWeatherIcon(TextView weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public void setWeatherFont(Typeface weatherFont) {
        this.weatherFont = weatherFont;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTypeface(){
        weatherIcon.setTypeface(weatherFont);
    }

    public void setOPEN_WEATHER_MAP_API(String OPEN_WEATHER_MAP_API) {
        this.OPEN_WEATHER_MAP_API = OPEN_WEATHER_MAP_API;
    }

}
