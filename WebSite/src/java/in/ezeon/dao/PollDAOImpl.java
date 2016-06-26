/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.dao;

import in.ezeon.domain.Poll;
import in.ezeon.rm.PollRowMapper;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PollDAOImpl extends BaseNamedParameterJdbcTemplate implements PollDAO {

    @Override
    public void save(Poll p) {
        String sql="INSERT INTO poll("
                +" question "
                +" ,option1 "
                +" ,option2 "
                +" ,option3 "
                +" ,option4 "
                +" ,status) "
                +" VALUES("
                +" :qs "
                +" ,:o1 "
                +" ,:o2 "
                +" ,:o3 "
                +" ,:o4 "
                +" ,:st) ";
                
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("qs",p.getQuestion());
        param.addValue("o1",p.getOption1());
        param.addValue("o2",p.getOption2());
        param.addValue("o3",p.getOption3());
        param.addValue("o4",p.getOption4());
        param.addValue("st",p.getStatus());
        getNamedParameterJdbcTemplate().update(sql, param);
        
            }

    @Override
    public void update(Poll p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Poll p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer pollId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Poll findById( Integer pollId) {
        String sql="SELECT * FROM poll WHERE pollId=:plId";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("plId", pollId);
        return getNamedParameterJdbcTemplate().queryForObject(sql, param, new PollRowMapper());
        
        
    }

    @Override
    public List<Poll> findAll() {
        String sql="SELECT * FROM poll";
        MapSqlParameterSource param=new MapSqlParameterSource();
       return getNamedParameterJdbcTemplate().query(sql, param,new PollRowMapper());

    }

    @Override
    public List<Poll> findbyProperty(String name, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
