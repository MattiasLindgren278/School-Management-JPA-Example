package utilities;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InputAssistance {

    private Scanner sc = new Scanner(System.in);
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public int intMenuInput(int min, int max, int input) {
        boolean loop = true;
        while (loop) {
            if (input < min || input > max) {
                System.out.println("Illegal input, please try again. Numbers between " + min + " and " + max + " only.");
                input = InputAssistance.this.intMenuInput();
            } else {
                loop = false;
            }
        }
        return input;
    }

    public int intMenuInput() {
        int inputReturn = -1;
        boolean loop = true;
        while (loop) {
            System.out.print("Enter input: ");
            String input = sc.nextLine();
            boolean checker = numberValidator(input);
            if (checker) {
                inputReturn = Integer.parseInt(input);
                loop = false;
            } else {
                System.out.println("Illegal input, please try again.");
            }
        }

        return inputReturn;
    }

    public int intInput() {
        int inputReturn = -1;
        boolean loop = true;
        while (loop) {
            String input = sc.nextLine();
            boolean checker = numberValidator(input);
            if (checker) {
                inputReturn = Integer.parseInt(input);
                loop = false;
            } else {
                System.out.println("Illegal input, please try again.");
            }
        }

        return inputReturn;
    }

    public boolean numberValidator(String input) {
        if (input == null) {
            return false;
        }
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public LocalDate localDateInput(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        boolean loop = localDateChecker(date);
        while (!loop) {
            System.out.println("Date need to be entered as 'yyyy-mm-dd', try again");
            System.out.print("Enter input: ");
            date = stringInput();
            loop = localDateChecker(date);
        }
        return LocalDate.parse(date, formatter);
    }

    public boolean localDateChecker(String date) {
        if (date == null) {
            return false;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }

    }

    public String stringInput() {
        String input = sc.nextLine();
        return input;
    }
    public String stringInputConsole() {
        System.out.print("Enter name: ");
        String input = sc.nextLine();
        return input;
    }

    public String percantageConverter(double number) {
        DecimalFormat df = new DecimalFormat("#%");
        String percentage = df.format(number);
        return percentage;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public Scanner getScanner() {
        return sc;
    }

}
