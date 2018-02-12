package com.sdua.api.dao;

import com.sdua.api.bean.Bug;
import com.sdua.api.bean.Severity;
import com.sdua.api.bean.Status;
import com.sdua.api.mapper.BugMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by sq_09 on 1/30/2018.
 */

@RegisterMapper(BugMapper.class)
public abstract class BugDaoImpl implements BugDao{

    @GetGeneratedKeys
    @SqlUpdate("insert into bug (bug_title, bug_desc, status, severity, user_id) values (:bug_title, :bug_desc, :status, :severity, :user_id)")
    @Override
    public abstract int createBug(@BindBean Bug bug);


    @SqlQuery("select * from bug where bug_id = :bug_id")
    @Override
    public abstract Bug getBug(@Bind("bug_id") int bugid);



    @SqlQuery("select bug_id, bug_desc, bug_title, status, severity, user_id from bug ")
    @Override
    public abstract List<Bug> getallBugs();



    @SqlQuery("select * from bug where status = :status")
    @Override
    public abstract List<Bug> getallBugs(@Bind("status") Status status) ;



    @SqlQuery("select bug_id, bug_desc, bug_title, status, severity, user_id from bug where severity = :severity")
    @Override
    public abstract List<Bug> getallBugs(@Bind("severity") Severity severity);



    @SqlUpdate("delete from bug where bug_id = :bug_id")
    @Override
    public abstract void deleteBug(@Bind("bug_id") int bugid);



    @SqlUpdate("update bug set bug_title = :bug_title, bug_desc = :bug_desc, status = :status, severity = :severity  where bug_id = :bug_id")
    @Override
    public abstract void updateBug(@BindBean Bug bug) ;
}
