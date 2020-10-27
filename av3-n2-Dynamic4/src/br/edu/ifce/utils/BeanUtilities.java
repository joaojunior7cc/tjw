package br.edu.ifce.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilities {
	public static void populateBean(Object formBean, HttpServletRequest request) {
		populateBean(formBean,request.getParameterMap());
	}

	private static void populateBean(Object bean, Map prop) {
		try {
			BeanUtils.populate(bean,prop);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
