package com.example.geco.recent;

import java.util.ArrayList;
import java.util.List;

public class pieceStringsTogether {
    // "MORGAN", "STANLEY", "INVESTIMENT", "BANK"
    static List<String> result=new ArrayList<>();
    private static void recursive(String tmp, int i, List<String > strs){
        if(i==strs.size()) {
            result.add(tmp);
            return;
        }

        String cur=strs.get(i);
        for(int j=0; j<cur.length(); j++){
            tmp+=""+ cur.charAt(j);
            recursive(tmp, i+1, strs);
        }
    }

    private static List<String> recursive2(int i, List<String > strs){
        if(i==strs.size()) {
            return List.of("");
        }

        String cur=strs.get(i);
        List<String> tmpS=new ArrayList<String>();
        for(int j=0; j<cur.length(); j++){
            List<String> tmp=recursive2(i+1, strs);
            for(String s: tmp) {
                tmpS.add(cur.charAt(j) + s);
            }
        }
        return tmpS;
    }
}
