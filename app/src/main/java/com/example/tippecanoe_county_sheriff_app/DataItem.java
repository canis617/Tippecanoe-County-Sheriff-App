package com.example.tippecanoe_county_sheriff_app;

public class DataItem {
    private object_item[] data;

    DataItem(){
        data = null;
    }

    public object_item[] getData() {
        return data;
    }

    public void setData(object_item[] data) {
        this.data = data;
    }

    public object_item[] getMainData(){
        data = new object_item[]{
                new object_item(R.drawable.admin,null, true, "Admin"),
                new object_item(R.drawable.sex_offender,"http://www.icrimewatch.net/index.php?AgencyID=54758", false, null),
                new object_item(R.drawable.corrections,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", true, "Corrections"),
                new object_item(R.drawable.submit_a_tip,"", false, null),
                new object_item(R.drawable.contact,"", false, null),
                new object_item(R.drawable.services,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", true, "Services"),
                new object_item(R.drawable.social_media,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", true, "SocialMedia"),
                new object_item(R.drawable.enforcement,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", true, "Enforcement"),
        };
        return data;
    }

    public object_item[] getSubMenu_Admin(){
        data = new object_item[]{
                new object_item(R.drawable.admin,"https://www.tippecanoe.in.gov/Directory.aspx?did=43", false, null),                      //Phone Directory Link
                //Jun:
                //Maybe we can make a new Page
                //new object_item(R.drawable.admin,"@Admin-Line-Link", false, null),                                                                               //I don't get it
                new object_item(R.drawable.admin,"https://www.tippecanoe.in.gov/482/News-Releases", false, null),                          //Press Releases Link
                //There is no webpage
                new object_item(R.drawable.admin,"https://www.tippecanoe.in.gov/470/Employment",false,null)                                //Employment Link
        };
        return data;
    }

    public object_item[] getSubMenu_Corrections(){
        data = new object_item[]{
                new object_item(R.drawable.corrections,"http://www3.tippecanoe.in.gov/InmateListing/InmateSearch.aspx", false, null),      //Inmate Lookup Link
                //new object_item(R.drawable.jail,"@Web_Based_Vendor_Link", false, null),                                                                          //I don't get it
                new object_item(R.drawable.corrections,"https://deposits.jailatm.com/webdeposits/default.aspx",false, null),               //Jun:
                //this is more familiar
                //then a Web Based Vendor
                new object_item(R.drawable.corrections,"https://tippecanoein.gtlvisitme.com/app",false, null),                             //Video Visitation Link
                //new object_item(R.drawable.jail,"@Bond_Statements_&_Posting_Link",false, null),                                                                  //I don't get it
        };
        return data;
    }

    public object_item[] getSubMenu_Services(){
        data = new object_item[]{
                new object_item(R.drawable.services,"https://www.tippecanoe.in.gov/479/Sheriff-Sales", false, null),                       //Sheriff-Sales Link
                new object_item(R.drawable.services,"http://www.tippecanoe.in.gov/477/Firearm-Permits", false, null),                      //Firearm-Permits Link
                new object_item(R.drawable.services,"http://www.tippecanoe.in.gov/486/Crash-Reports", false, null),                        //Crash-Reports Link
                new object_item(R.drawable.services,"http://www.tippecanoe.in.gov/524/Public-Record-Requests", false, null),               //Public-Record-Requests Link
                new object_item(R.drawable.services,"http://www.tippecanoe.in.gov/473/Animal-Control", false, null),                       //Animal-Control Link
                //new object_item(R.drawable.services,"@Security_Request_Link", false, null),
                new object_item(R.drawable.services,"http://www.tippecanoe.in.gov/480/Tax-Warrants", false, null),                         //Tax-Warrants Link
        };
        return data;
    }

    public object_item[] getSubMenu_SocialMedia(){
        data = new object_item[]{
                new object_item(R.drawable.social_media,"https://twitter.com/tippecanoecosh1", false, null),                               //Twitter Link
                new object_item(R.drawable.social_media,"https://www.facebook.com/TCSOIndiana/", false, null),                             //Facebook Link
                new object_item(R.drawable.social_media,"https://www.instagram.com/tcso79/", false, null),                                 //Instagram Link
        };
        return data;
    }

    public object_item[] getSubMenu_Enforcement(){
        data = new object_item[]{
                new object_item(R.drawable.enforcement,"https://wetip.com/", false, null),                                                 //We-Tip Link
                //Jun:
                //I think we need more:
                //Description(Maybe extra Page)
                //new object_item(R.drawable.services,"@Traffic_Complaints_Link", false, null),
        };
        return data;
    }

    public object_item getDataAt(int position){
        return data[position];
    }
    public object_item[] getAllData(){
        return data;
    }
    public int getLength(){ return data.length; }
}