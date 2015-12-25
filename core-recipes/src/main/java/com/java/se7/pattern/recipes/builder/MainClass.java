package com.java.se7.pattern.recipes.builder;

import java.util.Map;
import java.util.Set;

/**
 * Created by vf-root on 2/5/15.
 */
public class MainClass {

    public static void main(String[] args){
        RequestEvent requestEvent = new RequestEvent.RequestEventBuilder().eventType("request").roundTripTime("20").build();
        Map<String,String> eventDetails = requestEvent.get();
        Set<String> keys = eventDetails.keySet();

        for (String key: keys){
            System.out.println(eventDetails.get(key));
        }

        RequestEvent requestEvent2 = new RequestEvent.RequestEventBuilder(requestEvent).eventType("response").build();
        Map<String,String> eventDetails2 = requestEvent2.get();
        Set<String> keys2 = eventDetails2.keySet();

        for (String key: keys2){
            System.out.println(eventDetails.get(key));
        }



    }

}
