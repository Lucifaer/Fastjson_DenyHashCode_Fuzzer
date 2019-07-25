package com.lucifaer.fastjson_blacklist_fuzzer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashCodeFuzzer hashCodeFuzzer = new HashCodeFuzzer();
        hashCodeFuzzer.fuzz("/Users/lucifaer/.m2/repository/");
    }
}
