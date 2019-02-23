package io.zipcoder.casino.dicegames;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bin {

    private List<List<Integer>> results;

    public Bin(){
        results = new ArrayList<List<Integer>>();
    }
    public void add(Integer[] result){
        if(result != null)
            this.results.add(new ArrayList(Arrays.asList(result)));
    }

    Integer[] getResult(int turnNumber){ //turn is 1 indexed
        if(turnNumber > results.size()){
            return null;
        }
        else{
            return results.get(turnNumber - 1).toArray(new Integer[1]);
        }
    }

    int getSum(int turnNumber){ //turn is 1 indexed
        Integer[] result = getResult(turnNumber);

        int sum = 0;
        if(result != null) {
            for (Integer value : result) {
                sum += value;
            }
        }
        return sum;
    }

}
