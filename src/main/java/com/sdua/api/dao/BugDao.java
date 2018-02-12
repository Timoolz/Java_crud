package com.sdua.api.dao;

import com.sdua.api.bean.Bug;
import com.sdua.api.bean.Severity;
import com.sdua.api.bean.Status;

import java.util.List;

public interface BugDao{

     int createBug(Bug bug);
     List<Bug> getallBugs();
     List<Bug> getallBugs(Severity severity);
     List<Bug> getallBugs(Status status);
     Bug getBug(int bugid);
     void updateBug(Bug bug);
     void deleteBug(int bugid);



}