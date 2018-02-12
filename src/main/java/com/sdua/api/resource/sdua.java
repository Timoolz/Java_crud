package com.sdua.api.resource;

import com.sdua.api.bean.Bug;
import com.sdua.api.bean.MyResponse;

/**
 * Created by sq_09 on 1/30/2018.
 */
public interface sdua {

    MyResponse createbug (Bug bug);
    MyResponse updatebug (Bug bug);
    MyResponse deletebug (int bugid);
    MyResponse getbugs   (String a, String b);

}
