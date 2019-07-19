package com.example.tippecanoe_county_sheriff_app;

public class data_item {
    object_item[] data;

    data_item(){
        setMenuData();
    }

    public void setMenuData(){
        data = new object_item[]{
                new object_item(R.drawable.ic_launcher_background,null, true, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.google.com", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
        };
    }

    public void setSubMenu(){

    }

    public object_item getdata(int position){
        return data[position];
    }
    public object_item[] getAllData(){
        return data;
    }
    public int getLength(){ return data.length; }
}