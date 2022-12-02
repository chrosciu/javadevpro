package com.chrosciu.profiler.list;

import java.util.LinkedList;

public class LinkedListWrapper extends ListWrapper {
    protected LinkedListWrapper() {
        super(new LinkedList<>());
    }
}
