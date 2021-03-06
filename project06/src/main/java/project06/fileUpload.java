package project06;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class fileUpload
 */
@WebServlet("/upload")
public class fileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}
	
	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		File currentDirPath=new File("c:\\file_repo");
		
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		try {
			List items = upload.parseRequest(request);
			
			for(int i=0; i<items.size();i++) {
				FileItem fileItem=(FileItem)items.get(i);
				
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
				}else {
					System.out.println("파라미터 명:"+fileItem.getFieldName());
					System.out.println("파일 명:"+fileItem.getFieldName());
					System.out.println("파일크기:"+fileItem.getSize()+"bytes");
					System.out.println("첨부파일타입:"+fileItem.getContentType()+"bytes");		
					System.out.println(fileItem.getName().lastIndexOf("\\"));
					System.out.println(fileItem.getName()+" ");
					if(fileItem.getSize()>0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx = fileItem.getName().lastIndexOf("\\");
							fileItem.getName().indexOf("\\");
							
						}
							String fileName=fileItem.getName().substring(idx+1);
							System.out.println("filename:"+fileName);
							File uploadFile = new File(currentDirPath+"\\"+fileName);
							
							if(uploadFile.exists()) {
								int fileName_idx=fileName.lastIndexOf(".");
								SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
								Calendar c=Calendar.getInstance();
								String strToday=sdf.format(c.getTime());
								String new_fileName=fileName.substring(0,fileName_idx)+"_"+strToday+fileName.substring(fileName_idx);
								
								File uploadFile_new = new File(currentDirPath+"\\"+new_fileName);
								fileItem.write(uploadFile_new);
							}else {
								fileItem.write(uploadFile);
								
							}
							
							
							
						}
					
					}
				}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		response.sendRedirect(request.getContextPath()+"/FileResult");
	}

}
