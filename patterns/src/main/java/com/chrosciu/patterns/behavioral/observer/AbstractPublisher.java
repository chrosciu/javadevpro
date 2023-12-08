package com.chrosciu.patterns.behavioral.observer;

import java.util.HashSet;
import java.util.Set;

abstract class AbstractPublisher {
    private final Set<Subscriber> subscribers = new HashSet<>();

    void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    void notifyAllSubscribers(Object event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.notify(event);
        }
    }
}
