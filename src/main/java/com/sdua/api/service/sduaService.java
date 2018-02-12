package com.sdua.api.service;

import com.sdua.api.bean.*;
import com.sdua.api.dao.BugDaoImpl;
import com.sdua.api.resource.sdua;

import javax.inject.Inject;

/**
 * Created by sq_09 on 1/17/2018.
 */
public class sduaService implements sdua {

    private  final BugDaoImpl bugDao;


    @Inject
    public sduaService(BugDaoImpl bugDao) {
        this.bugDao = bugDao;
    }

    @Override
    public MyResponse createbug(Bug userbug){
        MyResponse response = new MyResponse();
        try {

            response.setData(bugDao.createBug(userbug));
            response.setMsg("Successful");
            response.setStatus("Currently running");
        }
        catch(Exception ee)
        {
            response.setStatus("Unsuccsful transaction");
            response.setMsg(ee.getMessage());

        }


        return response;

    }

    @Override
    public MyResponse updatebug(Bug userbug){

        MyResponse response = new MyResponse();
        //response.setData(userbug);
        bugDao.updateBug(userbug);
        response.setMsg("Successful Update");
        response.setStatus("Currently running Update");
        return response;

    }


    @Override
    public MyResponse deletebug(int bug_id){

        MyResponse myResponse = new MyResponse();
        bugDao.deleteBug(bug_id);
        myResponse.setMsg("Successful delete Operation");
        myResponse.setStatus("Valide");

        return myResponse;
    }


    @Override
    public MyResponse getbugs(String sort_type, String sort_value){

        MyResponse response = new MyResponse();

        switch (sort_type){

            case "all":
                response.setMsg("Successful");
                response.setStatus("This is for  " + sort_type +"  with sub:  "+ sort_value);
                response.setData(bugDao.getallBugs());

            break;

            case  "single":
                int mybugid  = Integer.parseInt(sort_value);
                response.setStatus("sucess");
                response.setData(bugDao.getBug(mybugid));

            break;

            case  "status":
                response.setMsg("Successful");
                response.setStatus("This is for  " + sort_type +"  with sub:  "+ sort_value);
                response.setData(bugDao.getallBugs(Status.valueOf(sort_value)));

            break;

            case  "severity":
                response.setMsg("Successful");
                response.setStatus("This is for  " + sort_type +"  with sub:  "+ sort_value);
                response.setData(bugDao.getallBugs(Severity.valueOf(sort_value)));

            break;

            default:

                response.setMsg("Unsuccessful Operation");
                response.setStatus("Could not determine the sort_type of the expression");

            break;


        }

        return response;

    }



    public Result squareroot (Double value1) {
        Double answer = Math.sqrt(value1);

        Result result = new Result();
        result.setAnswer(answer);
        return result;
    }




    public Object show(DisplayData userData){
        DisplayData displayData = new DisplayData();
        //displayData.setData(userData);


        displayData.Firstname = userData.Firstname;
        displayData.Lastname = userData.Lastname;
        displayData.Nickname = userData.Nickname;
        displayData.DOB = userData.DOB;




        displayData.setResponse("Successful");
        return displayData;
    }


}
