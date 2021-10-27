package com.agulicious;

public class Main {

    public static void main(String[] args) {
        boolean[] mark = new boolean[26];
        String text = "The quick brown fox jumps over the lazy dog.";
        boolean pangram = true;
        int index = 0;
        text = text.replace(" ", "").toLowerCase().replace(".","");


        for(int i=0; i<text.length();i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                index = text.charAt(i) - 'a';
            }
            mark[index] = true;
        }
        for(int i = 0; i<mark.length;i++){
            System.out.println(mark[i] + " array mark position "+ i);
            if(mark[i] == false){
                pangram = false;
            }
        }
        if(pangram){
            System.out.println("Congratulation: it's a Pangram! :)");
        }else {
            System.out.println("Sorry: Not a Pangram :/");
        }
    }
}
