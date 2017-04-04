package com.edutilos.main1;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by edutilos on 04/04/2017.
 */
public class MyCustomEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher ;
@Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

    public void fire() {
        MyCustomEvent evt = new MyCustomEvent(this);
        publisher.publishEvent(evt);
}
}
