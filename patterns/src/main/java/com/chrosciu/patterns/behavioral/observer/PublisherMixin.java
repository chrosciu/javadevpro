package com.chrosciu.patterns.behavioral.observer;

import java.util.HashSet;
import java.util.Set;

class PublisherMixin {
    private final Set<Subscriber> subscribers = new HashSet<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void notifyAllSubscribers(Object event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.notify(event);
        }
    }
}
