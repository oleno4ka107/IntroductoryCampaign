package controller.command;

import controller.command.pagesCommand.RegistrationCommandPage;
import controller.command.util.CommandUtil;
import controller.validation.ValidationUtil;
import model.entity.Student;
import model.entity.types.Role;
import model.exception.UserExistException;
import model.exception.WrongDataException;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.AttributesResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentService studentService = new StudentServiceImpl();
        ValidationUtil validationUtil = new ValidationUtil();
        try {
            String email = request.getParameter(AttributesResourceManager.getProperty("parameter.email"));
            String password = request.getParameter(AttributesResourceManager.getProperty("parameter.password"));

            String nameUa = request.getParameter(AttributesResourceManager.getProperty("parameter.name.ua"));
            String surnameUa = request.getParameter(AttributesResourceManager.getProperty("parameter.surname.ua"));
            String nameEn = request.getParameter(AttributesResourceManager.getProperty("parameter.name.en"));
            String surnameEn = request.getParameter(AttributesResourceManager.getProperty("parameter.surname.en"));
            Integer role = Role.ABITURIENT.getRole();
            if (!validationUtil.verifiable(email, nameUa, surnameUa, nameEn, surnameEn)) {
                throw new WrongDataException();
            }
            if (validationUtil.userExist(email)) {
                throw new UserExistException();
            }
            Student student = new Student(nameUa, surnameUa, nameEn, surnameEn, email, password, role);
            studentService.create(student);
            CommandUtil.getUserPageByRole(student.getRole());
        } catch (WrongDataException e) {
            logger.error(e);
            request.setAttribute("registrationError", true);

        } catch (UserExistException e) {
            logger.error(e);
            request.setAttribute("userExist", true);

        }
        return new RegistrationCommandPage().execute(request, response);
    }
}