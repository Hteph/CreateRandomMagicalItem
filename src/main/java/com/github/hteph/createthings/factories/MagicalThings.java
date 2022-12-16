package com.github.hteph.createthings.factories;

import com.github.hteph.createthings.domain.TableArchive;

import java.util.Random;

public class MagicalThings {
    public MagicalThings() {}
    
    public String getArtefactBaseText() {
        Random random = new Random();
        final String ADJECTIVE = "adjective";
        final String FEATURE = "feature";
        final String PURPOSE = "purpose";
        final String SHAPE = "shape";
        
        int number = random.nextInt(12);
        return "A Magical Artifact: " +
    
            switch (number) {
                case 0 -> TableArchive.getTable(ADJECTIVE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + "\n";
                case 1 -> TableArchive.getTable(PURPOSE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + "\n";
                case 2 -> TableArchive.getTable(ADJECTIVE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(PURPOSE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + "\n";
                case 3 -> TableArchive.getTable(ADJECTIVE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + "\n";
                case 4 -> TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + "\n";
                case 5 -> TableArchive.getTable(PURPOSE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + "\n";
                case 6 -> TableArchive.getTable(PURPOSE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + "\n";
                case 7 -> TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + "\n";
                case 8 -> TableArchive.getTable(ADJECTIVE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(PURPOSE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + "\n";
                case 9 -> TableArchive.getTable(PURPOSE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + "\n";
                case 10 -> TableArchive.getTable(FEATURE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + "\n";
                case 11 -> TableArchive.getTable(PURPOSE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + " " +
                    TableArchive.getTable(SHAPE).getRandomLineWithoutHeader() + "\n";
                default -> "UNKNOWN ERROR";
            };
    }
}