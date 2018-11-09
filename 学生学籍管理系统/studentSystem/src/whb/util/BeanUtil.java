package whb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import whb.domain.StudentBean;
import whb.form.StudentInfoForm;

public class BeanUtil {
	public static void copyBean(StudentBean s,StudentInfoForm form ,File photo){
		s.setBirthday(form.getBirthday());
		s.setCity(form.getCity());
		s.setDeleted(form.isDeleted());
		s.setGender(form.getGender());
		s.setLeagueMember(form.isLeagueMember());
		s.setName(form.getName());
		s.setProvince(form.getProvince());
		s.setNation(form.getNation());
		
		if(photo!=null){
			try {
				s.setPhoto(new FileInputStream(photo));
			} catch (FileNotFoundException e) {
				throw new RuntimeException("’’∆¨≤ª¥Ê‘⁄£°£°");
			}
		}else
			s.setPhoto(null);
	}
}
