package net.sytes.joaojunior.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.sytes.joaojunior.dao.SedeDao;
import net.sytes.joaojunior.model.Sede;

@FacesConverter(forClass=Sede.class,value = "sedeConverter")
public class SedeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) return null;
		Long id = Long.valueOf(value);
		System.out.println("getAsObject:" + value);
		SedeDao dao = new SedeDao();
		Sede sede = dao.getById(id);
		return sede;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		Sede sede = (Sede) value;
		System.out.println("getAsString" + sede.getDiretor());
		if (sede == null || sede.getId() == null) return null;
		return null;
	}

}
