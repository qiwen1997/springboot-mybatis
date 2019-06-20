package com.newtask.springbootmybatis.mapper;



import com.newtask.springbootmybatis.entity.user;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface userDao {

  List<user> findUserByName(String name);

  public user findUserById(Integer id);

  public List<user> ListUser();

  public int insertUser(user user);

  public int delete(int id);

  public int Update(user user);

}
