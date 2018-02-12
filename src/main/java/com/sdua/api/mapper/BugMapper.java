package com.sdua.api.mapper;

import com.sdua.api.bean.Bug;
import com.sdua.api.bean.Severity;
import com.sdua.api.bean.Status;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sq_09 on 1/30/2018.
 */
public class BugMapper implements ResultSetMapper<Bug> {
    @Override
    public Bug map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Bug bug = new Bug();

        int numm = resultSet.getMetaData().getColumnCount();
        String nammes[] = new String[numm];

        for(int iii =1; iii<=numm; iii++){

            nammes[iii-1] = resultSet.getMetaData().getColumnName(iii);

        }
        List<String> list = Arrays.asList(nammes);

        if(list.contains("bug_id")){
            bug.setBug_id(resultSet.getInt("bug_id"));
        }

        if(list.contains("bug_desc")){
            bug.setBug_desc(resultSet.getString("bug_desc"));
        }

        if(list.contains("bug_title")){
            bug.setBug_title(resultSet.getString("bug_title"));
        }

        if(list.contains("severity")){
            bug.setSeverity(Severity.valueOf(resultSet.getString("severity")));
        }

        if(list.contains("status")){
            bug.setStatus(Status.valueOf(resultSet.getString("status")));
        }

        if(list.contains("user_id")){
            bug.setUser_id(resultSet.getString("user_id"));
        }

        return bug;
    }
}
