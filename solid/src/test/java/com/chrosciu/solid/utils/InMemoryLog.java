package com.chrosciu.solid.utils;

import com.chrosciu.solid.utils.Log;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLog implements Log {
    private final List<String> messages = new ArrayList<>();

    @Override
    public void addMessage(String message) {
        messages.add(message);
    }

    @Override
    public List<String> getMessages() {
        return List.copyOf(messages);
    }
}
