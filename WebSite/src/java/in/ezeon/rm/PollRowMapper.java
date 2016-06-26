/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.rm;

import in.ezeon.domain.Poll;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VarunAg
 */
public class PollRowMapper implements RowMapper<Poll>{

    @Override
    public Poll mapRow(ResultSet rs, int i) throws SQLException {
        Poll p=new Poll();
        p.setPollId(rs.getInt("pollId"));
        p.setQuestion(rs.getString("question"));
        p.setOption1(rs.getString("option1"));
        p.setOption2(rs.getString("option2"));
        p.setOption3(rs.getString("option3"));
        p.setOption4(rs.getString("option4"));
        p.setStatus(rs.getString("status"));
        p.setStatusId(rs.getInt("statusId"));
        return p;
        
    }
    
}
