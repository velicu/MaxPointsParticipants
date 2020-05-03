package MaxPointsParticipantsMV.Repository;

import MaxPointsParticipantsMV.Domain.Nota;
import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Domain.Teme;
import MaxPointsParticipantsMV.Validator.NotaValidator;
import MaxPointsParticipantsMV.Validator.TemeValidator;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GradeRepoTest {
    @Test
    public void testAddGrade() {
        NoteRepo repo = new NoteRepo(new NotaValidator());
        Student student = new Student("1", "Teodora Velicu", 937, "teo@gmail.com", "Ceva profesor");
        Teme tema = new Teme(2, "asta este o tema", 10, 11);
        Nota nota = new Nota(new AbstractMap.SimpleEntry<>("1", 2), student, tema, (float) 9.5, 5);
        Nota returnedNota = repo.save(nota);
        assertEquals(returnedNota, nota);
    }
}
