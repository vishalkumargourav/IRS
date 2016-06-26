/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.dao;

import in.ezeon.domain.Student;
import java.util.List;

public interface StudentDAO {
       void save(Student s);

    void update(Student s);

    void delete(Student s);

    void delete(Integer scholarNumber);

    Student findById(String userName,String passsword);

    List<Student> findAll();

    List<Student> findbyProperty(String name, Object value);
    
}
