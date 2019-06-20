package com.newtask.springbootmybatis.mapper;

import com.newtask.springbootmybatis.entity.item;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface itemDao {

  List<item> selectByHid(Integer hid);

  public int insertItem(item item,@Param("hid") int hid);

  public int delete(int hid);

  public int Update(item item,@Param("hid") int hid);
}
