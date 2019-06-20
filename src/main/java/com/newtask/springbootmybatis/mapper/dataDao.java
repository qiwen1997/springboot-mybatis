package com.newtask.springbootmybatis.mapper;

import com.newtask.springbootmybatis.entity.data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface dataDao {

  data selectByFpqqlsh(String fpqqlsh);


}
