package com.chrosciu.profiler.list;

import java.util.ArrayList;

public class ArrayListWrapper extends ListWrapper {
    protected ArrayListWrapper() {
        super(new ArrayList<>());
    }
}
