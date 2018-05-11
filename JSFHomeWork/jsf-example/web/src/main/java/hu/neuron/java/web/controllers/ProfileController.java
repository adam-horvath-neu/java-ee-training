package hu.neuron.java.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
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

	private static final Logger logger = LogManager.getLogger(RegistrationController.class);

	private UserVo userVo;

	private String password = "";
	
	private String password2 = "";

	private List<String> genders;

	private String gender = "";

	private StreamedContent chart;  	
	
	private byte[] pic;
	
	@PostConstruct
	public void init() {
	
		genders = new ArrayList<>();
		Gender[] gendersA = Gender.values();
		for (Gender gender : gendersA) {
			genders.add(gender.name());
		}
		userVo = userSessionBean.getUser();
		
	}

	private UploadedFile file;

	@Inject
	private UserService userService;

	@Inject
	UserSessionBean userSessionBean;
	

	
	public void savePw() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			if (!getPassword().equals(getPassword2())) {
				
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "global.error", "password_not_match"));
					
			}
			
			userVo.setPassword(getPassword());
			userService.saveUserPw(userVo);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes!", "Succes upadte"));
		}
		catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Error"));
		}
	}

	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
						
			userVo.setGender(Gender.valueOf(gender));
			
			userService.saveUser(userVo);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes!", "Succes upadte"));
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Error"));
		}
	}
	
	public void upload(FileUploadEvent event) throws ServiceException {
		
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
			
			pic = event.getFile().getContents();
			userVo.setImage(pic);
			userService.saveUser(userVo);
		
			FacesContext.getCurrentInstance().addMessage(null, message);
		
	}

	private void addErrorMessage(String string) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "global.error",
				ResourceBundle.getBundle("hu.neuron.java.Messages").getString(string)));
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2 the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * @return the chart
	 */
	public StreamedContent getChart() {
		return chart;
	}

	/**
	 * @param chart the chart to set
	 */
	public void setChart(StreamedContent chart) {
		this.chart = chart;
	}

	/**
	 * @return the pic
	 */
	public byte[] getPic() {
		return pic;
	}

	/**
	 * @param pic the pic to set
	 */
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	
	

}
