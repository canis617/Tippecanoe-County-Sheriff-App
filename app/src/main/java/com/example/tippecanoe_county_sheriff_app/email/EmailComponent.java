package com.example.tippecanoe_county_sheriff_app.email;

import android.view.View;
import android.widget.TextView;

import com.example.tippecanoe_county_sheriff_app.R;

public class EmailComponent {
    private String eSubject, eBody;
    private TextView eName, eContract, ePhonenumber, eComplaint, eArea, eTime, eOther;

    public EmailComponent(View view) {
        eName = view.findViewById(R.id.edit_text_name);
        eContract = view.findViewById(R.id.edit_text_email);
        ePhonenumber = view.findViewById(R.id.edit_text_pnum);
        eComplaint = view.findViewById(R.id.edit_text_complaint);
        eArea = view.findViewById(R.id.edit_text_area);
        eTime = view.findViewById(R.id.edit_text_time);
        eOther = view.findViewById(R.id.edit_text_other);
    }

    public String getSubject(){
        eSubject = eName.getText() + ", (" + eContract.getText() + ", " +  ePhonenumber.getText() + ")";
        return eSubject;
    }
    public String getBody(){
        eBody = "Complaint: " + eComplaint.getText() + "\n" + "Area: "+ eArea.getText() + "\n" + "Time: "
                + eTime.getText() + "\n" + "Other Information: "+ eOther.getText();
        return eBody;
    }
    public Boolean isNotNull(){
        if(!ePhonenumber.getText().toString().trim().equals("") && !eComplaint.getText().toString().trim().equals("") && !eArea.getText().toString().trim().equals("")
                && !eTime.getText().toString().trim().equals("") &&  !eOther.getText().toString().trim().equals("")){
            return true;
        }
        else{ return false; }
    }


}
