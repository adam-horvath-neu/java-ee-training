package hu.neuron.java.web.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

import hu.neuron.service.UserService;
import hu.neuron.service.vo.UserVo;

@ViewScoped
@Named("registrationController")
public class RegistrationController implements Serializable {
	
	private static final Logger logger = LogManager.getLogger(RegistrationController.class);

	private static final long serialVersionUID = 1L;

	private UserVo uservo;

	private String password2 = "";
	
	 
	

	@PostConstruct
	public void init() {
		uservo = new UserVo();
	}

	@Inject
	private UserService userService;

	public String addUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (!uservo.getPassword().equals(getPassword2())) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Password not match"));
				return null;
			} else if (getUserService().findUserByName(uservo.getUsername()) != null) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
						"Sorry we already have a user with this name"));
				return null;
			}

			

			getUserService().registration(uservo);

			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registration sucessful you can log in now"));

		} catch (Exception e) {
		
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
			return "/public/registration.xhtml?faces-redirect=true";
		}

		return "/public/login.xhtml?faces-redirect=true";
	}
	
	
	

	public String onFlowProcess(FlowEvent event) {
       
            return "confirm";
        }
       
    
	

	public UserVo getUservo() {
		return uservo;
	}


	public void setUservo(UserVo uservo) {
		this.uservo = uservo;
	}


	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
