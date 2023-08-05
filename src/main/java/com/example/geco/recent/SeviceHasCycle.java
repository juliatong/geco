package com.example.geco.recent;

import java.util.*;

public class SeviceHasCycle {
    public static void main(String[] args) {
        List<String[]> services=new ArrayList<>();
        services.add(new String[]{"A", "B"});
        services.add(new String[]{"A", "C"});
        services.add(new String[]{"B", "D"});
        services.add(new String[]{"D", "A"});
        boolean flag=hasCylce(services);
        System.out.print(flag);
    }

    //topological sort: dfs, bfs
    static Map<String, List<String>> map=new HashMap<>();
    static Set<String> services=new HashSet<>();
    private static boolean hasCylce(List<String[]> dependencies ){//[['A', 'B'], ['A', 'C'], ['B', 'D'], ['D', 'A']]
        //step 1:
        //<A, [B,C]>
        //<B, [D]>
        //<D, [A]>
        //<A, B, C, D>
        buildGraph(dependencies);

        //<A, B, C, D>
        for(String service: services){
            if(dfs(service, new HashSet<>())) return true;
        }
        return false;
    }

    private static boolean dfs(String  service, Set<String> visited){//<'A',[B,C]>
        if(!visited.add(service)) return true; //A
        if(map.get(service)==null || map.get(service).size()==0) return false;

        for(String dependency: map.get(service)){// B, C
            visited.add(dependency); // A, C
            if(dfs(dependency,visited)) return true;
            visited.remove(dependency); // A
        }
        return false;
    }

    private static void buildGraph(List<String[]> dependencies){//[['A', 'B'], ['A', 'C']
        for(String d[]:  dependencies){
            services.add(d[0]);
            services.add(d[1]);
            map.putIfAbsent(d[0], new ArrayList<>());//a -> [b]  //[a,c]
            map.get(d[0]).add(d[1]);//a->[b,c]
        }
    }
}
