package com.niit.CollabrationBackEnd.DAO;

import java.util.ArrayList;
import java.util.List;

import com.niit.CollabrationBackEnd.Model.Friend;
import com.niit.CollabrationBackEnd.Model.User;

public interface UserDAO 
{
	 ArrayList<User> getAllUser();
	 public boolean saveUser(User user);
	 public boolean updateOnlineStatus(User user);
		public User getUser(int userid);
		public boolean checkLogin(User user);
		public User getUserbyId(int uderid);
		public User getUserbyemail_id(String email_id);
		public ArrayList<Friend> checkismyfriend(int userid,int myid);
		public ArrayList<User> userrequests();
		public boolean approveusers(User users);
		public boolean checkLoginsimp(User user);
		public boolean checkLoginsemail(User user);
		public boolean rejectusers(User users);
		public List<User> requestFriend(int user);
}
