/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.dao;

import java.util.List;

/**
 *
 * @author VarunAg
 */
public class PollResultDAOImpl extends BaseNamedParameterJdbcTemplate implements PollResultDAO   {

    @Override
    public void update(PollResultDAO ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(PollResultDAO ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer pollResultId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PollResultDAO findById(Integer pollResultId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PollResultDAO> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PollResultDAO> findbyProperty(Integer pollId, Integer studentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
