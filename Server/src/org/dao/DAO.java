package dao;

import java.util.List;

import common.UserGameInfo;

public interface DAO {
	
	void saveGameInfo(UserGameInfo userGameInfo);
	
	List<UserGameInfo> getUserGameInfo(String userName);

	UserGameInfo getUserGameInfoById(long id);
	
	boolean deleteUserGameInfo(long id);
	
}
