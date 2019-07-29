package com.example.tippecanoe_county_sheriff_app;

/* File name : DataItem.java
 * Description : save Button's data
 *
 * Maybe need to add a module to manage data (evolving later)
 * */

import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

public class DataItem {
    private ButtonItem[] data;

    DataItem(){
        data = null;
    }

    public void setData(ButtonItem[] data) {
        this.data = data;
    }

    public ArrayList<ButtonItem> getData(String key){
        if(key == null){
            return null;
        }
        switch(key){
            case "Main":
                return getMainData();
            case "Admin":
                return getSubMenu_Admin();
            case "Corrections":
                return getSubMenu_Corrections();
            case "Services":
                return getSubMenu_Services();
            case "SocialMedia":
                return getSubMenu_SocialMedia();
            case "Enforcement":
                return getSubMenu_Enforcement();
            case "Others":
                return getSubMenu_Others();
            case "Sample":
                return getSubMenu_Sample();
            default:
                return null;
        }

    }

    //main menu data
    public ArrayList<ButtonItem> getMainData(){
        data = new ButtonItem[]{
                new ButtonItem(null,R.drawable.admin,null, true, "Admin"),
                new ButtonItem(null,R.drawable.sex_offender,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icrimewatch.net/index.php?AgencyID=54758")), false, null),
                new ButtonItem(null,R.drawable.corrections,null, true, "Corrections"),
                new ButtonItem(null,R.drawable.we_tip,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                new ButtonItem(null,R.drawable.contact,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/359/Sheriffs-Department")), false, null),
                new ButtonItem(null,R.drawable.services,null, true, "Services"),
                new ButtonItem(null,R.drawable.social_media,null, true, "SocialMedia"),
                new ButtonItem(null,R.drawable.alphazero,null, true, "Enforcement"),
                new ButtonItem(null,R.drawable.others,null, true, "Others"),
        };
        return arrayToList(data);
    }

    //Admin sub menu data
    public ArrayList<ButtonItem> getSubMenu_Admin(){
        data = new ButtonItem[]{
                new ButtonItem(null,R.drawable.phone_directory,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/Directory.aspx?did=43")), false, null),                      //Phone Directory Link
                //Jun:
                //Maybe we can make a new Page
                new ButtonItem(null,R.drawable.adminline,null, true, null),                                                                               //I don't get it
                //new ButtonItem(R.drawable.press_releases,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/482/News-Releases")), false, null),                          //Press Releases Link
                //There is no webpage
                new ButtonItem(null,R.drawable.employment,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/470/Employment")),false,null)                                //Employment Link
        };
        return arrayToList(data);
    }

    //Corrections sub menu data
    public ArrayList<ButtonItem> getSubMenu_Corrections(){
        data = new ButtonItem[]{
                new ButtonItem(null,R.drawable.inmate_lookup,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www3.tippecanoe.in.gov/InmateListing/InmateSearch.aspx")), false, null),      //Inmate Lookup Link
                new ButtonItem(null,R.drawable.web_based_vendor,null, true, null),                                                                          //I don't get it
                new ButtonItem(null,R.drawable.commissary,new Intent(Intent.ACTION_VIEW, Uri.parse("https://deposits.jailatm.com/webdeposits/default.aspx")),false, null),               //Jun:
                //this is more familiar
                //then a Web Based Vendor
                new ButtonItem(null,R.drawable.video_visitation,new Intent(Intent.ACTION_VIEW, Uri.parse("https://tippecanoein.gtlvisitme.com/app")),false, null),                             //Video Visitation Link
                new ButtonItem(null,R.drawable.bond_statements,null,true, null),                                                                  //I don't get it
        };
        return arrayToList(data);
    }

    //Services sub menu data
    public ArrayList<ButtonItem> getSubMenu_Services(){
        data = new ButtonItem[]{
                new ButtonItem(null,R.drawable.sheriffs_sale,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/479/Sheriff-Sales")), false, null),                       //Sheriff-Sales Link
                new ButtonItem(null,R.drawable.gun_permits,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/477/Firearm-Permits")), false, null),                      //Firearm-Permits Link
                new ButtonItem(null,R.drawable.crash_reports,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/486/Crash-Reports")), false, null),                        //Crash-Reports Link
                new ButtonItem(null,R.drawable.records_request,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/524/Public-Record-Requests")), false, null),               //Public-Record-Requests Link
                new ButtonItem(null,R.drawable.animal_control,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/473/Animal-Control")), false, null),                       //Animal-Control Link
                new ButtonItem(null,R.drawable.security_requests,null, true, null),
                new ButtonItem(null,R.drawable.tax_warrants,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/480/Tax-Warrants")), false, null),                         //Tax-Warrants Link
        };
        return arrayToList(data);
    }

    //Social Media sub menu data
    public ArrayList<ButtonItem> getSubMenu_SocialMedia(){
        data = new ButtonItem[]{
                new ButtonItem(null,R.drawable.icofacebook,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/TCSOIndiana/")), false, null),                             //Facebook Link
                new ButtonItem(null,R.drawable.icotwitter,new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/tippecanoecosh1")), false, null),                               //Twitter Link
                new ButtonItem(null,R.drawable.icoinstagram,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/tcso79/")), false, null),                                 //Instagram Link
        };
        return arrayToList(data);
    }

    //Enforcement sub menu data
    public ArrayList<ButtonItem> getSubMenu_Enforcement(){
        data = new ButtonItem[]{
                //new ButtonItem(R.drawable.we_tip,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                new ButtonItem(null,R.drawable.traffic_complaints,null, true, null),
        };
        return arrayToList(data);
    }

    public ArrayList<ButtonItem> getSubMenu_Others(){
        data = new ButtonItem[]{
                new ButtonItem(null,R.drawable.others,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                new ButtonItem(null,R.drawable.others,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                new ButtonItem(null,R.drawable.others,null, true, "Sample"),
        };
        return arrayToList(data);
    }

    public ArrayList<ButtonItem> getSubMenu_Sample(){
        data = new ButtonItem[]{
                new ButtonItem(null,R.drawable.enforcement,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                new ButtonItem(null,R.drawable.enforcement,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                new ButtonItem(null,R.drawable.enforcement,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                new ButtonItem(null,R.drawable.enforcement,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                new ButtonItem(null,R.drawable.enforcement,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
        };
        return arrayToList(data);
    }

    public ButtonItem getDataAt(int position){
        return data[position];
    }
    public ButtonItem[] getAllData(){
        return data;
    }
    public int getLength(){ return data.length; }
    public ArrayList<ButtonItem> arrayToList(ButtonItem[] data){
        ArrayList<ButtonItem> listData = new ArrayList<>();
        int index;
        for(ButtonItem tempButton : data){
            if(tempButton != null){
                listData.add(tempButton);
            }
        }
        return listData;
    }
}