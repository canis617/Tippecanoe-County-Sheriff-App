package com.example.tippecanoe_county_sheriff_app;

/* File name : DataItem.java
 * Description : save Button's data
 *
 * Maybe need to add a module to manage data (evolving later)
 * */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;


public class DataItem{
    ButtonItem[] data;

    /*
           We need: change Images;
           make new data structure of our buttons
           #object_item.java
     */

    DataItem(Context context){

        data = new ButtonItem[]{
                new ButtonItem(null,R.drawable.admin, null,null , true, new ButtonItem[]{
                        new ButtonItem(null,R.drawable.phone_directory,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/Directory.aspx?did=43")),null ,false, null),                      //Phone Directory Link
                        //Jun:
                        //Maybe we can make a new Page
                        new ButtonItem(null,R.drawable.adminline,null,null , true, null),                                                                               //I don't get it
                        //new ButtonItem(R.drawable.press_releases,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/482/News-Releases")), false, null),                          //Press Releases Link
                        //There is no webpage
                        new ButtonItem(null,R.drawable.employment,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/470/Employment")),null ,false,null)                                //Employment Link
                }),
                new ButtonItem(null,R.drawable.sex_offender,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icrimewatch.net/index.php?AgencyID=54758")),null , false, null),                       //Sex Offender Registry Link
                new ButtonItem(null,R.drawable.corrections, null,null , true, new ButtonItem[]{
                        new ButtonItem(null,R.drawable.inmate_lookup,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www3.tippecanoe.in.gov/InmateListing/InmateSearch.aspx")), null ,false, null),      //Inmate Lookup Link
                        new ButtonItem(null,R.drawable.web_based_vendor,null,null , true, null),                                                                          //I don't get it
                        new ButtonItem(null,R.drawable.commissary,new Intent(Intent.ACTION_VIEW, Uri.parse("https://deposits.jailatm.com/webdeposits/default.aspx")),null ,false, null),               //Jun:
                        //this is more familiar
                        //then a Web Based Vendor
                        new ButtonItem(null,R.drawable.video_visitation,new Intent(Intent.ACTION_VIEW, Uri.parse("https://tippecanoein.gtlvisitme.com/app")),null ,false, null),                             //Video Visitation Link
                        new ButtonItem(null,R.drawable.bond_statements,null,null ,true, null),
                }),
                new ButtonItem(null,R.drawable.we_tip,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), null ,false, null),                                                                           //Another Page
                //Jun:
                //WeTip have this
                //actually need ?
                new ButtonItem(null,R.drawable.contact,null, null ,false, null),                                                                                //Another Page
                new ButtonItem(null,R.drawable.services,null, null ,true, new ButtonItem[]{
                        new ButtonItem(null,R.drawable.sheriffs_sale,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/479/Sheriff-Sales")), null ,false, null),                       //Sheriff-Sales Link
                        new ButtonItem(null,R.drawable.gun_permits,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/477/Firearm-Permits")), null ,false, null),                      //Firearm-Permits Link
                        new ButtonItem(null,R.drawable.crash_reports,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/486/Crash-Reports")), null ,false, null),                        //Crash-Reports Link
                        new ButtonItem(null,R.drawable.records_request,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/524/Public-Record-Requests")), null ,false, null),               //Public-Record-Requests Link
                        new ButtonItem(null,R.drawable.animal_control,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/473/Animal-Control")), null ,false, null),                       //Animal-Control Link
                        new ButtonItem(null,R.drawable.security_requests,null, null ,true, null),
                        new ButtonItem(null,R.drawable.tax_warrants,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/480/Tax-Warrants")), null ,false, null),                          //Tax-Warrants Link
                }),
                new ButtonItem(null,R.drawable.social_media,null, null ,true, new ButtonItem[]{
                        new ButtonItem(null,R.drawable.icofacebook,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/TCSOIndiana/")), null ,false, null),                             //Facebook Link
                        new ButtonItem(null,R.drawable.icotwitter,new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/tippecanoecosh1")), null ,false, null),                               //Twitter Link
                        new ButtonItem(null,R.drawable.icoinstagram,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/tcso79/")), null ,false, null),                                   //Instagram Link
                }),
                new ButtonItem(null,R.drawable.enforcement,null, null ,true, new ButtonItem[]{
                        //new ButtonItem(R.drawable.we_tip,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), false, null),
                        new ButtonItem(null,R.drawable.traffic_complaints,null,null , true, null),
                }),
                new ButtonItem(null,R.drawable.others,null,null ,true, new ButtonItem[]{
                        new ButtonItem(null,0,null,null ,true, new ButtonItem[]{
                                new ButtonItem(null,0,null,null ,false,null),
                                new ButtonItem(null,0,null,null ,true, new ButtonItem[]{
                                        new ButtonItem(null,0,null,null ,false,null),
                                        new ButtonItem(null,0,null,null ,false,null),
                                        new ButtonItem(null,0,null,null ,false,null),
                                }),
                        }),
                }),
        };

    }
    public ButtonItem[] getData(){
        return data;
    }
    public int getLength(){ return data.length; }



}