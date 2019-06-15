package controller.command.admins;

import controller.command.Command;
import controller.command.pagesCommand.SetGradeCommandPage;
import controller.validation.ValidationUtil;
import model.exception.WrongDataException;
import model.service.RatingService;
import model.service.SubjectService;
import model.service.impl.RatingServiceImpl;
import model.service.impl.SubjectServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.AttributesResourceManager;
import controller.command.util.PageResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

import static controller.validation.InputValid.isGradeValid;

public class SetGradeCommand implements Command {
    RatingService ratingService = new RatingServiceImpl();
    SubjectService subjectService = new SubjectServiceImpl();
    ValidationUtil validationUtil = new ValidationUtil();
    private Logger logger = Logger.getLogger(SetGradeCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {

            String email = request.getParameter((AttributesResourceManager.getProperty("parameter.email")));
            Optional<Integer> subject = Optional.ofNullable(Integer.parseInt(request.getParameter((AttributesResourceManager.getProperty("parameter.subject")))));

            request.setAttribute("databaseList", subjectService.findAll());
            Optional<Integer> grade = Optional.ofNullable(Integer.parseInt(request.getParameter((AttributesResourceManager.getProperty("parameter.grade")))));

            if (Objects.isNull(email) && Objects.isNull(subject) || !validationUtil.userExist(email) || !isGradeValid(grade.get())) {
                throw new WrongDataException();
            } else {
                ratingService.setmark(email, subject.get(), grade.get());

            }


        } catch (WrongDataException e) {
            request.setAttribute("userExist", true);
            logger.info("User Exist ", e);
            return new SetGradeCommandPage().execute(request, response);
        }

        return PageResourceManager.getProperty("redirect.admin.setGrade");
    }
}