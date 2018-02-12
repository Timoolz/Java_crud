package com.sdua.api.bean;

/**
 * Created by sq_09 on 1/29/2018.
 */
public class Bug {


    private  int bug_id;
    public   String bug_title;
    public   String bug_desc;
    public   Status status;
    public   Severity severity;
    public   String user_id;

    public void setBug_id(int bug_id) {
        this.bug_id = bug_id;
    }



    public void setBug_desc(String bug_desc) {
        this.bug_desc = bug_desc;
    }

    public void setBug_title(String bug_title) {
        this.bug_title = bug_title;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
    public int getBug_id() {
        return bug_id;
    }

    public String getBug_desc() {
        return bug_desc;
    }

    public String getBug_title() {
        return bug_title;
    }

    public String getUser_id() {
        return user_id;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Status getStatus() {
        return status;
    }


}
