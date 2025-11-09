package school.StudentController;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import school.entity.Students;
import school.service.StudentsService;

@WebServlet("/edit")
public class EditStudent extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		
		Students student=new Students(id,name,age);
		
		StudentsService service=new StudentsService();
		int res=service.edit(student);
		
		
		if(res!=0) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			PrintWriter writer=resp.getWriter();
			writer.print("Data not Found");
		}
	}
}
