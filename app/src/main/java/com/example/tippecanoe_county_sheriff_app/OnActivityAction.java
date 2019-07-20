package com.example.tippecanoe_county_sheriff_app;

/* File name : OnActivityAction.java
 * Description : MainActivity's listener interface
 * */
public interface OnActivityAction {

    /* Buttons of menu has to give function to MainActivity
    * In that case buttons' listener call getSubMenu("menu") and change the menu
    * */
    void getSubMenu (String menu);
}
