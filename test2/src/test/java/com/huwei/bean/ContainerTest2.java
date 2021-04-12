package com.huwei.bean;

import com.AppConfig;
import com.mimi.bean.Person;
import com.mimi.bean.PersonBmiTool;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
@RunWith(SpringJUnit4ClassRunner.class)//
@ContextConfiguration(classes = {AppConfig.class})//
public class ContainerTest2 implements ApplicationContextAware, BeanNameAware {

    @Autowired
    private Container container;
    @Autowired
    private PersonBmiTool pbt;



    @Test
    public void add(){
        Environment an=ac.getEnvironment();
        System.out.println(an.getProperty("user.home"));
        System.out.println(an.getProperty("user.dir"));
        System.out.println(an.getProperty("JAVA_HOME"));

        System.out.println(bn);

        Random r=new Random();
        for(   int i=0;i<10;i++){
            //  Math.random()   生成 0-1之间的小数
            Person p7=new Person( "王八"+i,   1+Math.random()    ,   r.nextInt(80)+30  );
            container.save(p7);
        }



        Person max=(Person)container.getMax();   //取最大值
        Person min=(Person)container.getMin();   //最最小值

        System.out.println("最大值:"+  max.getName() );
        System.out.println("最小值:"+ min.getName());

        System.out.println("平均bmi:"+ container.getAvg() );

        Object[] objs=container.getObjs();
        for(   Object o: objs ){
            Person pp=(Person)o;
            System.out.println(    pp.getName()+"\t"+pp.getHeight()+"\t"+pp.getWeight() +"\t"+   pbt.measure(   pp  )  );
        }
    }

    private ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac=applicationContext;
    }

    String bn;
    @Override
    public void setBeanName(String s) {
        this.bn=  s ;
    }
}