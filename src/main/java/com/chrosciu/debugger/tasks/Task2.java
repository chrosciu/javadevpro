package com.chrosciu.debugger.tasks;

class Task2 {
    /**
     * Find minimum value in given iterable
     * @param iterable iterable to be searched for minimum value
     * return mimimum value
     */
    static int minValue(Iterable<Integer> iterable) {
        int currmin = Integer.MAX_VALUE;

        for (Integer i: iterable)
            if (i > currmin)
                currmin = i;
        return currmin;
    }
}
