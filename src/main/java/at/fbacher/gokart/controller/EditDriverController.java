package at.fbacher.gokart.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.binary.Hex;
import org.primefaces.event.FileUploadEvent;

import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.model.UserRole;
import at.fbacher.gokart.services.IDriverService;
import at.fbacher.gokart.services.IUserRoleService;

@SessionScoped
@Named
public class EditDriverController implements Serializable {

	public enum Mode {
		EDIT, ADD
	};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2990109784280885969L;
	private Driver driver;
	@Inject
	private IDriverService driverService;
	@Inject
	private IUserRoleService userRoleService;
	private Mode mode;
	
	public EditDriverController() {

	}

	public void setDriverToEdit(Mode mode) {
		setDriverToEdit(mode, new Driver());
	}
	
	public void setDriverToEdit(Mode mode, Driver driver) {
		this.driver = driver;
		setMode(mode);
	}
	
	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public String doSave() {
		if (mode == Mode.ADD) {
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				md.update(driver.getPassword().getBytes("UTF-8")); // Change this to "UTF-16" if needed
				byte[] digest = md.digest();
				driver.setPassword(Hex.encodeHexString(digest));
				driverService.addDriver(driver);
				
				UserRole userRole = new UserRole();
				userRole.setEmail(driver.getEmail());
				userRole.setRole("driver");
				userRoleService.addUserRole(userRole);
				if (driver.isAdmin()) {
					userRole = new UserRole();
					userRole.setEmail(driver.getEmail());
					userRole.setRole("admin");
					userRoleService.addUserRole(userRole);
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			driverService.updateDriver(driver);
		}
		return Pages.ADMIN_HOME;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTitle() {
		if (mode == Mode.ADD) {
			return "Add a new driver";
		} else {
			return "Edit Driver";
		}
	}
	
	public void uploadPhoto(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            driver.setPhotoUrl(event.getFile().getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	public void copyFile(String fileName, InputStream in) {
		try { 
	         // write the inputStream to a FileOutputStream
			File file = new File("../gokart-data/images/" + fileName);
			System.out.println(file.getAbsolutePath());
	         OutputStream out = new FileOutputStream(file);
	      
	         int read = 0;
	         byte[] bytes = new byte[1024];
	      
	         while ((read = in.read(bytes)) != -1) {
	             out.write(bytes, 0, read);
	         }
	      
	         in.close();
	         out.flush();
	         out.close();
	      
	         System.out.println("New file created!");
	     } catch (IOException e) {
	    	 System.out.println(e.getMessage());
	     }
	}

}
