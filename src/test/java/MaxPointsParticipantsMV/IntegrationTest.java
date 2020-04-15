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

public class IntegrationTest {

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
    public void testAddAssignment() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(), "teme.xml");
        ServiceTeme serviceTeme = new ServiceTeme(temeRepo);
        Teme tema = new Teme(2, "asta este o tema", 10, 11);
        serviceTeme.add(tema);

        Teme returnedTema = serviceTeme.find(2);
        assertEquals(returnedTema, tema);
    }

    @Test
    public void testAddGrade() {
        NoteRepo noteRepo = new NoteRepo(new NotaValidator());
        ServiceNote serviceNote = new ServiceNote(noteRepo);
        Student student = new Student ("1", "Teodora Velicu", 937, "teo@gmail.com", "Ceva profesor");
        Teme tema = new Teme(2, "asta este o tema", 10, 11);
        Nota nota = new Nota(new AbstractMap.SimpleEntry<>("1", 2), student, tema, (float) 9.5, 5);
        Nota returnedNota = serviceNote.add(nota, "1234");

        // assertEquals(returnedNota, nota);
    }

    @Test
    public void integrationTest1() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        ServiceStudent serviceStudent = new ServiceStudent(studentRepo);
        Student student = new Student ("1", "Teodora Velicu", 937, "teo@gmail.com", "Ceva profesor");
        serviceStudent.add(student);

        TemeRepo temeRepo = new TemeRepo(new TemeValidator(), "teme.xml");
        ServiceTeme serviceTeme = new ServiceTeme(temeRepo);
        Teme tema = new Teme(2, "asta este o tema", 10, 11);
        serviceTeme.add(tema);

        NoteRepo noteRepo = new NoteRepo(new NotaValidator());
        ServiceNote serviceNote = new ServiceNote(noteRepo);
        Nota nota = new Nota(new AbstractMap.SimpleEntry<>("1", 2), student, tema, (float) 9.5, 5);
        Nota returnedNota = serviceNote.add(nota, "1234");

        Student returnStudentOne = serviceStudent.find("1");
        assertEquals(returnStudentOne, student);

        Teme returnedTema = serviceTeme.find(2);
        assertEquals(returnedTema, tema);
    }
}
