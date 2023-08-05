package com.example.geco.recent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class Leg {
    char typ;
    int no;
    int weight;
}

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER O
     *  2. INTEGER S
     *  3. INTEGER_ARRAY close_prices of length O, O[i] is close_price of outright i+1
     *  4. INTEGER_ARRAY no_of_legs of length S, S[i] is no of legs of strategy i+1
     *  5. 2D_ARRAY strategies of length S,
           S[i] is an array of length no_of_legs[i],
           S[i][j] describes the j-th leg of strategy i+1
     */

    public static List<Integer> solve(int O, int S, List<Integer> close_prices, List<Integer> no_of_legs, List<List<Leg>> strategies) {
        Map<Integer, Integer> map=new HashMap<>();
        List<Integer> result=new ArrayList<>();// strategy[i]->price

        for(int i=0;i<strategies.size();i++){
            List<Leg> cur=strategies.get(i);
            int price=0;
            for(Leg l: cur){
                if( l.typ=='O'){
                    price+=l.weight*close_prices.get(l.no);
                }else {//'S'
                    price+=map.get(i);
                }
            }
            result.add(i, price);
            map.put(i,price);
        }
        return result;
    }

}




