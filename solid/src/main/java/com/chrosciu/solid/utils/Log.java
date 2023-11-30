package com.chrosciu.solid.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Log {
    private static Log instance = null;
    private final List<String> messages = new ArrayList<>();

    public static Log getInstance() {
        if (null == instance) {
            instance = new Log();
        }
        return instance;
    }

    public void addMessage(String message) {
        messages.add(message);
    }
    public List<String> getMessages() {
        return Collections.unmodifiableList(messages);
    }
    public void clearMessages() {
        messages.clear();
    }
}
