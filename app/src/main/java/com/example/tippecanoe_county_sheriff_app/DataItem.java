package com.example.tippecanoe_county_sheriff_app;

/* File name : DataItem.java
 * Description : save Button's data
 *
 * Maybe need to add a module to manage data (evolving later)
 * */

public class DataItem {
    private ButtonItem[] data;

    DataItem(){
        data = null;
    }

    public ButtonItem[] getData() {
        return data;
    }

    public void setData(ButtonItem[] data) {
        this.data = data;
    }

    //main menu data
    public ButtonItem[] getMainData(){
        data = new ButtonItem[]{
                new ButtonItem(R.drawable.admin,null, true, "Admin"),
                new ButtonItem(R.drawable.sex_offender,"http://www.icrimewatch.net/index.php?AgencyID=54758", false, null),
                new ButtonItem(R.drawable.corrections,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", true, "Corrections"),
                new ButtonItem(R.drawable.submit_a_tip,"", false, null),
                new ButtonItem(R.drawable.contact,"", false, null),
                new ButtonItem(R.drawable.services,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", true, "Services"),
                new ButtonItem(R.drawable.social_media,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", true, "SocialMedia"),
                new ButtonItem(R.drawable.enforcement,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", true, "Enforcement"),
        };
        return data;
    }

    //Admin sub menu data
    public ButtonItem[] getSubMenu_Admin(){
        data = new ButtonItem[]{
                new ButtonItem(R.drawable.admin,"https://www.tippecanoe.in.gov/Directory.aspx?did=43", false, null),                      //Phone Directory Link
                //Jun:
                //Maybe we can make a new Page
                //new ButtonItem(R.drawable.admin,"@Admin-Line-Link", false, null),                                                                               //I don't get it
                new ButtonItem(R.drawable.admin,"https://www.tippecanoe.in.gov/482/News-Releases", false, null),                          //Press Releases Link
                //There is no webpage
                new ButtonItem(R.drawable.admin,"https://www.tippecanoe.in.gov/470/Employment",false,null)                                //Employment Link
        };
        return data;
    }

    //Corrections sub menu data
    public ButtonItem[] getSubMenu_Corrections(){
        data = new ButtonItem[]{
                new ButtonItem(R.drawable.corrections,"http://www3.tippecanoe.in.gov/InmateListing/InmateSearch.aspx", false, null),      //Inmate Lookup Link
                //new ButtonItem(R.drawable.jail,"@Web_Based_Vendor_Link", false, null),                                                                          //I don't get it
                new ButtonItem(R.drawable.corrections,"https://deposits.jailatm.com/webdeposits/default.aspx",false, null),               //Jun:
                //this is more familiar
                //then a Web Based Vendor
                new ButtonItem(R.drawable.corrections,"https://tippecanoein.gtlvisitme.com/app",false, null),                             //Video Visitation Link
                //new ButtonItem(R.drawable.jail,"@Bond_Statements_&_Posting_Link",false, null),                                                                  //I don't get it
        };
        return data;
    }

    //Services sub menu data
    public ButtonItem[] getSubMenu_Services(){
        data = new ButtonItem[]{
                new ButtonItem(R.drawable.services,"https://www.tippecanoe.in.gov/479/Sheriff-Sales", false, null),                       //Sheriff-Sales Link
                new ButtonItem(R.drawable.services,"http://www.tippecanoe.in.gov/477/Firearm-Permits", false, null),                      //Firearm-Permits Link
                new ButtonItem(R.drawable.services,"http://www.tippecanoe.in.gov/486/Crash-Reports", false, null),                        //Crash-Reports Link
                new ButtonItem(R.drawable.services,"http://www.tippecanoe.in.gov/524/Public-Record-Requests", false, null),               //Public-Record-Requests Link
                new ButtonItem(R.drawable.services,"http://www.tippecanoe.in.gov/473/Animal-Control", false, null),                       //Animal-Control Link
                //new ButtonItem(R.drawable.services,"@Security_Request_Link", false, null),
                new ButtonItem(R.drawable.services,"http://www.tippecanoe.in.gov/480/Tax-Warrants", false, null),                         //Tax-Warrants Link
        };
        return data;
    }

    //Social Media sub menu data
    public ButtonItem[] getSubMenu_SocialMedia(){
        data = new ButtonItem[]{
                new ButtonItem(R.drawable.social_media,"https://twitter.com/tippecanoecosh1", false, null),                               //Twitter Link
                new ButtonItem(R.drawable.social_media,"https://www.facebook.com/TCSOIndiana/", false, null),                             //Facebook Link
                new ButtonItem(R.drawable.social_media,"https://www.instagram.com/tcso79/", false, null),                                 //Instagram Link
        };
        return data;
    }

    //Enforcement sub menu data
    public ButtonItem[] getSubMenu_Enforcement(){
        data = new ButtonItem[]{
                new ButtonItem(R.drawable.enforcement,"https://wetip.com/", false, null),                                                 //We-Tip Link
                //Jun:
                //I think we need more:
                //Description(Maybe extra Page)
                //new ButtonItem(R.drawable.services,"@Traffic_Complaints_Link", false, null),
        };
        return data;
    }

    public ButtonItem getDataAt(int position){
        return data[position];
    }
    public ButtonItem[] getAllData(){
        return data;
    }
    public int getLength(){ return data.length; }
}