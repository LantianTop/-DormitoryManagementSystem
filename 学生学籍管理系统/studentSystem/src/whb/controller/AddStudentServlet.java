package whb.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import whb.domain.StudentBean;
import whb.form.StudentInfoForm;
import whb.service.StudentDaoService;
import whb.service.impl.StudentDaoSerciceImpl;
import whb.util.BeanUtil;

import com.opensymphony.xwork2.ActionSupport;

public class AddStudentServlet extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentInfoForm s ;
	private File photo ;
	private String photoFileName; //�ļ�����    
	private String photoContentType; //�ļ�����
	private Map session;
	private HttpServletRequest request;
	private HttpServletResponse response;

	private String existError;
	private String notAdminError;
	
	@Override
	public String execute(){
		existError = "";
		notAdminError = "";
		request.setAttribute("existError", existError);
		request.setAttribute("notAdminError", notAdminError);
		if(session.get("admin")!=null){
			StudentDaoService service = new StudentDaoSerciceImpl();
			StudentBean student = new StudentBean();
			BeanUtil.copyBean(student, s, photo);
			service.addStudent(student);
			request.setAttribute("tipMessage", "���"+s.getName()+"ѧ����Ϣ�ɹ���");
			return SUCCESS;
		}
		notAdminError="�����ǹ���Աʡ�ݣ������µ�¼����";
		return "gotoIndex";
	}
	
	
	
	
	public void setSession(Map session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public StudentInfoForm getS() {
		return s;
	}
	public void setS(StudentInfoForm s) {
		this.s = s;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
}
