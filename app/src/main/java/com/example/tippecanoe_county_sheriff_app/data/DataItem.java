package com.example.tippecanoe_county_sheriff_app.data;

/* File name : DataItem.java
 * Description : save Button's data
 *
 * Maybe need to add a module to manage data (evolving later)
 * */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.tippecanoe_county_sheriff_app.email.Email;
import com.example.tippecanoe_county_sheriff_app.R;


public class DataItem{
    ButtonItem[] data;

    public DataItem(Context context){

        data = new ButtonItem[]{
                new ButtonItem("Admin", R.drawable.new_admin, null,null , ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Phone Directory",R.drawable.new_phone_directory,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/Directory.aspx?did=43")),null ,ButtonType.LINKTOWEB, null),                      //Phone Directory Link
                        new ButtonItem("Admin Line",R.drawable.new_admin_line,new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7654239388")),null , ButtonType.AUTODIAL, null),
                        new ButtonItem("Job Apply",R.drawable.new_job_apply,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/470/Employment")),null ,ButtonType.LINKTOWEB,null),                                //Employment Link
                }),
                new ButtonItem("Sex Offender",R.drawable.new_sex_offenders,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icrimewatch.net/index.php?AgencyID=54758")),null , ButtonType.LINKTOWEB, null),                       //Sex Offender Registry Link
                new ButtonItem("Corrections",R.drawable.corrections, null,null , ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Inmate Lookup",R.drawable.new_inmate_lookup,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www3.tippecanoe.in.gov/InmateListing/InmateSearch.aspx")), null ,ButtonType.LINKTOWEB, null),      //Inmate Lookup Link
                        //new ButtonItem(null,R.drawable.web_based_vendor,null,null , true, null),                                                                          //I don't get it
                        new ButtonItem("Commissary",R.drawable.new_commissary,new Intent(Intent.ACTION_VIEW, Uri.parse("https://deposits.jailatm.com/webdeposits/default.aspx")),null ,ButtonType.LINKTOWEB, null),               //Jun:
                        new ButtonItem("Video Visitation",R.drawable.new_video_visitation, new Intent(Intent.ACTION_MAIN), new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=air.com.renovo.vismobile")) ,ButtonType.LINKTOAPP, null),                             //Video Visitation Link
                        new ButtonItem("Visitation Policy",R.drawable.corrections,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/468/Inmate-Visitation-Policy")),null ,ButtonType.LINKTOWEB, null),
                        //new ButtonItem(null,R.drawable.bond_statements,null,null ,true, null),
                }),
                new ButtonItem("We-Tip",R.drawable.new_we_tip,new Intent(Intent.ACTION_VIEW, Uri.parse("https://wetip.com/")), null ,ButtonType.LINKTOWEB, null),                                                                           //Another Page
                new ButtonItem("Contact",R.drawable.new_contacts,null, null ,ButtonType.POPUPCONTAINER, new ButtonItem[]{
                        new ButtonItem("Administration",0,new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7654239388")),null , ButtonType.AUTODIAL, null),
                        new ButtonItem("Dispatch",0,new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7654239321")),null , ButtonType.AUTODIAL, null),
                        new ButtonItem("Jail",0,new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7654231655")),null ,ButtonType.AUTODIAL, null),
                }),
                new ButtonItem("Services",R.drawable.new_services,null, null ,ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Sheriff's Sale",R.drawable.new_sheriffs_sale,null, null ,ButtonType.POPUPCONTAINER, new ButtonItem[]{
                                new ButtonItem("Sheriff's Sale GuideLine",0,new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tippecanoe.in.gov/DocumentCenter/View/740/Sheriff-Sale-Guidelines-PDF?bidId=")),null,ButtonType.LINKTOWEB,null),
                                new ButtonItem("Sheriff's Sale Listing",0,new Intent(Intent.ACTION_VIEW, Uri.parse("https://legacy.sri-taxsale.com/Foreclosure/PropertyListing.aspx?county=Tippecanoe")),null,ButtonType.LINKTOWEB,null),
                        }),                       //Sheriff-Sales Link
                        new ButtonItem("Gun Permissions",R.drawable.new_gun_permits,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/477/Firearm-Permits")), null ,ButtonType.LINKTOWEB, null),                      //Firearm-Permits Link
                        new ButtonItem("Crash Reports",R.drawable.new_crash_reports,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/486/Crash-Reports")), null ,ButtonType.LINKTOWEB, null),                        //Crash-Reports Link
                        new ButtonItem("Records Request",R.drawable.new_records_request,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/524/Public-Record-Requests")), null ,ButtonType.LINKTOWEB, null),               //Public-Record-Requests Link
                        new ButtonItem("Animal Control",R.drawable.new_animal_control,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/473/Animal-Control")), null ,ButtonType.LINKTOWEB, null),                       //Animal-Control Link
                        new ButtonItem("Security and Extra Patrol Request",R.drawable.new_security_requests,null, null ,ButtonType.POPUPCONTAINER, new ButtonItem[]{
                                new ButtonItem("Security Request",0, new Intent(context, Email.class),null,ButtonType.LINKTONEWPAGE,null),
                                new ButtonItem("Extra Patrol Request",0, new Intent(context,Email.class),null,ButtonType.LINKTONEWPAGE,null),
                        }),
                        new ButtonItem("Tax Warrants",R.drawable.new_tax_warrants,new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tippecanoe.in.gov/480/Tax-Warrants")), null ,ButtonType.LINKTOWEB, null),                          //Tax-Warrants Link
                        new ButtonItem("Traffic Complaints",R.drawable.new_traffic_complaints,new Intent(context,Email.class),null , ButtonType.LINKTONEWPAGE, null),
                }),
                new ButtonItem("Social Media",R.drawable.new_social_media,null, null ,ButtonType.CONTAINER, new ButtonItem[]{
                        new ButtonItem("Facebook",R.drawable.icofacebook,new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/660280407355488")), new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/TCSOIndiana/")) ,ButtonType.LINKTOSNS, null),                             //Facebook Link
                        new ButtonItem("Twitter",R.drawable.icotwitter,new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=tippecanoecoin")), new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/tippecanoecosh1")),ButtonType.LINKTOSNS, null),                               //Twitter Link
                        new ButtonItem("Instagram",R.drawable.icoinstagram,new Intent(Intent.ACTION_VIEW,Uri.parse("http://instagram.com/_u/tcso79")), new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/tcso79/")),ButtonType.LINKTOSNS, null),                                   //Instagram Link
                        // need app link or other ways 2 open app
                }),
                /*new ButtonItem("Enforcement",R.drawable.enforcement,null, null ,ButtonType.CONTAINER, new ButtonItem[]{

                }),
                new ButtonItem(null,R.drawable.others,null,null ,ButtonType.CONTAINER, null),*/
        };

    }

    //Getter
    public ButtonItem[] getData(){
        return data;
    }
}