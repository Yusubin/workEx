package project06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fileDownload
 */
@WebServlet("/fileDownload")
public class fileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandler(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandler(request, response);
	}
	
	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String file_repo="c:\\file_repo";
		String fileName=(String)request.getParameter("fileName");
		OutputStream out =response.getOutputStream();
		String downFile=file_repo+"\\"+fileName;
		File f= new File(downFile);
		response.setHeader("Cache-Control","no-cache");
//		response.addHeader("Content-Disposition","attachement; filename="+fileName);
		
		fileName=URLEncoder.encode(fileName,"UTF-8");
		fileName=fileName.replaceAll("\\+","%20" );
		response.addHeader("Content-Disposition","attachement; filename=\""+fileName+"\"");
		
		
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count=in.read(buffer);
			if(count==-1) {
				break;
			}
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}

}