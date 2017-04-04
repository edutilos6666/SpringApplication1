package com.edutilos.main1;


import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.*;

@Configuration
@EnableAspectJAutoProxy
public class MyBeansConfig {
    @Bean("worker1")
    public Worker worker1() {
        Worker w = new Worker(1, "foo", 10, 100.0);
        return w;
    }


    @Bean("worker2")
    public Worker worker2() {
        Worker w = new Worker(2, "bar", 20, 200.0);
        return w ;
    }


    @Bean("address1")
    public Address address1() {
     Address addr1 = new Address("Bochum", "Sumperkamp", "foo@bar");
        return addr1;
    }

    @Bean("address2")
    public Address address2() {
        Address addr2 = new Address("Bochum", "Laerholzstrasse", "edu@tilos");
        return addr2 ;
    }

    @Bean("person1")
    public Person person1() {
        Person p = new Person("foo", "bar", address1());
        return p;
    }

    @Bean("person2")
    public Person person2() {
        Person p = new Person("edu", "tilos", address2());
        return p;
    }



    @Bean("containersHolder1")
    public ContainersHolder containersHolder1() {
        ContainersHolder holder = new ContainersHolder();
        List<String> list = Arrays.asList("listFoo1", "listBar1", "listBim1");
        Set<String> set = new HashSet<>(Arrays.asList("setFoo1", "setBar1", "setBim1"));
        Map<Long, String> map = new HashMap<>();
        map.put(1L , "mapFoo1");
        map.put(2L , "mapBar1");
        map.put(3L, "mapBim1");

        Properties props = new Properties();
        props.setProperty("prop1", "propFoo1");
        props.setProperty("prop2", "propBar1");
        props.setProperty("prop3", "propBim1");
        holder.setList(list);
        holder.setSet(set);
        holder.setMap(map);
        holder.setProps(props);
        return holder;
    }


    @Bean("list2")
    public List<String> list2() {
        List<String> list = Arrays.asList("listFoo2", "listBar2", "listBim2");
        return list;
    }

    @Bean("set2")
    public Set<String> set2() {
        Set<String> set = new HashSet<>(Arrays.asList("setFoo2", "setBar2", "setBim2"));
        return set;
    }

    @Bean("map2")
    public Map<Long, String> map2() {
        Map<Long, String> map = new HashMap<>();
        map.put(1L , "mapFoo2");
        map.put(2L , "mapBar2");
        map.put(3L, "mapBim2");
        return map;
    }


    @Bean("props2")
    public Properties props2() {
        Properties props = new Properties();
        props.setProperty("prop1", "propFoo1");
        props.setProperty("prop2", "propBar1");
        props.setProperty("prop3", "propBim1");
        return props;
    }

    @Bean("containersHolder2")
    public ContainersHolder containersHolder2() {
        return new ContainersHolder(list2(), set2(), map2(), props2());
    }


    @Bean
    public ApplicationListener<ContextStartedEvent> contextStarted() {
        return new ApplicationListener<ContextStartedEvent>() {
            @Override
            public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
                System.out.println(contextStartedEvent.toString());
            }
        };
    }

    @Bean
    public ApplicationListener<ContextStoppedEvent> contextStopped() {
        return new ApplicationListener<ContextStoppedEvent>() {
            @Override
            public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
                System.out.println(contextStoppedEvent.toString());
            }
        };
    }

    @Bean
    public ApplicationListener<ContextRefreshedEvent> contextRefreshed() {
        return new ApplicationListener<ContextRefreshedEvent>() {
            @Override
            public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
                System.out.println(contextRefreshedEvent.toString());
            }
        };
    }


    @Bean
    public ApplicationListener<MyCustomEvent> customEventListener() {
        return new ApplicationListener<MyCustomEvent>() {
            @Override
            public void onApplicationEvent(MyCustomEvent myCustomEvent) {
                System.out.println("custom event was triggered.");
            }
        };
    }

    @Bean
    public MyCustomEventPublisher myCustomEventPublisher() {
        return new MyCustomEventPublisher();
    }



    @Bean
    public WorkerLogging logging()  {
        return new WorkerLogging();
    }


    @Bean
    public PersonLogging personLogging() {
        return new PersonLogging();
    }


    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }


    @Bean
    public JdbcTemplate mysqlTemplate() {
        JdbcTemplate template = new JdbcTemplate(mysqlDataSource());
        return template;
    }


    @Bean
    public WorkerDAO dao() {
       WorkerJdbcTemplate  workerJdbcTemplate = new WorkerJdbcTemplate(mysqlTemplate());
        return workerJdbcTemplate;
    }
}
