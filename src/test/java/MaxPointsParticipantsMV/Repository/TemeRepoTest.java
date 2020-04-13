package MaxPointsParticipantsMV.Repository;

import MaxPointsParticipantsMV.Domain.Teme;
import MaxPointsParticipantsMV.Validator.TemeValidator;
import MaxPointsParticipantsMV.Validator.ValidationException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemeRepoTest {

    @Test
    public void saveAssignmentNoException() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(1, "asta este o tema", 10, 11);
        repo.save(tema);
    }

    @Test
    public void saveAssignmentException() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(1, "asta este o tema", 10, 15);
        assertThrows(ValidationException.class, () -> {
            repo.save(tema);;
        });
    }

    // FOR WBT:
    @Test
    public void saveAssignmentBadID1() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(-1, "asta este o tema", 10, 12);
        assertThrows(ValidationException.class, () -> {
            repo.save(tema);;
        });
    }

    @Test
    public void saveAssignmentBadID2() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(null, "asta este o tema", 10, 12);
        assertThrows(ValidationException.class, () -> {
            repo.save(tema);;
        });
    }

    @Test
    public void saveAssignmentBadDeadline1() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(1, "asta este o tema", 10, 20);
        assertThrows(ValidationException.class, () -> {
            repo.save(tema);;
        });
    }

    @Test
    public void saveAssignmentBadDeadline2() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(1, "asta este o tema", 10, 0);
        assertThrows(ValidationException.class, () -> {
            repo.save(tema);;
        });
    }

    @Test
    public void saveAssignmentBadDeadline3() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(1, "asta este o tema", 10, 8);
        assertThrows(ValidationException.class, () -> {
            repo.save(tema);;
        });
    }

    @Test
    public void saveAssignmentBadSaptamanaDePrimireIGuess1() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(1, "asta este o tema", 20, 12);
        assertThrows(ValidationException.class, () -> {
            repo.save(tema);;
        });
    }

    @Test
    public void saveAssignmentBadSaptamanaDePrimireIGuess2() {
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");
        Teme tema = new Teme(1, "asta este o tema", -1, 12);
        assertThrows(ValidationException.class, () -> {
            repo.save(tema);;
        });
    }
}
