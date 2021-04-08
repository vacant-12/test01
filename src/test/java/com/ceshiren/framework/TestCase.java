package com.ceshiren.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestCase {
    public List<String> data;
    public List<HashMap<String,Object>> steps;
    public  int index=0;

    public List<TestCase> testcase_generate(){
        List<TestCase> testCaseList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            POTestCase testcaseNew = new POTestCase();
            testcaseNew.index=i;
            testcaseNew.steps=steps;
            testcaseNew.data=data;
            testCaseList.add(testcaseNew);
        }
        return testCaseList;
    }

    public Object getValue(HashMap<String,Object> step,String key){
        Object value = step.get(key);
        if(value instanceof String){
            //进行替换，复杂结构支持需要使用递归
            return ((String)value).replace("${data}",data.get(index));
        }else{
            return value;
        }
    }
    public Object getValue(HashMap<String,Object> step,String key,Object defaultValue){
        return step.getOrDefault(key,defaultValue);
    }

    public void run(){}
}
