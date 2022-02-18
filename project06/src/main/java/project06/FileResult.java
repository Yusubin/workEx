package project06;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileResult
 */
@WebServlet("/FileResult")
public class FileResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File files = new File("c:\\file_repo");
		File arrayfiles[]=files.listFiles();
		ArrayList<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		for(File fname:arrayfiles) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("filename", fname.getName());
			list.add(map);
			
		}
		request.setAttribute("file_list", list);
		RequestDispatcher dispatch =request.getRequestDispatcher("/result.jsp");
		dispatch.forward(request, response);
	
	}

}
