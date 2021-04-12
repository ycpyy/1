package com.yc;

import com.yc.biz.StudentBizImpl;

public class Test {

    public static void main(String[] args) {
        StudentBizImpl sbi=new StudentBizImpl();//

        LogAspectCglib lc=new LogAspectCglib(sbi);

        Object obj =lc.creatProxy();//
        System.out.println(obj);

        if(obj instanceof StudentBizImpl){
            StudentBizImpl s= (StudentBizImpl) obj;
            s.find("张三");
            s.add("李四");
            s.update("王五");
        }
    }
}
