package kh.com.petbreedding.Chat.model.service;

import java.util.List;

import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;

public interface ChatService {

	public int createRoom(ChatRoom cr);
	public ChatRoom isRoom(ChatRoom cr);
	public int insertMessage(ChatMessage cm);
	public ChatRoom selectChatRoom(String chatId);
	public List<ChatList> getList(String cl_num);
	public List<ChatList> getListbp_id(String bp_id);
	public List<ChatList> getUnreadList(String cl_num);
	public List<ChatList> getUnreadListbp_id(String bp_id);
	public List<ChatMessage> getMessageList(String chatId);
	public List<ChatMessage> getMessageListbp_id(String chatId);
	public List<ChatMessage> getUnreadCount(ChatMessage cm);
	public List<ChatMessage> getUnreadCountbp_id(ChatMessage cm);
	public int updateUnreadCount(String mId);
	public int getAllCount(String mReceiver);
}
