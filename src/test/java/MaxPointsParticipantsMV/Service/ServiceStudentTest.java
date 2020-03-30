package MaxPointsParticipantsMV.Service;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceStudentTest {

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
}
