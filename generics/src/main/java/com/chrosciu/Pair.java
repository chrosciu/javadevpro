package com.chrosciu;

public class Pair<T, U> {
    private final T first;
    private final U second;

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Pair<?, ?> other) {
        return this.first.equals(other.first) && this.second.equals(other.second);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Pair<?, ?> && this.equals((Pair<?, ?>) o);
    }

    @Override
    public int hashCode() {
        return this.first.hashCode() + this.second.hashCode();
    }
}
