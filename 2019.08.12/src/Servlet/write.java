package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.DAO;
import DBPKG.DTO;

/**
 * Servlet implementation class write
 */
@WebServlet("/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    DAO dao = DAO.getInstance();
	    int stubun = Integer.parseInt(request.getParameter("stubun"));	
	    System.out.println(request.getParameter("stubun"));
	    int row = dao.write(stubun);
	    List<DTO> list = new ArrayList<DTO>();
	    
	    if(row != 0) {
	    	
	    	RequestDispatcher rd = request.getRequestDispatcher("write.jsp");
	    	rd.forward(request, response);
	    }
	    
	}

}
