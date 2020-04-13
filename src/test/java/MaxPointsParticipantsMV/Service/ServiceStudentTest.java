package MaxPointsParticipantsMV.Service;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import MaxPointsParticipantsMV.Validator.ValidationException;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceStudentTest {
    private final String ID = "180";
    private final String STUDENT_NAME = "Teodora Velicu";
    private final int GROUP_NUMBER  = 937;
    private final String EMAIL = "teo@gmail.com";
    private final String PROFESOR_NAME = "Ceva Prof";


    @Test
    public void addStudentOne() {
        StudentRepo repo = new StudentRepo(new StudentValidator(),"studenti.xml");
        ServiceStudent service = new ServiceStudent(repo);
        Student studentOne = new Student ("445", "Teodora Velicu", 937, "teo@gmail.com", "Ceva profesor");

        service.add(studentOne);
        Student returnStudentOne = service.find("445");

        assertEquals(returnStudentOne, studentOne);
    }

    @Test
    public void addStudentTwo() {
        StudentRepo repo = new StudentRepo(new StudentValidator(),"studenti.xml");
        ServiceStudent service = new ServiceStudent(repo);
        Student studentTwo = new Student ("446", "Szilard Veress", 937, "szili@gmail.com", "Ceva alt prfoesor ");

        service.add(studentTwo);
        Student returnStudentTwo = service.find("446");

        assertEquals(returnStudentTwo, studentTwo);
    }

    /*
    @Test
    public void test() {
        ServiceStudent service = initStudentService();
        Student student = new Student("", STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        service.add(student);
        Student returnedStudent = service.find(student.getID());
        assertEquals(returnedStudent, student);
    }
    */

    private ServiceStudent initStudentService() {
        StudentRepo repo = new StudentRepo(new StudentValidator(),"studenti.xml");
        return new ServiceStudent(repo);
    }

    private Student createBasicStudent() {
        return new Student(ID, STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
    }

    // ===============EQUIVALENCE CLASS TESTS===============

    @Test
    public void addValidStudent1() {
        ServiceStudent service = initStudentService();
        Student student = new Student("335", STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        service.add(student);
    }

    @Test
    public void addValidStudent1b() {
        ServiceStudent service = initStudentService();
        Student student = new Student("100", STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        service.add(student);
    }

    @Test
    public void addValidStudent1c() {
        ServiceStudent service = initStudentService();
        Student student = new Student("180", STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        service.add(student);
    }

    @Test
    public void addInvalidStudent3() {
        ServiceStudent service = initStudentService();
        Student student = new Student("", STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void addInvalidStudent4() {
        ServiceStudent service = initStudentService();
        Student student = new Student("dfvzxc", STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void addValidStudent2() {
        ServiceStudent service = initStudentService();
        Student student = new Student("324", STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        service.add(student);
    }

    @Test
    public void addValidStudent3() {
        ServiceStudent service = initStudentService();
        Student student = new Student(ID, STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        service.add(student);
    }

    @Test
    public void addInvalidStudent5() {
        ServiceStudent service = initStudentService();
        Student student = new Student(ID, STUDENT_NAME, GROUP_NUMBER, "gmail.com", PROFESOR_NAME);
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void addValidStudent4() {
        ServiceStudent service = initStudentService();
        Student student = new Student(ID, STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        service.add(student);
    }

    @Test
    public void addInvalidStudent6() {
        ServiceStudent service = initStudentService();
        Student student = new Student(ID, "T3455 bbr5", GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        assertThrows(ValidationException.class, () -> {
        service.add(student);
    });
    }

    @Test
    public void addValidStudent5() {
        ServiceStudent service = initStudentService();
        Student student = new Student(ID, STUDENT_NAME, GROUP_NUMBER, EMAIL, PROFESOR_NAME);
        service.add(student);
    }

    @Test
    public void addInvalidStudent7() {
        ServiceStudent service = initStudentService();
        Student student = new Student(ID, STUDENT_NAME, GROUP_NUMBER, EMAIL, "Ceva Profe$or");
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }


    // ===============BOUNDARY VALUE TESTS===============
    // BV1:
    @Test
    public void testGroupBoundaryValue1() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setGrupa(111);
        service.add(student);
    }

    @Test
    public void testGroupBoundaryValue2() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setGrupa(937);
        service.add(student);
    }

    @Test
    public void testGroupBoundaryValue3() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setGrupa(100);
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void testGroupBoundaryValue4() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setGrupa(948);
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void testGroupBoundaryValue5() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setGrupa(123);
        service.add(student);
    }

    //BV2:
    @Test
    public void testIDBoundaryValue1() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setID("0009");
        service.add(student);
    }

    @Test
    public void testIDBoundaryValue2() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setID("");
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void testIDBoundaryValue3() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setID(null);
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void testIDBoundaryValue4() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setID("-1");
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void testIDBoundaryValue5() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setID("sree");
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    //BV3:
    @Test
    public void testEmailBoundaryValue1() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setMail("teo@gmail.com");
        service.add(student);
    }

    @Test
    public void testEmailBoundaryValue2() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setMail("teo%gmail.com");
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void testEmailBoundaryValue3() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setMail("teo");
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    //BV4:
    @Test
    public void testNameBoundaryValue1() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setNume("124353");
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void testNameBoundaryValue2() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setNume("zA,-'");
        service.add(student);
    }

    @Test
    public void testNameBoundaryValue3() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setNume("azzZ");
        service.add(student);
    }

    @Test
    public void testNameBoundaryValue4() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setNume("a");
        service.add(student);
    }

    //BV5:
    @Test
    public void testProfessorBoundaryValue1() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setNume("124353");
        assertThrows(ValidationException.class, () -> {
            service.add(student);
        });
    }

    @Test
    public void testProfessorBoundaryValue2() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setNume("zA,-'");
        service.add(student);
    }

    @Test
    public void testProfessorBoundaryValue3() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setNume("azzZ");
        service.add(student);
    }

    @Test
    public void testProfessorBoundaryValue4() {
        ServiceStudent service = initStudentService();
        Student student = createBasicStudent();
        student.setNume("a");
        service.add(student);
    }
}
