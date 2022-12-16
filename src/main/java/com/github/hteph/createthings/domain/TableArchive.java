package com.github.hteph.createthings.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class TableArchive {

    private static final Map<String, Table> archive;

    static {
      archive = new HashMap<>();
    }

    public static void addToArchive(Table table){

        if(table != null) archive.put(table.getName().toUpperCase(),table);

    }

    public static Table getTable(String name){

        if(name == null || name.isEmpty()) return getRandomTable();

        Table table = archive.get(name.toUpperCase());

        if(table == null) System.out.println("Error in finding table: "+name);
        return table;
    }

    private static Table getRandomTable(){

        List<String> keySet = new ArrayList<>(archive.keySet());

        int number = (int) (Math.random()*keySet.size());

        return getTable(keySet.get(number));
    }

    public static Set<String> listAllTables() {

        Set<String> test = archive.keySet();

        return new TreeSet<>(archive.keySet());
    }
}
