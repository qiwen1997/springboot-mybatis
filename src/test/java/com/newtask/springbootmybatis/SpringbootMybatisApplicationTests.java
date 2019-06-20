package com.newtask.springbootmybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.newtask.springbootmybatis.mapper")
public class SpringbootMybatisApplicationTests {

  @Test
  public void contextLoads() {
  }

}
