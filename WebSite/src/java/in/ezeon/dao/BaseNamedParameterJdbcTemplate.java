/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;


public class BaseNamedParameterJdbcTemplate extends NamedParameterJdbcDaoSupport{
    @Autowired
    public void setDataSource1(DataSource dataSource){
        setDataSource(dataSource);
    }
    
}
