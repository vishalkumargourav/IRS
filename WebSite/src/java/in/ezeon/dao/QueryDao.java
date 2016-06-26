/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.dao;

import in.ezeon.domain.Query;
import java.util.List;

/**
 *
 * @author personal
 */
public interface QueryDao {
    void save(Query q);

    void update(Query q);

    void delete(Query q);

    void delete(Integer queryId);

    Query findById(Integer queryId);

    List<Query> findAll();

    List<Query> findbyProperty(String name, Object value);
}
