package controller;

import controller.action.Action;
import controller.action.BoardListAction;
import controller.action.BoardPopularAction;
import controller.action.BoardReadAction;
import controller.action.BoardReplyAction;
import controller.action.BoardSearchAction;
import controller.action.BoardUploadAction;
import controller.action.LoginFormAction;
import controller.action.MemberLoginAction;
import controller.action.MemberLogoutAction;
import controller.action.MyChannelAction;
import controller.action.ReplyDeleteAction;

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
		}else if(command.equals("board_search")){
			action = new BoardSearchAction();
		}else if(command.equals("login_form")){
			action = new LoginFormAction();
		}else if(command.equals("member_login")){
			action = new MemberLoginAction();
		}else if(command.equals("member_logout")){
			action = new MemberLogoutAction();
		}else if(command.equals("my_channel")){
			action = new MyChannelAction();
		}else if(command.equals("board_reply")){
			action = new BoardReplyAction();
		}else if(command.equals("reply_delete")){
			action = new ReplyDeleteAction();
		}else if(command.equals("board_popular")){
			action = new BoardPopularAction();
		}else if(command.equals("board_upload")){
			action = new BoardUploadAction();
		}
		return action;
	}
	
}
