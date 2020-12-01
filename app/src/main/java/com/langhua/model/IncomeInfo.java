package com.langhua.model;

import java.util.Date;

public class IncomeInfo {

    private String in_id;
    private String in_type;
    private float in_data;
    private Date in_time;
    private String in_rmark;

    public String getIn_id() {
        return in_id;
    }

    public void setIn_id(String in_id) {
        this.in_id = in_id;
    }

    public String getIn_type() {
        return in_type;
    }

    public void setIn_type(String in_type) {
        this.in_type = in_type;
    }

    public float getIn_data() {
        return in_data;
    }

    public void setIn_data(float in_data) {
        this.in_data = in_data;
    }

    public Date getIn_time() {
        return in_time;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public String getIn_rmark() {
        return in_rmark;
    }

    public void setIn_rmark(String in_rmark) {
        this.in_rmark = in_rmark;
    }

}
