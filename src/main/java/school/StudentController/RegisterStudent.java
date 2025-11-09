package school.StudentController;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import school.entity.Students;
import school.service.StudentsService;

@WebServlet("/register")
public class RegisterStudent extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		
		System.out.println(id+" "+name+" "+age);
		
		Students students=new Students();
		students.setId(id);
		students.setName(name);
		students.setAge(age);
		
		StudentsService service=new StudentsService();
		int save=service.save(students);
		if(save!=0) {
			System.out.println("data saved");
			RequestDispatcher requestDispatcher =req.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
