package com.openbankproject.adapter.actors;


import akka.actor.UntypedActor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CountingActor extends UntypedActor {

    public static class Count {
    }

    public static class Get {
    }


    private int count = 0;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message.equals("increase")) {
            count++;
        } else if (message.equals("get")) {
            getSender().tell(count, getSelf());
        } else {
            unhandled(message);
        }
    }
}