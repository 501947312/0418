package com.zlh.test;

import com.zlh.po.customer;
import com.zlh.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class text {
@Test
    public void insertTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);

        customer customer1 =new customer();
        customer1.setUsername("孙权");

        customer1.setPhone("111");
    customer1.setJobs("皇帝");
        int rows = sqlSession.insert("insert",customer1);
        if (rows>0){
            System.out.println("===========新增数据成功!===========");
        }else {
            System.out.println("=============新增数据失败！===========");
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }


    @Test
    public void delete(){
    SqlSession sqlSession=MybatisUtils.getSqlSession(true);
    int row=sqlSession.delete("delete",10);
    if(row>0)System.out.println("===========删除成功!===========");
    else  System.out.println("失败");
}



     @Test
    public  void bianli(){
     SqlSession sqlSession=MybatisUtils.getSqlSession(true);
         List<customer> list=sqlSession.selectList("bianli");
         for(customer list1:list)
             System.out.println(list1.getId()+"  "+list1.getJobs()); }


    @Test
    public void findAllCustomerByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);

        List<customer> list = sqlSession.selectList("Byid",6);

        System.out.println(list);
        //关闭sqlSession
        MybatisUtils.closeSqlSession(sqlSession);
    }
    @Test public  void update(){
    SqlSession sqlSession=MybatisUtils.getSqlSession(true);
    customer customer1 = new customer();
    customer1.setId(10);
    customer1.setUsername("111");
    customer1.setJobs("222");
    customer1.setPhone("333");
    int row=sqlSession.update("updateCustomer",customer1);
    if(row>0)System.out.println("成功");
    else System.out.println("失败");


    }

@Test public  void  mohu()
{
    SqlSession sqlSession=MybatisUtils.getSqlSession(true);
    String username="孙";
    List<customer>list=sqlSession.selectList("mohu",username);
    System.out.println(list);

}
    @Test public  void  mohu1(){
        SqlSession sqlSession=MybatisUtils.getSqlSession(true);
       Map<String,Object> map=new HashMap<>();
        map.put("username1","孙权");
        int n=1;
        int pagenum= 20;
        int pages=(n-1)*pagenum;
        map.put("pages",pages);
        map.put("pagenum",pagenum);
        List<customer> list=sqlSession.selectList("mohu",map);
        System.out.println(list);
    }





}
