package com.mindera;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by carlosmorais on 16/06/2017.
 */
public class GroupsGP {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GroupsGP.class);

    public ArrayList<ArrayList<Integer>> groups(List<Integer> numbers, int nGroups) throws IllegalArgumentException {
        logger.debug("receive list {} to group in {}", numbers, nGroups);

        if(numbers == null)
            throw new IllegalArgumentException("the list can't be null !");

        //remove duplicates
        ArrayList<Integer> ordNumbers = new ArrayList<>(new LinkedHashSet<>(numbers));

        if (ordNumbers.size() < nGroups) {
            //logger.warn("receive a list invalid: the total of different numbers should be bigger than the number of groups");
            throw new IllegalArgumentException("the total of different numbers should be bigger than the number of groups");
        }
        else if (nGroups == 0)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>(nGroups);
        for (int i = 0; i < nGroups; i++)
            res.add(new ArrayList<>());

        //sort the numbers
        Collections.sort(ordNumbers);
        logger.debug("Ordered list = {}", ordNumbers);

        //compute all differences between the numbers
        ArrayList<Integer> differences = new ArrayList<>(ordNumbers.size()-1);
        for (int i = 0; i < ordNumbers.size()-1; i++) {
            differences.add(ordNumbers.get(i+1)-ordNumbers.get(i));
        }

        //sort the differens
        logger.debug("Differences between numbers = {} ", differences);
        Collections.sort(differences);

        //take max nGroups-1 differences
        ArrayList<Integer> nMaxDifferences = new ArrayList<>();
        for (int i = differences.size()-1; i>differences.size()-nGroups ; i--) {
            nMaxDifferences.add(differences.get(i));
        }

        logger.debug("{} maximum differences = {}", nGroups-1, nMaxDifferences);

        //compute the breakpoints to group
        ArrayList<Integer> breakPoints = new ArrayList();
        int lastIndex = differences.size()-1;

        for (int i = 0; i < nGroups-1; i++) {
            boolean flag = true;
            int j;
            for ( j = lastIndex; j > 0 && flag; j--) {
                int x=ordNumbers.get(j+1) - ordNumbers.get(j );
                if(nMaxDifferences.contains(x)){
                    breakPoints.add(ordNumbers.get(j));
                    lastIndex = j-1;

                    differences.remove(differences.indexOf(x));
                    flag = false;
                }
            }
        }

        //sort breakpoints
        Collections.sort(breakPoints);
        logger.debug("Break points to group = {} "+breakPoints);

        for (int i = 0; i < numbers.size(); i++) {
            int current = numbers.get(i);
            boolean flag = true;
            for (int j = 0; j < nGroups-1 && flag; j++) {
                if (current <= breakPoints.get(j)){
                    res.get(j).add(current);
                    flag = false;
                }
            }
            if (current>breakPoints.get(breakPoints.size()-1))
                res.get(nGroups-1).add(current);
        }

        logger.debug("result = {} ", res);

        return res;
    }
}
