package controller.command.students;

import controller.command.Command;
import model.entity.Student;
import org.apache.log4j.Logger;
import controller.command.util.AttributesResourceManager;
import controller.command.util.PageResourseManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentPageCommand implements Command {
    Logger logger = Logger.getLogger(StudentPageCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Student student = (Student) request.getSession().getAttribute(AttributesResourceManager.getProperty("parameter.user"));
            request.setAttribute(AttributesResourceManager.getProperty("parameter.student.specialty"),student.getSpecialty_id());
            request.setAttribute(AttributesResourceManager.getProperty("parameter.name.ua"),student.getNameUa());
            request.setAttribute(AttributesResourceManager.getProperty("parameter.surname.ua"),student.getSurnameUa());
            request.setAttribute(AttributesResourceManager.getProperty("parameter.name.en"),student.getNameEn());
            request.setAttribute(AttributesResourceManager.getProperty("parameter.surname.en"),student.getSurnameEn());
            request.setAttribute(AttributesResourceManager.getProperty("parameter.email"),student.getEmail());


logger.info("execute");
            return PageResourseManager.getProperty("studentpage");
        }




       }

