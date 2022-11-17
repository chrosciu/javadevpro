package com.chrosciu;

public class ComparablePair<T extends Comparable<T>, U extends Comparable<U>> extends Pair<T, U> implements Comparable<ComparablePair<T, U>> {
    public ComparablePair(T first, U second) {
        super(first, second);
    }

    @Override
    public int compareTo(ComparablePair<T, U> anotherPair) {
        int firstFieldCompareResult = getFirst().compareTo(anotherPair.getFirst());
        return firstFieldCompareResult != 0 ? firstFieldCompareResult : getSecond().compareTo(anotherPair.getSecond());
    }

}
