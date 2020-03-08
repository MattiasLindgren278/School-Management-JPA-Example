package utilities;

import java.io.Serializable;

public class StringFormatter implements Serializable {

    public String fixLengthString(String string, int length) {
        if (string.length() > length) {
            return string.substring(0, (length - 1));
        } else {
            while (string.length() < length) {
                string += " ";
            }
            return string;
        }
    }

    public String teacherHeader() {
        return fixLengthString("ID", 4) + fixLengthString("Firstname", 15) + fixLengthString("Lastname", 15) + fixLengthString("Dateofbirth", 12) + fixLengthString("Gender", 8) + fixLengthString("Age", 5);
    }

    public String studentHeader() {
        return fixLengthString("ID", 4) + fixLengthString("Firstname", 15) + fixLengthString("Lastname", 15) + fixLengthString("Dateofbirth", 12) + fixLengthString("Gender", 8) + fixLengthString("Age", 5);
    }

    public String educationHeader() {
        return fixLengthString("ID", 4) + fixLengthString("Name", 15) + fixLengthString("Startdate", 12) + fixLengthString("Enddate", 12);
    }
    
    public String courseHeader(){
        return fixLengthString("ID", 4) + fixLengthString("Name", 15);
    }
}
