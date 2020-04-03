package com.company;

public class Token {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Token(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                '}';
    }

    int value;
}
