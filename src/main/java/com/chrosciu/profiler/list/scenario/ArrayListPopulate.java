package com.chrosciu.profiler.list.scenario;

import com.chrosciu.profiler.list.ListFactory;
import com.chrosciu.profiler.list.ListType;

public class ArrayListPopulate {
    public static void main(String[] args) {
        var listWrapper = ListFactory.build(ListType.ARRAY);
        listWrapper.populate(1000000, false);
    }
}
