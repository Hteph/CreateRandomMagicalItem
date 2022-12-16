package com.github.hteph.createthings.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author Mikael Hansson {@literal <mailto:mikael.hansson@so4it.com/>}
 */
public class Table {

    private final Map<Integer,TableLine> tableLines;
    private final String name;
    private final String description;
    
    Random random = new Random();

    public Table(String name, String description) {

        this.name = name;
        this.description = description;

        tableLines = new HashMap<>();
    }

    public String getTableLine(Integer number) {
        TableLine tableLine;
        boolean found = false;

        do {
            tableLine = tableLines.get(number);
            if(tableLine !=null) found = true;
            if(number>0) number--;
            else {
                tableLine = getFirst();
                found = true;
            }
        }while (!found);

        return description+" "+ (tableLine != null ? tableLine.getDescription() : "");
    }

    public String getDescriptiveLine() {

        return getDescription()+" "+ getRandomLine().getDescription();
    }

    private TableLine getFirst() {

        TreeSet<Integer> keyList = new TreeSet<>(tableLines.keySet());

        return tableLines.get(keyList.first());

    }

    public void addTableLine(TableLine tableLine) {

        tableLines.put(tableLine.getNumber(),tableLine);
    }

    public String getName() {

        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRandomLineWithoutHeader() {

        return getRandomLine().getDescription();
    }

    private TableLine getRandomLine() {
        
        TableLine tableLine;
        boolean found = false;
        TreeSet<Integer> keyList = new TreeSet<>(tableLines.keySet());
        int number = random.nextInt(keyList.size());

        do {
            tableLine = tableLines.get(number);
            if (tableLine != null) found = true;
            if (number > 0) number--;
            else {
                tableLine = getFirst();
                found = true;
            }
        } while (!found);
        
        return tableLine;
    }
}