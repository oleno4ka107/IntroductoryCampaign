package controller.validation;

import model.entity.Student;
import model.exception.UserExistException;
import model.exception.WrongDataException;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;

import java.util.Optional;

public class ValidationUtil {

    public boolean verifiable(String email, String nameUa, String surnameUa, String nameEn, String surnameEn) throws WrongDataException {
        return InputValid.isUkraininanValid(nameUa) &&
                InputValid.isUkraininanValid(surnameUa) &&
                InputValid.isEnglishValid(nameEn) &&
                InputValid.isEnglishValid(surnameEn) &&
                InputValid.isEmailValid(email);


    }

    public boolean userExist(String email) {
        StudentService studentService = new StudentServiceImpl();
        Optional<Student> student = Optional.ofNullable(studentService.findByEmail(email));
        return student.isPresent();
    }

}
