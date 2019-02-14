package com.openbankproject.adapter.config;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

public class AdapterCreator {

    private ApplicationContext applicationContext;
    private ActorSystem actorSystem;

    public AdapterCreator(ActorSystem actorSystem, ApplicationContext applicationContext) {
        this.actorSystem = actorSystem;
        this.applicationContext = applicationContext;
    }

    public ActorRef getActorRef(Class<? extends Actor> actorType, Object... actorConstructorArgs) {
        String actorBeanName = StringUtils.uncapitalize(actorType.getSimpleName());

        return this.getActorRef(actorBeanName, actorConstructorArgs);
    }
    public ActorRef getActorRef(String actorBeanName, Object... actorConstructorArgs) {
        Props  props = Props.create(SpringActorProducer.class, applicationContext, actorBeanName, actorConstructorArgs);
        return actorSystem.actorOf(props, actorBeanName);
    }
}
