package com.mindera;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("############### START ###############\n");
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67));
        System.out.println("group in 5 the list = "+l+"\n");
        GroupsGP groups = new GroupsGP();
        System.out.println("Res = "+groups.groups(l, 5));
        System.out.println("\n################ END ################");

        System.exit(0);
    }
}
