package String;

import java.io.*;
import java.util.*;

public class Main_B_20920_영단어암기는괴로워 {

    static class Word implements Comparable<Word> {
        int cnt;
        String s;

        Word(int cnt, String S) {
            this.cnt = cnt;
            this.s = s;
        }

        @Override
        public int compareTo(Word o) {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();


        br.close();
    }
}
