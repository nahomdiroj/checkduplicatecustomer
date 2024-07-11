package com.checkduplicatecustomer1.checkduplicatecustomer1.services.implementation;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.checkduplicatecustomer1.checkduplicatecustomer1.user.Customer;

@Slf4j
public class SearcherEngine {
    public List<String> searchData(List<Customer> ll, String searchName) {
        List<String> numbers = Arrays.asList("1", "20", "A1", "333", "A2A211");
        numbers.stream()
                .filter(x -> x.matches("\\d+"))
                .forEach(System.out::println);

        List<String> likelyFoundData = new ArrayList<>();
        System.out.println("SEARCHEABLE FULL NAME:" + searchName);


        StringBuilder consonantInput = new StringBuilder();
        String[] hhh = searchName.split(" ");
        String hhhh = getConsonant(hhh[0]) + " " + getConsonant(hhh[1]);
        String searchConsonant = hhhh;

        consonantInput.append(searchConsonant);
        System.out.println("SEARCHEABLE FULL NAME CONSONANT:" + consonantInput.toString());

        StringBuilder consonant = null;
        for (Customer h : ll) {
            consonant = new StringBuilder();
//            consonant.append(getConsonant(h.getName1()));
//            consonant.append(",");
            String[] hh = h.getName1().split(" ");
            String hh1 = "";
            if (hh.length == 1) {
                hh1 = hh[0];
                consonant.append(getConsonant(hh1));
            } else {
                hh1 = getConsonant(hh[0]) + " " + getConsonant(hh[1]);
                consonant.append(hh1);
            }
            log.info("consonant found......" + consonant);
            if (consonantInput.toString().equalsIgnoreCase(consonant.toString())) {
                likelyFoundData.add(h.getName1());
                log.info("same consonant - " + consonantInput);
            } else {
                log.info("not same consonant - ");
            }
        }
        log.info("Result - " + likelyFoundData.size());

        return likelyFoundData;
    }

    static String getConsonant(String h) {
        StringBuilder consonant = new StringBuilder();
        int y = 0;
        char[] ch = convertToChar(h);
        for (char a : ch) {
            if (y == 0) {
                consonant.append(a);
            } else {
                String g = isVowel(a);
                if (g.equalsIgnoreCase("Consonant")) {
                    consonant.append(a);
                }
            }
            y++;
        }
        System.out.println("the consonant---->" + consonant.toString());
        return consonant.toString();
    }

    static char[] convertToChar(String h) {
        char[] ch = new char[h.length()];
        for (int i = 0; i < h.length(); i++) {
            ch[i] = h.charAt(i);
        }
        return ch;
    }

    static String isVowel(char ch) {
        // Make the list of vowels
        String str = "aeiouAEIOU";
        return (str.indexOf(ch) != -1) ? "Vowel" : "Consonant";
    }

    public void getConsonants(String str) {
        long req = str.chars()
                .filter(ch -> (ch != 'a' && ch != 'e' &&
                        ch != 'i' && ch != 'o' && ch != 'u'))
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .count();

    }
}
