package school.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import school.entity.Students;


@WebServlet("/display")
public class Display extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentsService service=new StudentsService();
		
		List<Students>list=service.fetchAll();
		
		PrintWriter writer=resp.getWriter();
		

		writer.print(" <div>\r\n"
				+ "        <form action=\"index.jsp\">\r\n"
				+ "            <input type=\"submit\" value=\"HOME\">\r\n"
				+ "        </form>"
				+ "    </div>\r\n"
				+ "    <table style=\"margin:auto ; border: 2px solid black; border-collapse: collapse; \" cellpadding=\"15px\"cellspacing=\"15px\" >\r\n"
				+ "        <thead>\r\n"
				+ "            <tr style=\"color: red;background-color: aqua;\">\r\n"
				+ "                <th style=\"border: 2px solid black;\">ID</th>\r\n"
				+ "                <th style=\"border: 2px solid black;\">NAME</th>\r\n"
				+ "                <th style=\"border: 2px solid black;\">AGE</th>\r\n"
				+ "                <th style=\"border: 2px solid black;\">ACTION</th>\r\n"
				+ "            </tr>\r\n"
				+ "        </thead>\r\n"
				+ "        <tbody>");
		
		
			for (Students s : list) {
				
					writer.print(" <tr>\r\n"
							+ "                <td style=\"border: 2px solid black;\">"+s.getId()+"</td>\r\n"
							+ "                <td style=\"border: 2px solid black;\">"+s.getName()+"</td>\r\n"
							+ "                <td style=\"border: 2px solid black;\">"+s.getAge()+"</td>\r\n"
							+ "                <td style=\"border: 2px solid black;\">\r\n"
							+ "                    <form action=\"edit.jsp\" method=\"get\">\r\n"
							+ "  <input type='hidden' name='id' value='"+s.getId()+"'>"
//						    + "  <input type='hidden' name='name' value='"+s.getName()+"'>"
//						    + "  <input type='hidden' name='age' value='"+s.getAge()+"'>"
							+ "                        <input type=\"submit\" value=\"Edit\">\r\n"
							+ "                    </form>\r\n"
							+ "                    <form action=\"delete\" method=\"get\">\r\n"
							+ "  <input type='hidden' name='id' value='"+s.getId()+"'>"
							+ "                        <input type=\"submit\" value=\"Delete\">\r\n"
							+ "                    </form>\r\n"
							+ "                </td>\r\n"
							+ "            </tr>\r\n");				

			}
			writer.print("</tbody>\r\n"
					+ "    </table>");
	}
}
