package io.github.lucienh.dubbotest.consumer;

import java.util.List;

import io.github.lucienh.dubbotest.provider.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"consumer.xml"});
        context.start();


        while (true) {
            try {
                DemoService demoService = (DemoService) context.getBean("demoService"); //
                String hello = demoService.sayHello("tom"); //
                System.out.println(hello); //
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                Thread.sleep(1000);
            }

        }

//
//        //
//        List list = demoService.getUsers();
//        if (list != null && list.size() > 0) {
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
//        }
//        // System.out.println(demoService.hehe());
//        System.in.read();
    }

}  
