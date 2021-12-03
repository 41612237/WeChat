package com.tomgao.tomchat.mapper;


import com.tomgao.tomchat.pojo.Users;
import com.tomgao.tomchat.pojo.vo.FriendRequestVO;
import com.tomgao.tomchat.pojo.vo.MyFriendsVO;
import com.tomgao.tomchat.utils.MyMapper;

import java.util.List;

public interface UsersMapperCustom extends MyMapper<Users> {
	
	public List<FriendRequestVO> queryFriendRequestList(String acceptUserId);
	
	public List<MyFriendsVO> queryMyFriends(String userId);
	
	public void batchUpdateMsgSigned(List<String> msgIdList);
	
}