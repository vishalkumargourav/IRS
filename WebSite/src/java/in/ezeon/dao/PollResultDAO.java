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
public interface PollResultDAO {


    void update(PollResultDAO ps);

    void delete(PollResultDAO ps);

    void delete(Integer pollResultId);

    PollResultDAO findById(Integer pollResultId);

    List<PollResultDAO> findAll();

    List<PollResultDAO> findbyProperty(Integer pollId,Integer studentId);
    
}
    

