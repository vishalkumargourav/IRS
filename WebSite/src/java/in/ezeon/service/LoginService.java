/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.service;

import in.ezeon.dao.BaseNamedParameterJdbcTemplate;
import in.ezeon.dao.Semester;
import in.ezeon.domain.AdminLogin;
import in.ezeon.rm.AdminCommandRowMapper;
import in.ezeon.rm.SemesterRowMapper;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author VarunAg
 */
@Service
public class LoginService extends BaseNamedParameterJdbcTemplate{
    
    public AdminLogin authenticate(String userName, String password){
    
         String sql="select * from adminlogin where userName=:usrName AND password=:psw";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("usrName", userName);
        param.addValue("psw",password);
     AdminLogin admin=  getNamedParameterJdbcTemplate().queryForObject(sql, param,new AdminCommandRowMapper());
    return admin;
    }
    public List<Semester>  getSem()
    {
        String sql="SELECT * FROM semester";
        MapSqlParameterSource param=new MapSqlParameterSource();
        return getNamedParameterJdbcTemplate().query(sql, param, new SemesterRowMapper());
        
    }
    
}
