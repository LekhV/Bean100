package com.example.lekh.bean2.Models;

import android.widget.ImageView;
import android.widget.TextView;

public class ModelBusiness  {

    private String NameBusiness;
    private String LocationBusiness;
    private String WorkingHoursBusiness;

    private int ImageBusiness;
    private int BobBusiness;

    public ModelBusiness(String nameBusiness, String locationBusiness, String workingHoursBusiness, int imageBusiness, int bobBusiness) {
        NameBusiness = nameBusiness;
        LocationBusiness = locationBusiness;
        WorkingHoursBusiness = workingHoursBusiness;
        ImageBusiness = imageBusiness;
        BobBusiness = bobBusiness;
    }

    public String getNameBusiness() {
        return NameBusiness;
    }

    public void setNameBusiness(String nameBusiness) {
        NameBusiness = nameBusiness;
    }

    public String getLocationBusiness() {
        return LocationBusiness;
    }

    public void setLocationBusiness(String locationBusiness) {
        LocationBusiness = locationBusiness;
    }

    public String getWorkingHoursBusiness() {
        return WorkingHoursBusiness;
    }

    public void setWorkingHoursBusiness(String workingHoursBusiness) {
        WorkingHoursBusiness = workingHoursBusiness;
    }

    public int getImageBusiness() {
        return ImageBusiness;
    }

    public void setImageBusiness(int imageBusiness) {
        ImageBusiness = imageBusiness;
    }

    public int getBobBusiness() {
        return BobBusiness;
    }

    public void setBobBusiness(int bobBusiness) {
        BobBusiness = bobBusiness;
    }
}
