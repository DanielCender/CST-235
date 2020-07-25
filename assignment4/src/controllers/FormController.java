package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	private OrdersBusinessInterface service;
	
	public String onSubmit(User user) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.getExternalContext().getRequestMap().put("user", user);
		service.test();
		return "TestResponse.xhtml";
	}
	public String onFlash(User user) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
	
	public OrdersBusinessInterface getService() {
		return service;
	}
}
