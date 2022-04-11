package org.acs.hql;

import org.acs.hql.dao.StudentDao;
import org.acs.hql.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	
    	StudentDao sDao = new StudentDao();
     Student student = new 	Student("NAVEN","REDDY","NAVEN@gmail.com");
     
    sDao.saveStudent(student);
     
     student.setFirstName("abhishek");
     sDao.updateStudent(student);
     
     
     Student s2 = sDao.getStudentById(student.getId());
     
    }
}
