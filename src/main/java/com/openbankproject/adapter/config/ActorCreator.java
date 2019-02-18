package com.openbankproject.adapter.config;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class ActorCreator {

    private ApplicationContext applicationContext;
    private ActorSystem actorSystem;

    public ActorCreator(ActorSystem actorSystem, ApplicationContext applicationContext) {
        this.actorSystem = actorSystem;
        this.applicationContext = applicationContext;
    }

    public ActorRef getActorRef(Class<? extends Actor> actorType, String actorName, Object... actorConstructorArgs) {
        return this.getActorRef(actorType.getSimpleName(), actorName, actorConstructorArgs);
    }
    public ActorRef getActorRef(String actorBeanName, String actorName, Object... actorConstructorArgs) {
        Props  props = Props.create(SpringActorProducer.class, applicationContext, actorBeanName, actorConstructorArgs);
        return actorSystem.actorOf(props, actorName);
    }
}
