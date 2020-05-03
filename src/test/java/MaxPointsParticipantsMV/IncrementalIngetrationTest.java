package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Nota;
import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Domain.Teme;
import MaxPointsParticipantsMV.Repository.NoteRepo;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Repository.TemeRepo;
import MaxPointsParticipantsMV.Service.ServiceNote;
import MaxPointsParticipantsMV.Service.ServiceStudent;
import MaxPointsParticipantsMV.Service.ServiceTeme;
import MaxPointsParticipantsMV.Validator.NotaValidator;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import MaxPointsParticipantsMV.Validator.TemeValidator;
import org.junit.Test;

import java.util.AbstractMap;

import static org.junit.Assert.assertEquals;

public class IncrementalIngetrationTest {
    @Test
    public void testAddStudent() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        ServiceStudent serviceStudent = new ServiceStudent(studentRepo);
        Student studentOne = new Student ("1", "Teodora Velicu", 937, "teo@gmail.com", "Ceva profesor");
        serviceStudent.add(studentOne);

        Student returnStudentOne = serviceStudent.find("1");
        assertEquals(returnStudentOne, studentOne);
    }

    @Test
    public void testAddStudentAndAssignment() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        ServiceStudent serviceStudent = new ServiceStudent(studentRepo);
        Student studentOne = new Student ("2", "Teodora Velicu", 937, "teo@gmail.com", "Ceva profesor");
        serviceStudent.add(studentOne);
        Student returnStudentOne = serviceStudent.find("2");


        TemeRepo temeRepo = new TemeRepo(new TemeValidator(), "teme.xml");
        ServiceTeme serviceTeme = new ServiceTeme(temeRepo);
        Teme tema = new Teme(10, "asta este o tema", 10, 12);
        Teme returnTema = serviceTeme.add(tema);


        assertEquals(studentOne, returnStudentOne);
        assertEquals(tema, returnTema);
    }

    @Test
    public void testAddStudentAndAssignmentAndGrade() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        ServiceStudent serviceStudent = new ServiceStudent(studentRepo);
        Student studentOne = new Student ("3", "Teodora Velicu", 937, "teo@gmail.com", "Ceva profesor");
        serviceStudent.add(studentOne);
        Student returnStudentOne = serviceStudent.find("3");


        TemeRepo temeRepo = new TemeRepo(new TemeValidator(), "teme.xml");
        ServiceTeme serviceTeme = new ServiceTeme(temeRepo);
        Teme tema = new Teme(11, "asta este o tema", 10, 12);
        Teme returnTema = serviceTeme.add(tema);

        NoteRepo noteRepo = new NoteRepo(new NotaValidator());
        ServiceNote serviceNote = new ServiceNote(noteRepo);
        Nota nota = new Nota(new AbstractMap.SimpleEntry<>("3", 11), studentOne, tema, (float) 9.5, 5);
        Nota returnedNota = serviceNote.add(nota, "fd1");

        assertEquals(studentOne, returnStudentOne);
        assertEquals(tema, returnTema);
        assertEquals(returnedNota, nota);
    }
}
