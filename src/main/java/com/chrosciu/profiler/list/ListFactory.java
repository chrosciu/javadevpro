package com.chrosciu.profiler.list;

public class ListFactory {
    public static ListWrapper build(ListType type) {
        switch (type) {
            case ARRAY:
                return new ArrayListWrapper();
            case LINKED:
                return new LinkedListWrapper();
            default:
                throw new IllegalArgumentException();
        }
    }
}
