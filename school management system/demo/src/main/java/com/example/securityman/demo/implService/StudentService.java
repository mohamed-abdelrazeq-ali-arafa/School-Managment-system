package com.example.securityman.demo.implService;

import com.example.securityman.demo.Mappers.StudentMapper;
import com.example.securityman.demo.entity.Course;
import com.example.securityman.demo.entity.Student;
import com.example.securityman.demo.repository.ICourseRepository;
import com.example.securityman.demo.repository.IStudentRepository;
import com.example.securityman.demo.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Component
public class StudentService  implements IStudentService{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private CourseService courseService;


    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolService.class);


//    @Override
//    public Student addStudent(Student student) {
//        LOGGER.info("start of Student.addStudent with student  id "+student.getId());
//        String sql = "INSERT INTO student (email, password, firstname, lastname, phoneNumber, gender, gradLevel, parentNumber,courses) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
//        jdbcTemplate.update(sql,student.getEmail(),student.getPassword(),student.getFirstname(),student.getLastname()
//        ,student.getPhoneNumber(),student.getGender(),student.getGradLevel(),student.getParentNumber(),student.getCourses());
//        LOGGER.info("end of Student.addStudent with student id "+student.getId());
//            return student;
//    }


    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String deleteStudent(int id) {
        LOGGER.info("start of Student.deleteStudent with  id "+id);
        String sql = "DELETE FROM student WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected > 0) {
            LOGGER.info("end of Student.deleteStudent with  id "+id);
            return "Student with ID " + id + " has been successfully deleted.";
        } else {
            LOGGER.info("end of Student.deleteStudent with  id "+id);
            return "Student with ID " + id + " not found or could not be deleted.";
        }

    }


    @Override
    public List<Student> getAllStudent() {
        LOGGER.info("start of Student.getallstudent ");
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentMapper());
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }


//    public Student getStudentById(int id) {
//        LOGGER.info("start of StudentService.getStudentById with  id "+id);
//        String sql = "SELECT * FROM student WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
//    }

    @Override
    public String updateStudent(int id,Student student) {
        if(existsById(id)) {
            String sql = "UPDATE student SET email = ?, password = ?, firstname = ?, lastname = ?, " +
                    "phoneNumber = ?, gender = ?, gradLevel = ?, parentNumber = ? WHERE id = ?";
            jdbcTemplate.update(
                    sql,
                    student.getEmail(),
                    student.getPassword(),
                    student.getFirstname(),
                    student.getLastname(),
                    student.getPhoneNumber(),
                    student.getGender(),
                    student.getGradLevel(),
                    student.getParentNumber(),
                    id
            );
            return "Success update";
        }
        else
            return "There is No student with this id "+id;
    }

    @Override
    public boolean existsById(int id) {
        String sql = "SELECT COUNT(*) FROM student WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count > 0;
    }


    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from student",Integer.class);
    }


    @Override
    public Student registerStudentForCourse(int studentId, int courseId) {
        LOGGER.info("start of Student.registerStudentForCourse ");
         Set<Course> courses=null;
         Student student = studentRepository.findById(studentId).get();
         Course course= courseRepository.findById(courseId).get();

         courses =student.getCourses();
         courses.add(course);
         student.setCourses(courses);
         //   course.getStudents().add(student);
        //    courseRepository.save(course);
         LOGGER.info("end of  of Student.registerStudentForCourse ");
         return studentRepository.save(student);

    }

    public Set<Course> getCoursesForStudent(int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        return student.getCourses();
    }




}
