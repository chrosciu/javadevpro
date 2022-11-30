package com.chrosciu.solid.utils;

import java.util.List;

public interface Log {
    void addMessage(String message);
    List<String> getMessages();
}
