package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/updt")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
      try{
          Long id=Long.parseLong(req.getParameter("id"));
          UserService.getInstance().updateUser(name,id);
          List<User> users=UserService.getInstance().getAllUsers();
          req.setAttribute("users",users);
          req.getRequestDispatcher("users.jsp").forward(req, resp);
      } catch (Exception e) {
          e.printStackTrace();
      }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            User user = UserService.getInstance().getUserById(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

