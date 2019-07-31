package com.example.tippecanoe_county_sheriff_app;

/* File name : DataItem.java
 * Description : save Button's data
 *
 * Maybe need to add a module to manage data (evolving later)
 * */

import android.content.ComponentName;
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
                new ButtonItem("Admin",R.drawable.admin, null,null , ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Phone Directory",R.drawable.phone_directory,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/Directory.aspx?did=43")),null ,ButtonType.SINGLEFUNC, null),                      //Phone Directory Link
                        new ButtonItem("Admin Line",R.drawable.adminline,new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7654239388")),null , ButtonType.SINGLEFUNC, null),
                        new ButtonItem("Job Apply",R.drawable.employment,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/470/Employment")),null ,ButtonType.SINGLEFUNC,null),                                //Employment Link
                }),
                new ButtonItem("Sex Offender",R.drawable.sex_offender,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icrimewatch.net/index.php?AgencyID=54758")),null , ButtonType.SINGLEFUNC, null),                       //Sex Offender Registry Link
                new ButtonItem("Corrections",R.drawable.corrections, null,null , ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Inmate Lookup",R.drawable.inmate_lookup,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www3.tippecanoe.in.gov/InmateListing/InmateSearch.aspx")), null ,ButtonType.SINGLEFUNC, null),      //Inmate Lookup Link
                        //new ButtonItem(null,R.drawable.web_based_vendor,null,null , true, null),                                                                          //I don't get it
                        new ButtonItem("Commissary",R.drawable.commissary,new Intent(Intent.ACTION_VIEW, Uri.parse("https://deposits.jailatm.com/webdeposits/default.aspx")),null ,ButtonType.SINGLEFUNC, null),               //Jun:
                        new ButtonItem("Video Visitation",R.drawable.video_visitation, new Intent(Intent.ACTION_MAIN), new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=air.com.renovo.vismobile")) ,ButtonType.DOUBLEFUNC, null),                             //Video Visitation Link
                        new ButtonItem("Visitation Policy",R.drawable.corrections,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/468/Inmate-Visitation-Policy")),null ,ButtonType.SINGLEFUNC, null),
                        //new ButtonItem(null,R.drawable.bond_statements,null,null ,true, null),
                }),
                new ButtonItem("We-Tip",R.drawable.we_tip,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), null ,ButtonType.SINGLEFUNC, null),                                                                           //Another Page
                new ButtonItem("Contact",R.drawable.contact,null, null ,ButtonType.POPUPCONTAINER, new ButtonItem[]{
                        new ButtonItem("Administration",30,new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7654239388")),null , ButtonType.SINGLEFUNC, null),
                        new ButtonItem("Dispatch",30,new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7654239321")),null , ButtonType.SINGLEFUNC, null),
                        new ButtonItem("Jail",30,new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7654231655")),null ,ButtonType.SINGLEFUNC, null),
                }),
                new ButtonItem("Services",R.drawable.services,null, null ,ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Sheriff's Sale",R.drawable.sheriffs_sale,null, null ,ButtonType.POPUPCONTAINER, new ButtonItem[]{
                                new ButtonItem("Sheriff's Sale GuideLine",25,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/DocumentCenter/View/740/Sheriff-Sale-Guidelines-PDF?bidId=")),null,ButtonType.SINGLEFUNC,null),
                                new ButtonItem("Sheriff's Sale Listing",25,new Intent(Intent.ACTION_VIEW, Uri.parse("https://legacy.sri-taxsale.com/Foreclosure/PropertyListing.aspx?county=Tippecanoe")),null,ButtonType.SINGLEFUNC,null),
                        }),                       //Sheriff-Sales Link
                        new ButtonItem("Gun Permissions",R.drawable.gun_permits,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/477/Firearm-Permits")), null ,ButtonType.SINGLEFUNC, null),                      //Firearm-Permits Link
                        new ButtonItem("Crash Reports",R.drawable.crash_reports,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/486/Crash-Reports")), null ,ButtonType.SINGLEFUNC, null),                        //Crash-Reports Link
                        new ButtonItem("Records Request",R.drawable.records_request,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/524/Public-Record-Requests")), null ,ButtonType.SINGLEFUNC, null),               //Public-Record-Requests Link
                        new ButtonItem("Animal Control",R.drawable.animal_control,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/473/Animal-Control")), null ,ButtonType.SINGLEFUNC, null),                       //Animal-Control Link
                        new ButtonItem("Security and Extra Patrol Request",R.drawable.security_requests,null, null ,ButtonType.POPUPCONTAINER, new ButtonItem[]{
                                new ButtonItem("Security Request",30, new Intent(context,Email.class),null,ButtonType.NEWPAGE,null),
                                new ButtonItem("Extra Patrol Request",30, new Intent(context,Email.class),null,ButtonType.NEWPAGE,null),
                        }),
                        new ButtonItem("Tax Warrants",R.drawable.tax_warrants,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/480/Tax-Warrants")), null ,ButtonType.SINGLEFUNC, null),                          //Tax-Warrants Link
                }),
                new ButtonItem("Social Media",R.drawable.social_media,null, null ,ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Facebook",R.drawable.icofacebook,new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/660280407355488")), new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/TCSOIndiana/")) ,ButtonType.DOUBLEFUNC, null),                             //Facebook Link
                        new ButtonItem("Twitter",R.drawable.icotwitter,new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=tippecanoecoin")), new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/tippecanoecosh1")),ButtonType.DOUBLEFUNC, null),                               //Twitter Link
                        new ButtonItem("Instagram",R.drawable.icoinstagram,new Intent(Intent.ACTION_VIEW,Uri.parse("http://instagram.com/_u/tcso79")), new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/tcso79/")),ButtonType.DOUBLEFUNC, null),                                   //Instagram Link
                        // need app link or other ways 2 open app
                }),
                new ButtonItem("Enforcement",R.drawable.enforcement,null, null ,ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Traffic Complaints",R.drawable.traffic_complaints,new Intent(context,Email.class),null , ButtonType.NEWPAGE, null),
                }),
                new ButtonItem(null,R.drawable.others,null,null ,ButtonType.CONTAINER, null),
        };

    }
    public ButtonItem[] getData(){
        return data;
    }
    public int getLength(){ return data.length; }



}