package com.yc.biz;

import com.yc.MyAppConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentBizImplTest {

    ApplicationContext ac;
    private StudentBizImpl studentBiz;

    @Before
    public void setUp() throws Exception {
        ac=new AnnotationConfigApplicationContext(MyAppConfig.class);
        studentBiz= (StudentBizImpl) ac.getBean("studentBizImpl");
    }

    @Test
    public void add() {
        studentBiz.add("李四");
    }

    @Test
    public void update() {
        studentBiz.update("李四");
    }
}