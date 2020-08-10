package net.sytes.joaojunior.bean;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class SemanaBean {

	public SemanaBean() {
		// TODO Auto-generated constructor stub
	}
	public static void populateBean(Object formBean, HttpServletRequest request) {
		//System.out.println(request);
		//System.out.println(request.getParameterMap());
		populateBean(formBean, request.getParameterMap());
	}
	
	public static void populateBean(Object bean, Map propertyMap) {
		try {
			BeanUtils.populate(bean,propertyMap);		
		}catch (Exception e) {
			System.out.println("Erro ao popular bean: "+e);
		}
	}
	
}
