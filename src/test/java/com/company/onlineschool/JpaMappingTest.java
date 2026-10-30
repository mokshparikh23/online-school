package com.company.onlineschool;
import com.company.onlineschool.entity.*; import com.company.onlineschool.repository.*; import org.junit.*; import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class) @DataJpaTest
public class JpaMappingTest {
 @Autowired private CourseRepository courses; @Autowired private StudentRepository students;
 @Test public void studentPersistsWithExactlyOneCourse(){Course c=new Course();c.setCourseName("Java");c.setCourseDescription("Basics");c.setCredits(4);c=courses.save(c);Student s=new Student();s.setFirstName("Asha");s.setLastName("Rao");s.setEmail("asha@school.test");s.setCourse(c);s=students.saveAndFlush(s);Student found=students.findById(s.getStudentId()).orElseThrow();assertEquals(c.getCourseId(),found.getCourse().getCourseId());}
 @Test public void manyStudentsCanShareCourse(){Course c=new Course();c.setCourseName("Java");c.setCourseDescription("Basics");c.setCredits(4);c=courses.save(c);students.save(student("a@x.com",c));students.save(student("b@x.com",c));assertEquals(2,students.findAll().size());assertEquals(c.getCourseId(),students.findAll().get(0).getCourse().getCourseId());}
 @Test public void emailLookupIgnoresCase(){Course c=new Course();c.setCourseName("Java");c.setCourseDescription("Basics");c.setCredits(4);c=courses.save(c);students.saveAndFlush(student("Asha@School.Test",c));assertTrue(students.existsByEmailIgnoreCase("asha@school.test"));}
 private Student student(String email,Course c){Student s=new Student();s.setFirstName("A");s.setLastName("B");s.setEmail(email);s.setCourse(c);return s;}
}
