package whb.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import whb.domain.StudentBean;
import whb.service.StudentDaoService;
import whb.service.impl.StudentDaoSerciceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class GetPhotoAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, SessionAware {

	private Map session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String notAdminError;
	private int id;
	
	public void setSession(Map session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public String execute() throws Exception {
		notAdminError = "";
		request.setAttribute("notAdminError", notAdminError);
		if(session.get("admin")!=null){
			id = Integer.parseInt(request.getParameter("id"));
			StudentDaoService service = new StudentDaoSerciceImpl();
			StudentBean student = service.getStudentById(id);
			request.setAttribute("s", student);
			OutputStream out = response.getOutputStream();
			InputStream in = student.getPhoto();
			byte[] buf = new byte[1024];
			int temp = 0;
			while((temp=in.read(buf))!=-1){
				out.write(buf);
			}
			out.close();
			in.close();
			return SUCCESS;
		}
		notAdminError="并不是管理员省份，请重新登录！！";
		return "gotoIndex";
	}
}
