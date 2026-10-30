package com.company.onlineschool;
import com.company.onlineschool.dto.*; import com.company.onlineschool.entity.*; import com.company.onlineschool.exception.*; import com.company.onlineschool.repository.*; import com.company.onlineschool.service.*;
import org.junit.*; import org.junit.runner.RunWith; import org.mockito.*; import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional; import static org.junit.Assert.*; import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SchoolServiceTest {
 @Mock private CourseRepository courses; @Mock private StudentRepository students; @InjectMocks private SchoolServiceImpl service;
 private Course course;
 @Before public void init(){ course=new Course(); course.setCourseId(7L); course.setCourseName("Java"); course.setCourseDescription("Core Java"); course.setCredits(4); }
 @Test public void createCourseMapsAndReturnsSavedCourse(){ CourseRequest r=new CourseRequest(); r.setCourseName(" Java "); r.setCourseDescription(" Core Java "); r.setCredits(4); when(courses.save(any(Course.class))).thenAnswer(i->{Course c=i.getArgument(0);c.setCourseId(7L);return c;}); CourseResponse out=service.createCourse(r); assertEquals(Long.valueOf(7),out.getCourseId());assertEquals("Java",out.getCourseName());assertEquals("Course created successfully",out.getMessage()); }
 @Test public void createStudentAssociatesExistingCourse(){ StudentRequest r=student("Asha","Rao","asha@school.test"); when(courses.findById(7L)).thenReturn(Optional.of(course)); when(students.existsByEmailIgnoreCase(r.getEmail())).thenReturn(false); when(students.save(any(Student.class))).thenAnswer(i->{Student s=i.getArgument(0);s.setStudentId(12L);return s;}); Student out=service.createStudent(7L,r);assertEquals(Long.valueOf(12),out.getStudentId());assertSame(course,out.getCourse());verify(students).save(any(Student.class)); }
 @Test(expected=ResourceNotFoundException.class) public void createStudentRejectsUnknownCourse(){when(courses.findById(99L)).thenReturn(Optional.empty());service.createStudent(99L,student("A","B","a@b.com"));}
 @Test(expected=DuplicateEmailException.class) public void createStudentRejectsDuplicateEmail(){when(courses.findById(7L)).thenReturn(Optional.of(course));when(students.existsByEmailIgnoreCase("asha@school.test")).thenReturn(true);service.createStudent(7L,student("Asha","Rao","asha@school.test"));}
 @Test public void getStudentReturnsExistingStudent(){Student s=new Student();s.setStudentId(3L);when(students.findById(3L)).thenReturn(Optional.of(s));assertSame(s,service.getStudent(3L));}
 @Test(expected=ResourceNotFoundException.class) public void getStudentRejectsUnknownId(){when(students.findById(3L)).thenReturn(Optional.empty());service.getStudent(3L);}
 private StudentRequest student(String f,String l,String e){StudentRequest r=new StudentRequest();r.setFirstName(f);r.setLastName(l);r.setEmail(e);return r;}
}
