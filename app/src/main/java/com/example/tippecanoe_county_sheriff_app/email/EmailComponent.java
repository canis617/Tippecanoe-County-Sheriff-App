package com.example.tippecanoe_county_sheriff_app.email;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tippecanoe_county_sheriff_app.R;

public class EmailComponent {
    private String ButtonName,eSubject, eBody;
    private EditText eName, ePhonenumber, eContent, eArea, eTime, eOther;
    private TextView tMainContent;

    public EmailComponent(View view,String ButtonName) {
        eName = view.findViewById(R.id.edit_text_name);
        ePhonenumber = view.findViewById(R.id.edit_text_pnum);
        eContent = view.findViewById(R.id.edit_text_content);
        eArea = view.findViewById(R.id.edit_text_area);
        eTime = view.findViewById(R.id.edit_text_time);
        eOther = view.findViewById(R.id.edit_text_other);
        tMainContent = view.findViewById(R.id.maincontent);
        this.ButtonName = ButtonName;
        setText();
    }
    private void setText(){
        switch (ButtonName){
            case "Traffic Complaints":
                tMainContent.setText("Complaint:");
                break;
            case "Security Request":
                tMainContent.setText("Request:");
                break;
            case "Extra Patrol Request":
                tMainContent.setText("Request:");
                break;
                default:
                    break;
        }
    }


    public String getSubject(){
        eSubject ="";
        if(!eName.getText().toString().trim().equals("")){eSubject+=eName.getText()+" ";}
        if(!ePhonenumber.getText().toString().trim().equals("")){eSubject+="(" + ePhonenumber.getText() + ")";}
        return eSubject;
    }
    public String getBody(){
        eBody = tMainContent.getText().toString() + "\n" + eContent.getText() + "\n\n" + "Area: "+ eArea.getText() + "\n\n" + "Time: "
                + eTime.getText() + "\n\n" + "Other Information:\n"+ eOther.getText();
        return eBody;
    }

    public Boolean isNotNull(){
        if(!eContent.getText().toString().trim().equals("") && !eArea.getText().toString().trim().equals("")
                && !eTime.getText().toString().trim().equals("") && !eOther.getText().toString().trim().equals("")){
            return true;
        }
        else{ return false; }
    }


}
