package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Account;
import com.codinghive.ticketMonster.jee.model.Course;
import com.codinghive.ticketMonster.jee.model.Project;
import com.codinghive.ticketMonster.jee.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Stateless(name="StudentDAO")
public class StudentDao implements StudentDaoLocal {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDao.class);

    protected static final String STUDENT_PU = "mariaDB-eclipselink";

    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;

    public void addStudent(Student student) {
    	em.getTransaction().begin();
		
        em.persist(student);
        
        
        em.getTransaction().commit();

        LOGGER.info("Created Student:" + student);
    }

    public void editStudent(Student student) {
        em.merge(student);
    }

    public void deleteStudent(int studentId) {
        em.remove(getStudent(studentId));
    }

    public Student getStudent(int studentId) {
        return em.find(Student.class, studentId);
    }

    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.getAll").getResultList();
    }
    
    public int getAllLazy() {
//    	Student student = em.find(Student.class, 1);
//    	em.detach(student);
//    	return student.getCourseList().size();
    	return 0;
    }
    
    public List<Student> search() {
    	// Query for a List of objects.
    	Query query = em.createQuery("Select e FROM Student e WHERE e.grade > 50.00");
    	List<Student> result = query.getResultList();
    	
    	 
    	// Query for a List of data elements.
//    	Query query = em.createQuery("Select e.firstname FROM Student e");
//    	List<String> result = query.getResultList();
    	 
    	// Query for a List of element arrays.
//    	Query query = em.createQuery("Select e.firstname, e.grade FROM Student e");
//    	List<Object[]> result = query.getResultList();
    	
		//    	setFirstResult()
		//    	setMaxResults()
    	
    	return result;
    }
    
    public Object searchSingle() {
    	// Query for a single object.
    	Query query = em.createQuery("Select e FROM Student e WHERE e.studentId = :id");
    	query.setParameter("id", 1);
    	Student result = (Student)query.getSingleResult();
    	 
    	// Query for a single data element.
//    	Query query = em.createQuery("Select MAX(e.grade) FROM Student e");
//    	BigDecimal result = (BigDecimal)query.getSingleResult();
    	
//    	Query query = em.createQuery("Select e FROM Student e JOIN e.projectList u WHERE u.name = :name");
//    	query.setParameter("name", "student_example");
//    	Student result = (Student)query.getSingleResult();
    	


    	
    	return result;
    }
    
    
    
    
    
    
    
    // ONE TO ONE
	//    Account account = new Account("test@test.edu", "giannis.smirnios.ceid.upatras.gr", student);
	//    student.setAccount(account);
    
    // ONE TO MANY
	//	Project project1 = new Project("student_example","java",false,student);
	//	Project project2 = new Project("hearthstone clone","ionic",false,student);
	//	Project project3 = new Project("random_number_calculator","C++",true,student);
	//	
	//	List<Project> projects = new ArrayList<Project>();
	//	projects.add(project1);
	//	projects.add(project2);
	//	projects.add(project3);
	//	student.setProjectList(projects);
    
	//    MANY TO MANY
	//	Course simata = new Course("Signals and Systems", "simata.ceid.upatras.gr", "Psarakis Emmanouil", 5, student);
	//	Course java = new Course("Introduction to Java", "java.ceid.upatras.gr", "James Gosling", 1, student);
	//	
	//	List<Course> courses = new ArrayList<Course>();
	//	courses.add(simata);
	//	courses.add(java);
	//	student.setCourseList(courses);
   
    

}
