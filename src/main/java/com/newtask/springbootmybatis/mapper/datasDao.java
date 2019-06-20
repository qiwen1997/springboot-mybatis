package com.newtask.springbootmybatis.mapper;

import com.newtask.springbootmybatis.entity.datas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface datasDao {

  datas selectByFpqqlsh(String fpqqlsh);

  int selectid(String fpqqlsh);

  public int insert(datas datas);

  public int delete(@Param("id") int id);

  public int Update(datas datas);

}
