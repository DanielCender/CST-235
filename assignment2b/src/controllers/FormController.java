package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped
public class FormController {
	public String onSubmit(User user) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	public String onFlash(User user) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
}
