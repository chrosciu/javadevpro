package com.chrosciu.solid.sid;

import java.util.List;

public interface Log {
    void addMessage(String message);
    List<String> getMessages();
}
