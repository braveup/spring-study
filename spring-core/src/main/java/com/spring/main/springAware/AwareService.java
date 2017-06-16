package com.spring.main.springAware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by braveup on 2017/6/16.
 *
 * Spring Aware的目的是为了让bean获得spring容器的服务。因为ApplicationContext接口继承了MessageSource接口ApplicationEventPublisher接口
 * 和ResourceLoader接口，所以bean继承了ApplicationContextAware接口就可以获得Spiring容器所有的服务，但是原则上我们使用哪个就继承哪个接口
 *
 */

@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{
    private  String  beanName;
    private  ResourceLoader  loader;

    @Override
    public void setBeanName(String s) {
        this.beanName=s;
    }
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader=resourceLoader;
    }
    public  void outputResult(){
        System.out.println("bean的Name为："+beanName);
        Resource resource=  loader.getResource("classpath:AwareTest.txt");
        try {
            System.out.println("ResourceLoad加载的内容为："+ convertStreamToString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

