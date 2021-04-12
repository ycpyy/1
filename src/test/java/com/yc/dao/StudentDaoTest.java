package com.yc.dao;

import com.yc.biz.StudentBizImpl;
import org.junit.Before;
import org.junit.Test;


public class StudentDaoTest {

    private StudentDao studentDao;
    private StudentBizImpl studentBizImpl;

    @Before
    public void setUp() throws Exception {
        //
        studentDao=new StudentDaoJpaImpl();

        //
        studentBizImpl=new StudentBizImpl();

        //
        studentBizImpl.setStudentDao(studentDao);

    }

    @Test
    public void add() {
        studentDao.add("张三");
    }

    @Test
    public void update() {
        studentDao.update("张三");
    }

    @Test
    public void testBizAdd(){
        studentBizImpl.add("张三");
    }

}