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
    private MenuFramentMain fragmentMain,fragmentAdmin,fragmentCorrections,
            fragmentEnforcement,fragmentServices,fragmentSocialMedia, fragmentOthers, fragmentSample;

    //weather views
    TextView cityField, currentTemperatureField, weatherIcon;


    private WeatherAPI weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        setContentView(R.layout.activity_main);

        //weather initializing
        weatherView = new WeatherAPI(this);

        //initializing menus
        fragmentMain = new MenuFramentMain("Main");
        fragmentAdmin = new MenuFramentMain("Admin");
        fragmentCorrections = new MenuFramentMain("Corrections");
        fragmentEnforcement = new MenuFramentMain("Enforcement");
        fragmentServices = new MenuFramentMain("Services");
        fragmentSocialMedia = new MenuFramentMain("SocialMedia");
        fragmentOthers = new MenuFramentMain("Others");
        fragmentSample = new MenuFramentMain("Sample");

        /*init page
        * load all page and hide sub menu
        * when you click the button, just hide and show it
        */
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragmentMain).commit();
        //initMenus();
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

        if(menu.equals("redirection")){
            transaction.replace(R.id.fragmentContainer,fragmentMain);
        } else {//sub menus
            switch(menu){
                case "Admin":
                    fr = fragmentAdmin; break;
                case "Corrections":
                    fr = fragmentCorrections; break;
                case "SocialMedia":
                    fr = fragmentSocialMedia; break;
                case "Services":
                    fr = fragmentServices; break;
                case "Enforcement":
                    fr = fragmentEnforcement; break;
                case "Others":
                    fr = fragmentOthers; break;
                case "Sample":
                    fr = fragmentSample; break;
                    default:
                        Log.d(this.getClass().getName(), "incorrect parameter error redirect to main");
                        fr = fragmentMain;
            }
            /*
            if(menu.equals("Admin")){

            } else if(menu.equals("Corrections")){

            } else if(menu.equals("SocialMedia")){

            } else if(menu.equals("Services")){

            } else if(menu.equals("Enforcement")){

            } else if(menu.equals("Others")){

            } else if(menu.equals("Sample")){

            } else {

            }*/
                                                      //Algorithm - hide Main show Sub in V 1.0 (need to evolve)
            transaction.replace(R.id.fragmentContainer,fr);
            transaction.addToBackStack(fr.getClass().getSimpleName());

        }
        transaction.commit();
    }

}
