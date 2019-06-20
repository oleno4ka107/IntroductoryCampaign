package controller.command.admins;

import controller.command.Command;
import controller.command.util.AttributesResourceManager;
import controller.command.util.PageResourseManager;
import controller.validation.ValidationUtil;
import model.entity.Student;
import model.exception.UserExistException;
import model.exception.WrongDataException;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyStudentCommand implements Command {
    private Logger logger = Logger.getLogger(DeleteStudentCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentService studentService = new StudentServiceImpl();
        ValidationUtil validationUtil = new ValidationUtil();
        Integer studentId = Integer.valueOf(request.getParameter((AttributesResourceManager.getProperty("parameter.student.id"))));

        try {
            String email = request.getParameter(AttributesResourceManager.getProperty("parameter.email"));
            String nameUa = request.getParameter(AttributesResourceManager.getProperty("parameter.name.ua"));
            String surnameUa = request.getParameter(AttributesResourceManager.getProperty("parameter.surname.ua"));
            String nameEn = request.getParameter(AttributesResourceManager.getProperty("parameter.name.en"));
            String surnameEn = request.getParameter(AttributesResourceManager.getProperty("parameter.surname.en"));

            if (!validationUtil.verification(email, nameUa, surnameUa, nameEn, surnameEn)) {
                throw new WrongDataException();
            }
            if (validationUtil.userExist(email)) {
                throw new UserExistException();
            }
            Student student = studentService.findById(studentId);
            student.setNameUa(nameUa);
            student.setSurnameUa(surnameUa);
            student.setNameEn(nameEn);
            student.setSurnameEn(surnameEn);
            student.setEmail(email);
            studentService.update(student);
            return PageResourseManager.getProperty("redirect.admin.studentlist");
        } catch (WrongDataException e) {
            logger.error(e);
            request.setAttribute("modifyError", true);

        } catch (UserExistException e) {
            logger.error(e);
            request.setAttribute("userExist", true);

        }
        return new ModifyStudentCommand().execute(request, response);
    }
}
