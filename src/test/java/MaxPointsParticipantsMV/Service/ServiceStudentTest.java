package MaxPointsParticipantsMV.Service;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceStudentTest {

    @Test
    public void addStudentOne() {
        StudentRepo repo = new StudentRepo(new StudentValidator(),"D:\\vvsss1\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.txt");
        ServiceStudent service = new ServiceStudent(repo);
        Student studentOne = new Student ("445", "Teodora Velicu", 937, "teo@gmail.com", "Ceva profesor");

        Student returnStudentONe = service.add(studentOne);

        assertEquals(returnStudentONe, studentOne);
    }

    @Test
    public void addStudentTwo() {
        StudentRepo repo = new StudentRepo(new StudentValidator(),"D:\\vvsss1\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.txt");
        ServiceStudent service = new ServiceStudent(repo);
        Student studentTwo = new Student ("446", "Szilard Veress", 937, "szili@gmail.com", "Ceva alt prfoesor ");

        Student returnStudentTwo = service.add(studentTwo);

        assertEquals(returnStudentTwo, studentTwo);
    }
}
