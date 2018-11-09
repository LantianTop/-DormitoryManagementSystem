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

public class SearchAction extends ActionSupport implements SessionAware,
ServletRequestAware{

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private Map session;
	private HttpServletRequest request;
	private String notAdminError;
	private int id;
	private String name;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String execute() throws Exception {
		notAdminError = "";
		request.setAttribute("notAdminError", notAdminError);
		if(session.get("admin")!=null){
			if("id".equals(type)){
				StudentDaoService service = new StudentDaoSerciceImpl();
				StudentBean s = service.getStudentById(id);
				if(s==null){
					request.setAttribute("tipMessage", "学号为"+id+"的学生并不存在！");
					return NONE;
				}
				request.setAttribute("s", s);
				return "searchId";
			}
			if("name".equals(type)){
				StudentDaoService service = new StudentDaoSerciceImpl();
				name = request.getParameter("name");
				System.out.println(name);
				List<StudentBean> list = service.getStudentByName(name);
				if(list==null || list.size()<1){
					request.setAttribute("tipMessage", "姓名为"+name+"的学生并不存在！");
					return NONE;
				}
				request.setAttribute("students", list);
				return "searchName";
			}
		}
		notAdminError="不是管理员省份，请重新登录！！";
		return "gotoIndex";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
