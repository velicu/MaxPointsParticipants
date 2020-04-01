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
}
