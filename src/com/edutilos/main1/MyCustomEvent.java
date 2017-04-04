package com.edutilos.main1;

import org.springframework.context.ApplicationEvent;

/**
 * Created by edutilos on 04/04/2017.
 */
public class MyCustomEvent extends ApplicationEvent {
    public MyCustomEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My Custom Event";
    }
}
