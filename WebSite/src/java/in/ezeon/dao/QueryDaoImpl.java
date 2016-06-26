/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.dao;

import in.ezeon.domain.Query;
import in.ezeon.rm.QueryRowMapper;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author personal
 */
@Repository
public class QueryDaoImpl extends BaseNamedParameterJdbcTemplate implements QueryDao{

    @Override
    public void save(Query q) {
        String sql="INSERT INTO query"+
                " (answeredBy"+
                " ,submitedBy"+
                " ,query"+
                " ,answer)"+
                " VALUES (:ansBy"+
                " ,:subBy"+
                " ,:query"+
                " ,:ans)";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("ansBy", q.getAnsweredBy());
        param.addValue("subBy", q.getSubmitedBy());
        param.addValue("query", q.getQuery());
        param.addValue("ans", q.getAnswer());
        getNamedParameterJdbcTemplate().update(sql, param);
    }

    @Override
    public void update(Query q) {
        String sql="UPDATE query SET "
                +" query=:qry"
                +" ,answer=:ans"
                +" ,answeredBy=:ansBy"
                +" ,submitedBy=:subBy"
                +" WHERE queryId=:qid";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("qry", q.getQuery());
        param.addValue("ans",q.getAnswer());
        param.addValue("ansBy", q.getAnsweredBy());
        param.addValue("subBy",q.getSubmitedBy());
        param.addValue("qid",q.getQueryId());
        getNamedParameterJdbcTemplate().update(sql, param);
    }

    @Override
    public void delete(Query q) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer queryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Query findById(Integer queryId) {
        String sql="SELECT * FROM query where queryId=:qid";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("qid",queryId);
        return getNamedParameterJdbcTemplate().queryForObject(sql, param, new QueryRowMapper());
    }

    @Override
    public List<Query> findAll() {
        String sql="SELECT * FROM query ";
        MapSqlParameterSource param=new MapSqlParameterSource();
        return getNamedParameterJdbcTemplate().query(sql, param, new QueryRowMapper());
    }

    @Override
    public List<Query> findbyProperty(String name, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
