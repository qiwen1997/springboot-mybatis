package com.newtask.springbootmybatis;


import com.newtask.springbootmybatis.entity.data;
import com.newtask.springbootmybatis.entity.datas;
import com.newtask.springbootmybatis.entity.item;
import com.newtask.springbootmybatis.mapper.datasDao;
import com.newtask.springbootmybatis.mapper.itemDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestController {

  @Resource
  private datasDao datasDao;

  @Resource
  private itemDao itemDao;
  @Test
  public void test(){
    //datas datas=datasDao.selectByFpqqlsh("12345678901234567891");
    Logger logger= LoggerFactory.getLogger(SpringbootMybatisApplicationTests.class);

    item item =new item("111","222","333",44,55,66);
    List<item> itemList=new ArrayList<>();
    itemList.add(item);
    //增加
//    int x=itemDao.insertItem(item,2);
//    logger.info("x:"+String.valueOf(x));

    //更新
//    item.setItemName("888");
//    int y=itemDao.Update(item,2);
//    logger.info(String.valueOf(y));

    //删除
//    int z=itemDao.delete(2);
//    logger.info(String.valueOf(z));

    data data=new data("yyy","uuu","iii",65,"kji","iop",itemList);
    datas datas =new datas("456789","4","fdg",data);
    //增加
//    int x=datasDao.insert(datas);
//    logger.info("x:"+String.valueOf(x));

    //更新
//    datas.getData().setEinvoiceNumber("ttt");
//    int y=datasDao.Update(datas);
//    logger.info(String.valueOf(y));

    //删除
//    int z=datasDao.delete(2);
//    logger.info(String.valueOf(z));

  }
}
