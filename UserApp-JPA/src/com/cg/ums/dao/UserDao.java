package com.cg.ums.dao;

import java.util.List;
import com.cg.ums.entities.User;

public interface UserDao {

	public List<User> findByName(char lastCharac);

	public Long findCount();

	public List<User> findAllByEmailAsc();

}
