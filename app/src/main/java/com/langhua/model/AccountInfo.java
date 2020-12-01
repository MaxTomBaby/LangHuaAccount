package com.langhua.model;

import java.util.Date;

public class AccountInfo {

    private String ac_id;
    private String ac_type;
    private float ac_data;
    private Date ac_time;
    private String ac_rmark;

    public String getAc_id() {
        return ac_id;
    }

    public void setAc_id(String ac_id) {
        this.ac_id = ac_id;
    }

    public String getAc_type() {
        return ac_type;
    }

    public void setAc_type(String ac_type) {
        this.ac_type = ac_type;
    }

    public float getAc_data() {
        return ac_data;
    }

    public void setAc_data(float ac_data) {
        this.ac_data = ac_data;
    }

    public Date getAc_time() {
        return ac_time;
    }

    public void setAc_time(Date ac_time) {
        this.ac_time = ac_time;
    }

    public String getAc_rmark() {
        return ac_rmark;
    }

    public void setAc_rmark(String ac_rmark) {
        this.ac_rmark = ac_rmark;
    }

}
