package listeners;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.PostLoad;
import model.Teacher;

public class AgeCalculationTeacher {

    @PostLoad
    public void calulateAge(Teacher teacher) {
        teacher.setAge(Period.between(teacher.getDateofBirth(),
                LocalDate.now()).getYears());
    }
}
