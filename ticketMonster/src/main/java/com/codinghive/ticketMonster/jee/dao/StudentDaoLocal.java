package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Student;

import java.util.List;
import javax.ejb.Local;

@Local
public interface StudentDaoLocal {

    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(int studentId);

    Student getStudent(int studentId);

    List<Student> getAllStudents();

    int getAllLazy();

    List<Student> search();
    
    Object searchSingle();
    
}
