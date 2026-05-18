package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MajorBean;
import repository.MajorRepository;

/**
 * Servlet implementation class MajorDeleteServlet
 */
@WebServlet("/major-delete")
public class MajorDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")!=null){
			int id= Integer.parseInt(request.getParameter("id"));
			MajorRepository mRepo =new MajorRepository();
			int i =mRepo.deleteMajor(id);
			if(i==0) {
			//	response.sendRedirect("major-list");
				request.setAttribute("error", "delete fail");
			}
			else {
				request.getRequestDispatcher("major-list").forward(request, response);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
