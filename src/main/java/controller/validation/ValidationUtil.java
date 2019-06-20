package controller.validation;

import model.entity.Student;
import model.exception.WrongDataException;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;

import java.util.Optional;

public class ValidationUtil {

    public boolean verification(String email, String nameUa, String surnameUa, String nameEn, String surnameEn) throws WrongDataException {
        return InputValid.isUkrainianValid(nameUa) &&
                InputValid.isUkrainianValid(surnameUa) &&
                InputValid.isEnglishValid(nameEn) &&
                InputValid.isEnglishValid(surnameEn) &&
                InputValid.isEmailValid(email);


    }

    public boolean userExist(String email) {
        StudentService studentService = new StudentServiceImpl();
        Optional<Student> student = Optional.ofNullable(studentService.findByEmail(email));
        return student.isPresent();
    }

    public boolean userExistId(int studentId) {
        StudentService studentService = new StudentServiceImpl();
        Optional<Student> student = Optional.ofNullable(studentService.findById(studentId));
        return student.isPresent();
    }
}
