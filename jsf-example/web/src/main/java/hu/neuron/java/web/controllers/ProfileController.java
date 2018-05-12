package hu.neuron.java.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import hu.neuron.java.web.beans.UserSessionBean;
import hu.neuron.service.UserService;
import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.vo.Gender;
import hu.neuron.service.vo.UserVo;

@ViewScoped
@Named("profileController")
public class ProfileController implements Serializable {

	private static final long serialVersionUID = 7430801820340921193L;

	private UserVo userVo;

	private UploadedFile file;

	private byte[] image;

	private String password;
	private String password2;
	private String gender;
	private List<String> genders;

	@Inject
	private UserService userService;

	@Inject
	UserSessionBean userSessionBean;

	@PostConstruct
	public void init() {
		genders = new ArrayList<>();
		Gender[] genderValue = Gender.values();
		for (Gender gender : genderValue) {
			genders.add(gender.name());
		}
		userVo = userSessionBean.getUser();
	}

	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			userService.saveUser(userVo);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes!", "Succes update"));
		} catch (ServiceException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Error"));
		}
	}

	// public void upload() {
	// if (file != null) {
	// FacesMessage message = new FacesMessage("Succesful", file.getFileName() + "
	// is uploaded.");
	//
	// userVo.setImage(file.getContents());
	// try {
	// userService.saveUser(userVo);
	// } catch (ServiceException e) {
	// e.printStackTrace();
	// }
	// FacesContext.getCurrentInstance().addMessage(null, message);
	// }
	// }

	public void upload(FileUploadEvent e) {
		try {
			image = e.getFile().getContents();
			userVo.setImage(image);
			userService.saveUser(userVo);
			FacesMessage message = new FacesMessage("Succesful", e.getFile().getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void savePassword() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			if (!getPassword().equals(getPassword2())) {

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Passwords does not match!"));

			}

			userVo.setPassword(getPassword());
			userService.savePassword(userVo);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes!", "Succes update"));
		} catch (ServiceException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Error"));
		}
	}

	public void saveData() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			userVo.setGender(Gender.valueOf(gender));

			userService.saveUser(userVo);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes!", "Succes update"));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Error"));
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}
}
