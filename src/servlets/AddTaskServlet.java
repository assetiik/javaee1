package servlets;

import db.Tasks;
import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-task")
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("task_name");
        String description = request.getParameter("task_description");
        String deadlineDate = request.getParameter("task_deadlineDate");

        Tasks tasks = new Tasks();
        tasks.setName(name);
        tasks.setDescription(description);
        tasks.setDeadlineDate(deadlineDate);
        DBManager.addTasks(tasks);

        response.sendRedirect("/");

    }
}
