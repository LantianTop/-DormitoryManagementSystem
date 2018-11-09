package whb.controller;

import java.util.List;
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

public class ListAction extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware{
	private Map session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String notAdminError;
	
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
			StudentDaoService service = new StudentDaoSerciceImpl();
			List<StudentBean> list = service.getAllStudents();
			request.setAttribute("students", list);
			return SUCCESS;
		}
		notAdminError="并不是管理员省份，请重新登录！！";
		return "gotoIndex";
	}
}
