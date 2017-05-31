package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.SearchUser;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// 获取servletPath，判断调用那个方法，并利用反射调用该方法
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getServletPath();
		String methodName = path.substring(1, path.length() - 3);
		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 通过在请求后面添加参数method判断想要调用哪个方法 缺点：添加新方法时，较为麻烦，不易扩展。

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String method =
	 * request.getParameter("method"); switch (method) { case "add":
	 * add(request, response); break; case "query": query(request, response);
	 * break; case "delete": delete(request, response); break; default:
	 * response.sendRedirect("error.jsp"); } }
	 */

	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id");
		int id = 0;
		if (idStr != null && !"".equals(idStr)) {
			try {
				id = Integer.parseInt(idStr);
				userService.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("query.do");
	}

	@SuppressWarnings("unused")
	private void query(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		SearchUser searchUser = new SearchUser(name, email);
		List<User> users = null;
		try {
			users = userService.selectUsers(searchUser);
			request.setAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/index.jsp").forward(request,
				response);

	}

	@SuppressWarnings("unused")
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		try {
			long num = userService.selectByName(name);
			if (num > 0) {
				request.setAttribute("message", "用户名" + name + "已存在！");
				request.getRequestDispatcher("/add.jsp").forward(request,
						response);
				return;
			} else {
				User user = new User(name, email, birth);
				userService.insert(user);
				response.sendRedirect("query.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void preUpdate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "/error.jsp";
		try {
			User user = userService.selectById(id);
			if (user != null) {
				request.setAttribute("user", user);
				path = "/update.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	@SuppressWarnings("unused")
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String oldName = request.getParameter("oldName");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		User user = new User(id, oldName, email, birth);
		if (name.equalsIgnoreCase(oldName)) {
			try {
				userService.update(user);
				response.sendRedirect("query.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			long num = userService.selectByName(name);
			if (num > 0) {
				request.setAttribute("message", "用户名" + name + "已存在！");
				request.setAttribute("user", user);
				request.getRequestDispatcher("/update.jsp").forward(request,
						response);
				return;
			}
		}
	}

}
