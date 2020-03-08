package listeners;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.PostLoad;
import model.Student;

public class AgeCalculationStudent {

    @PostLoad
    public void calulateAge(Student student) {
        student.setAge(Period.between(student.getDateofBirth(),
                LocalDate.now()).getYears());
    }

}
