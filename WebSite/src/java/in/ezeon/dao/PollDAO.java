
package in.ezeon.dao;

import in.ezeon.domain.Poll;
import java.util.List;


public interface PollDAO {
       void save(Poll p);

    void update(Poll p);

    void delete(Poll p);

    void delete(Integer pollId);

    Poll findById(Integer pollId);

    List<Poll> findAll();

    List<Poll> findbyProperty(String name, Object value);
        
}
