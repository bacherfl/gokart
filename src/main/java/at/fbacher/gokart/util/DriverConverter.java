package at.fbacher.gokart.util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.model.Driver;

@Named
public class DriverConverter implements Converter {

	@Inject
	private List<Driver> drivers;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.trim().equals("")) {
			return null;
		} else {
			int id = Integer.parseInt(value);
			for (Driver driver : drivers) {
				if (driver.getId() == id)
					return driver;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Driver) value).getId());
        }
	}

}
