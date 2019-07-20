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
                new object_item(R.drawable.ic_launcher_background,null, true, "Jail"),
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
        return data;
    }

    public object_item[] getSubMenu_01(){
        data = new object_item[]{
                new object_item(R.drawable.ic_launcher_background,"https://www.google.com", false, null),
                new object_item(R.drawable.ic_launcher_background,"https://www.tippecanoe.in.gov/359/Sheriffs-Department", false, null),
        };
        return data;
    }

    public object_item getdata(int position){
        return data[position];
    }
    public object_item[] getAllData(){
        return data;
    }
    public int getLength(){ return data.length; }
}