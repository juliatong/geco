package com.example.geco.twopointers;

public class CompressString {
    public static void main(String args[]){
//      Map<Character, Integer> collect = map.entrySet().stream().filter(a -> a.getValue().intValue() != 1).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
//        char input[] = {'c','c','c','a','a','b','b'};
        char input[] = {'a','a','b','b','c','c','c'};
    }

    public static int compressH(char[] chars) {
        int i = 0;
        int j = 1;
        int index = 0;
        while (i < chars.length) {
            if (j < chars.length && chars[i] == chars[j]) {
                j++;
            } else {
                int count = j - i;
                chars[index++] = chars[i];
                char[] digit = (count + "").toCharArray();
                if (count > 1) {
                    for (char c : digit) {
                        chars[index++] = c;
                    }
                }
                i = j;
            }

        }
        return index;
    }

    public static int compress4(char[] chars) {
        int index = 0;
        int i = 0;
        int j = i;
        while ( i < chars.length) {
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            int count = j - i;
            chars[index++] = chars[i];
            char[] frequency = (count + "").toCharArray();
            if (count > 1) {
                for (int k = 0; k < frequency.length; k++) {
                    chars[index++] = frequency[k];
                }
            }
            i = j;
        }
        return index;
    }


    public static int compressString(char[] chars) {
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int j = i;
            while (j < chars.length && chars[j] == c) {
                j++;
            }
            String frequency = j - i + "";

            if (Integer.valueOf(frequency) > 1) {
                for (char x : frequency.toCharArray()) {
                    chars[index++] = x;
                }
            }
            i=j;//****wrong. After it, i will be incremented +1
        }

        return index;
    }

}

