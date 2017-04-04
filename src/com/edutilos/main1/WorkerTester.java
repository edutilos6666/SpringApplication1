package com.edutilos.main1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class WorkerTester {
    public static void main(String[] args) {
/*        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Worker w1 = (Worker)ctx.getBean("worker1");
        System.out.println(w1.toString());

        Worker w2 = (Worker)ctx.getBean("worker2");
        System.out.println(w2.toString());*/

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyBeansConfig.class);
        Worker w = ctx.getBean("worker1", Worker.class);
        System.out.println(w.toString());

        w = ctx.getBean("worker2", Worker.class);
        System.out.println(w.toString());



        Person p1 , p2 ;
        p1 = ctx.getBean("person1", Person.class);
        p2 = ctx.getBean("person2", Person.class);
        System.out.println(p1);
        System.out.println(p2);


        ContainersHolder holder1, holder2 ;
        holder1 = ctx.getBean("containersHolder1", ContainersHolder.class);
        holder2 = ctx.getBean("containersHolder2", ContainersHolder.class);
        System.out.println(holder1);
        System.out.println(holder2);

        ctx.start();
       // ctx.refresh();
        ctx.stop();


        MyCustomEventPublisher publisher = ctx.getBean(MyCustomEventPublisher.class);
        publisher.fire();
        publisher.fire();



        w.getName();
        w.setName("foo");


        p1.setFirst("foo");
        p1.getFirst();
        p1.setAddress(new Address());
        p1.getAddress();
        ctx.registerShutdownHook();


        WorkerDAO dao = ctx.getBean(WorkerDAO.class);
        ((WorkerJdbcTemplate)dao).dropTable();
        ((WorkerJdbcTemplate)dao).createTable();
        dao.save(new Worker(1, "foo", 10, 100.0));
        dao.save(new Worker(2, "bar", 20, 200.0));
        dao.save(new Worker(3, "bar", 30 , 300.0));
        List<Worker> all = dao.findAll();
        for(Worker _w: all) {
            System.out.println(_w);
        }

        dao.update(1 , new Worker(1, "newfoo", 66, 666.6));
        w = dao.findById(1L);
        System.out.println("after update = " + w.toString());

        dao.remove(1L);
        all = dao.findAll();
        System.out.println("size after remove 1L = " + all.size());


    }
}
