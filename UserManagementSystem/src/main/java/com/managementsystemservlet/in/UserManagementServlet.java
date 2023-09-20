package com.managementsystemservlet.in;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.managementmodel.in.UserManagementModel;
import com.usermanagementdao.in.UserManagementDao;

@WebServlet("/")
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		switch(path)
		{
			case "/Add":newUserManagement(request, response);
			break;
			case "/Insert":insertUserManagement(request, response);
			break;
			case "/Delete":deleteUserManagement(request, response);
			break;
			case "/Edit":editUserManagement(request, response);
			break;
			case "/Update":updateUserManagement(request, response);
			break;
			default:usermanagementlist(request, response);
			break;
		}
	}

	private void updateUserManagement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		UserManagementModel ums=new UserManagementModel(id, name, email, city);
		UserManagementDao.update(ums);
		RequestDispatcher rd = request.getRequestDispatcher("UserList");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void editUserManagement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		UserManagementModel ums=UserManagementDao.edit(id);
		request.setAttribute("usermanagementlist", ums);
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void deleteUserManagement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		UserManagementDao.delete(id);
		try {
			response.sendRedirect("usermanagementlist");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertUserManagement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		UserManagementModel ums = new UserManagementModel(name, email, city);
		
		UserManagementDao.insert(ums);
		
		try {
			response.sendRedirect("usermanagementlist");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void newUserManagement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void usermanagementlist(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<UserManagementModel> al=UserManagementDao.display();
		request.setAttribute("display", al);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
