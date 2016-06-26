/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.rm;

import in.ezeon.domain.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author personal
 */
public class QueryRowMapper implements RowMapper<Query>{

    @Override
    public Query mapRow(ResultSet rs, int i) throws SQLException {
        Query q= new Query();
        q.setAnswer(rs.getString("answer"));
        q.setAnsweredBy(rs.getInt("answeredBy"));
        q.setQuery(rs.getString("query"));
        q.setQueryId(rs.getInt("queryId"));
        q.setSubmitedBy(rs.getInt("submitedBy"));
        return q;
    }
    
}
