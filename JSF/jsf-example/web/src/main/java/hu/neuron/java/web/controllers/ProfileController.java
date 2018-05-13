package hu.neuron.java.web.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;
import org.primefaces.model.UploadedFile;

import hu.neuron.java.web.beans.UserSessionBean;
import hu.neuron.service.UserService;
import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.vo.UserVo;

@ViewScoped
@Named("profileController")
public class ProfileController implements Serializable {

	private static final long serialVersionUID = 7430801820340921193L;

	private UserVo userVo;

	private UploadedFile file;
	
	private String password2 = "";

	private List<String> genders;

	private String gender = "";

	
	@Inject
	private UserService userService;

	@Inject
	UserSessionBean userSessionBean;

	@PostConstruct
	public void init() {
		userVo = userSessionBean.getUser();
	}

	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (!userVo.getPassword().equals(getPassword2())) {

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "global.error", "password_not_match"));
				
			} else {
			userService.saveUser(userVo);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes!", "Succes upadte"));
			}
		} catch (ServiceException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Error"));
		}
	}

	private void addErrorMessage(String string) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "global.error",
				ResourceBundle.getBundle("hu.neuron.java.Messages").getString(string)));
		
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			
			userVo.setImage(file.getContents());
			try {
				userService.saveUser(userVo);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {

		this.userVo = userVo;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
