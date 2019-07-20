package com.example.tippecanoe_county_sheriff_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnActivityAction {

    TextView logo;
    ImageView mainImage;

    MenuFramentMain fragmentMain;
    MenuFragmentAdmin fragmentAdmin;
    MenuFragmentCorrections fragmentCorrections;
    MenuFragmentEnforcement fragmentEnforcement;
    MenuFragmentServices fragmentServices;
    MenuFragmentSocialMedia fragmentSocialMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //fixed to portrait view
        setContentView(R.layout.activity_main);

        fragmentMain = new MenuFramentMain();
        fragmentAdmin = new MenuFragmentAdmin();
        fragmentCorrections = new MenuFragmentCorrections();
        fragmentEnforcement = new MenuFragmentEnforcement();
        fragmentServices = new MenuFragmentServices();
        fragmentSocialMedia = new MenuFragmentSocialMedia();

        //init page
        //load all page and hide sub menu
        //when you click the button, just hide and show it
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

    @Override
    public void getSubMenu(String menu){
        if(menu == null){
            Log.d(this.getClass().getName(), "sub menu parameter error");
        }

        Fragment fr;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(menu == "redirection"){
            hideSubMenu();
            transaction.show(fragmentMain);
        } else {
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
            transaction.hide(fragmentMain);
            transaction.show(fr);
            transaction.addToBackStack(fr.getClass().getSimpleName());
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        Log.d(this.getClass().getName(),Integer.toString(getSupportFragmentManager().getBackStackEntryCount()));
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
            getSubMenu("redirection");
        }
    }

    public void hideSubMenu(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragmentAdmin);
        transaction.hide(fragmentCorrections);
        transaction.hide(fragmentEnforcement);
        transaction.hide(fragmentServices);
        transaction.hide(fragmentSocialMedia);
        transaction.commit();
    }
}
