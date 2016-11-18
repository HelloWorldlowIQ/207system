package com.system.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import com.system.domain.Student;
import com.system.factory.BasicFactory;
import com.system.services.StudentService;

public class RegistServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		StudentService service = BasicFactory.getFactory().getInstance(StudentService.class);
		
		String valistr = request.getParameter("valistr");
		String valistr2 = (String) request.getSession().getAttribute("srand");
		if(valistr==null || valistr2==null ||!valistr.equals(valistr2)){
			request.setAttribute("msg", "��֤�벻��ȷ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//��֤�������Ϣ�����п�
		String str = request.getParameter("username");
		String str2 = request.getParameter("password");
		String str3 = request.getParameter("age");
		String str4 = request.getParameter("classes");
		String str5 = request.getParameter("number");
		String str6 = request.getParameter("course");
		if(str==null || str.equals("") || str2==null || str2.equals("") || str3==null || str3.equals("") || str4==null || str4.equals("") || str5==null || str5.equals("") || str6==null || str6.equals("") || str2.length()<6||str5.length()<6){
			request.setAttribute("msg", "��������ȷ����Ϣ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		try{
			/**
			 * ����û�
			 */
			Student student = new Student();
			BeanUtils.populate(student, request.getParameterMap());
			service.AddStudent(student);
			//��¼
			student = service.findUerName(student.getUsername());
			request.getSession().setAttribute("student", student);
			response.getWriter().write("��ϲ��ע��ɹ���3���ص���ҳ.....");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
