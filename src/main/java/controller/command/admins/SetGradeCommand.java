package controller.command.admins;

import controller.command.Command;
import controller.command.pagesCommand.SetGradeCommandPage;
import controller.validation.ValidationUtil;
import model.entity.Student;
import model.exception.WrongDataException;
import model.service.RatingService;
import model.service.StudentService;
import model.service.SubjectService;
import model.service.impl.RatingServiceImpl;
import model.service.impl.StudentServiceImpl;
import model.service.impl.SubjectServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.AttributesResourceManager;
import controller.command.util.PageResourseManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

import static controller.validation.InputValid.isGradeValid;

public class SetGradeCommand implements Command {
    RatingService ratingService = new RatingServiceImpl();
    SubjectService subjectService = new SubjectServiceImpl();
    ValidationUtil validationUtil = new ValidationUtil();
    StudentService studentService = new StudentServiceImpl();
    private Logger logger = Logger.getLogger(SetGradeCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {

            Integer studentId = Integer.valueOf(request.getParameter((AttributesResourceManager.getProperty("parameter.student.id"))));
            Optional<Integer> subject = Optional.ofNullable(Integer.parseInt(request.getParameter((AttributesResourceManager.getProperty("parameter.subject")))));

            request.setAttribute("databaseList", subjectService.findAll());
            Optional<Integer> grade = Optional.ofNullable(Integer.parseInt(request.getParameter((AttributesResourceManager.getProperty("parameter.grade")))));
            Student student = studentService.findById(studentId);
            studentService.setMarks(student);
            if (Objects.isNull(studentId) && Objects.isNull(subject) || !validationUtil.userExistId(studentId) || !isGradeValid(grade.get())) {
                throw new WrongDataException();
            } else {
                ratingService.setmark(studentId, subject.get(), grade.get());

            }


        } catch (WrongDataException e) {
            request.setAttribute("userExist", true);
            logger.info("User Exist ",e);
            return new SetGradeCommandPage().execute(request, response);
        }

        return PageResourseManager.getProperty("redirect.admin.studentlist");
    }
}