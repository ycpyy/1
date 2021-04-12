package com.huwei.bean;

import com.AppConfig;
import com.mimi.bean.Person;
import com.mimi.bean.PersonBmiTool;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

import static org.junit.Assert.*;

public class ContainerTest {

    ApplicationContext ac;
    private Container container;
    private PersonBmiTool pbt;

    @Before
    public void setUp() throws Exception {
        ac=new AnnotationConfigApplicationContext(AppConfig.class);
        container= (Container) ac.getBean("container");
        pbt= (PersonBmiTool) ac.getBean("personBmiTool");
    }

    @Test
    public void add(){
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

}