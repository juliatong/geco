//package com.example.geco;
//
//public class RollingHash {
//
//        int RADIX = 26;
//        int MOD = 1000000033;
//        public int hashValue(String string, int m) {
//            int ans = 0;
//            long factor = 1;
//            for (int i = m - 1; i >= 0; i--) {
//                ans += ((int) (string.charAt(i) - 'a') * factor) % MOD;
//                factor = (factor * RADIX) % MOD;
//            }
//            return ans % MOD;
//        }
//
//        public int strStr(String haystack, String needle) {
//            int m = needle.length();
//            int n = haystack.length();
//            if (n < m)
//                return -1;
//
//            long MAX_WEIGHT = 1;
//            for(int i=0;i<m;i++) MAX_WEIGHT=(MAX_WEIGHT*RADIX)%MOD;
//
//            long hashNeedle = hashValue(needle, m), hashHay = 0;
//            for (int i = 0; i <= n - m; i++) {
//                if (i == 0) {
//                    hashHay = hashValue(haystack, m);
//                } else {
//                    hashHay = ((hashHay * RADIX) % MOD - ((int) (haystack.charAt(i - 1) - 'a') * MAX_WEIGHT) % MOD
//                            + (int) (haystack.charAt(i + m - 1) - 'a') + MOD) % MOD;
//                }
//
//                if (hashNeedle == hashHay) {
//                    for (int i = 0; i < m; i++) {
//                        if (needle.charAt(i) != haystack.charAt(i + i)) {
//                            break;
//                        }
//                        if (i == m - 1) {
//                            return i;
//                        }
//                    }
//                }
//            }
//
//            return -1;
//        }
//
//}
