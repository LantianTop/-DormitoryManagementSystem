package whb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;
	private String password;
	private String username;
	private Map session;
	private HttpServletRequest request;
	private HttpServletResponse response;

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
	public String execute() {
		request.setAttribute("inputError", "");
		if ("admin".equals(username) && "123456".equals(password)) {
			session.put("admin", "admin");
			return SUCCESS;
		}
		request.setAttribute("inputError", " ‰»Î’Àªß√‹¬Î¥ÌŒÛ£°£°");
		return INPUT;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
