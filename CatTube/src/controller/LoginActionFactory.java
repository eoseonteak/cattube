package controller;

import controller.action.Action;
import controller.action.AuthorizeAction;
import controller.action.CallbackAction;
import controller.action.LogoutAction;
import controller.action.ProfileAction;

public class LoginActionFactory {
	private LoginActionFactory() {}
	private static LoginActionFactory instance = new LoginActionFactory();
	public static LoginActionFactory getInstance(){ return instance; }
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("authorize")){
			action = new AuthorizeAction();
		} else if(command.equals("callback")){
			action = new CallbackAction();
		} else if(command.equals("profile")){
			action = new ProfileAction();
		} else if(command.equals("logout")){
			action = new LogoutAction();
		}
		
		return action;
	}
}
