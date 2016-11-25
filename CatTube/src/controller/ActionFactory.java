package controller;

import controller.action.Action;
import controller.action.BoardListAction;
import controller.action.BoardReadAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance(){ return instance; }
	
	public Action getAction(String command){
		Action action = null;
		
		System.out.println("ActionFactory : "+command);
		
		if(command.equals("board_list") || command.equals("")){
			action = new BoardListAction();
		}else if(command.equals("board_read")){
			action = new BoardReadAction();
		}
		
		return action;
	}
	
}
