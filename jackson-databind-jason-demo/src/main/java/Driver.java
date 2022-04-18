import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.json.demo.Address;
import com.jackson.json.demo.Student;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
//        create object mapper
        ObjectMapper objectMapper = new ObjectMapper();
//        read json file and map convert to java pojo7
        try {
            Student student = objectMapper.readValue(
                    new File("data/sample-full.json"), Student.class);
//                 print first name and last name
            System.out.println("First Name = " + student.getFirstName() + ", Last Name = " + student.getLastName());
//       print out address and city
            Address address = student.getAddress();
            System.out.println("street: " + address.getStreet());
            System.out.println("city: " + address.getCity());
//            print out languages
            System.out.println("languages: " + Arrays.toString(student.getLanguages()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
