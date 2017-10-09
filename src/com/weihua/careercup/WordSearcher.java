package com.weihua.careercup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WordSearcher {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide exactly two input file paths!");
        }

        WordSearcher searcher = new WordSearcher();
        searcher.search(args[0], args[1]);
    }

    public void search(String honeycombFilePath, String dictionaryFilePath) {
        BufferedReader honeycombReader = null;
        BufferedReader dictionaryReader = null;
        try {
            honeycombReader = new BufferedReader(new FileReader(honeycombFilePath));

            int level = parseLevelNumber(honeycombReader.readLine());
            Honeycomb honeycomb = createHoneyComb(level, honeycombReader);

            List<String> results = new ArrayList<String>();
            dictionaryReader = new BufferedReader(new FileReader(dictionaryFilePath));
            String word = null;
            while ((word = dictionaryReader.readLine()) != null) {
                boolean foundWord = searchWord(honeycomb, word);
                if (foundWord) {
                    results.add(word);
                }
            }
            
            Collections.sort(results);
            for (String result : results) {
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("Error reading files!");
            e.printStackTrace();
        } finally {
            try {
                honeycombReader.close();
            } catch (IOException e) {
                System.out.println("Error closing honey comb file handle.");
                e.printStackTrace();
            }
        }
    }

    private int parseLevelNumber(String line) {
        if (line == null ) {
            throw new IllegalArgumentException("Empty honeycomb file, nothing to do.");
        }
        int level = Integer.parseInt(line);
        if (level <= 0) {
            throw new IllegalArgumentException("Invalid level number in honeycomb file.");
        }
        return level;
    }

    private Honeycomb createHoneyComb(int level, BufferedReader honeycombReader) throws IOException {
        Honeycomb honeycomb = new Honeycomb(level);
        // Special case for the first level
        honeycomb.addLevel(new Level(new Cell(honeycombReader.readLine().charAt(0), 0, 0)));
        if (level == 1) {
            return honeycomb;
        }

        String line = null;
        for (int l = 1; l < level; l++) {
            line = honeycombReader.readLine();
            
            // Create cells
            List<Cell> newCellsForLevel = new ArrayList<Cell>();
            for (int i = 0; i < line.length(); i++) {
                newCellsForLevel.add(new Cell(line.charAt(i), l, i));
            }
            honeycomb.addLevel(new Level(newCellsForLevel, l));
            
            // Set neighbors 
            int cellNumAtLevel = line.length();
            for (int i = 0; i < cellNumAtLevel; i++) {
                // Set neighbors at the same level, each cell has two neighbors at its own level except level 0
                newCellsForLevel.get(i).addNeighbor(newCellsForLevel.get((i + 1) % cellNumAtLevel));
                newCellsForLevel.get(i).addNeighbor(newCellsForLevel.get((i - 1 + cellNumAtLevel) % cellNumAtLevel));

                // Set neighbors for previous level
                if (l == 1) {
                    // If dealing with level 1, then the previous level has just one node indexed at 0
                    Cell parentCell = honeycomb.getLevel(0).getCells().get(0);
                    newCellsForLevel.get(i).addNeighbor(parentCell);
                    parentCell.addNeighbor(newCellsForLevel.get(i));
                } else {
                    int previousLevelCellNum = honeycomb.getLevel(l-1).getCells().size();
                    if (i % l == 0) { 
                        // If i % level == 0, then i has only 1 neighbor at previous level
                        Cell parentCell = honeycomb.getLevel(l-1).getCells().get(i/l*(l-1));
                        newCellsForLevel.get(i).addNeighbor(parentCell);
                        parentCell.addNeighbor(newCellsForLevel.get(i));
                    } else {
                        // If i % level != 0, then i has 2 neighbors at previous level
                        Cell[] parentCells = new Cell[2];
                        for (int p = 0 ; p < 2; p++) {
                            parentCells[p] = honeycomb.getLevel(l-1).getCells().get(((i-1-i/l)+p + previousLevelCellNum) % previousLevelCellNum);
                            newCellsForLevel.get(i).addNeighbor(parentCells[p]);
                            parentCells[p].addNeighbor(newCellsForLevel.get(i));
                        }
                    }
                }
            }
        }
        return honeycomb;
    }

    private boolean searchWord(Honeycomb comb, String word) {
        for (int l = 0; l < comb.getLevels().size(); l++) {
            Level currentLevel = comb.getLevel(l);
            for (int i = 0; i < currentLevel.getCells().size(); i++) {
                Cell currentCell = currentLevel.getCells().get(i);
                boolean found = searchWord(word, 0, currentCell, new HashSet<Cell>());
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(String word, int wordIndex, Cell currentCell, 
                    HashSet<Cell> visited) {
        if (wordIndex == word.length()) {
            return true;
        }

        if (currentCell.getValue() != word.charAt(wordIndex)) {
            return false;
        } else {
            visited.add(currentCell);
        }

        if (currentCell.getNeighbors().size() == 0 && wordIndex == word.length() - 1) {
            return true;
        }

        for (Cell neighbor : currentCell.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                boolean subMatch = searchWord(word, wordIndex+1, neighbor, visited);
                if (subMatch) {
                    return true;
                }
            }
        }

        return false;
    }

    
    // Note: Below classes are normally defined in their separate files; however due to the way this program will be compiled,
    // They are defined as inner class now
    
    public class Honeycomb {

        private List<Level> levels;

        public Honeycomb(int totalLevel) {
            levels = new ArrayList<Level>(totalLevel);
        }

        public Level getLevel(int level) {
            return levels.get(level);
        }

        public List<Level> getLevels() {
            return this.levels;
        }
        
        public void addLevel(Level newLevel) {
            levels.add(newLevel);
        }

        public void print() {
            for (int i = 0; i < levels.size(); i++) {
                List<Cell> cells = levels.get(i).getCells();
                for (Cell cell : cells) {
                    System.out.print("value: " + cell.getValue() + "\t");
                    System.out.print("Neighbor: ");
                    for (Cell n : cell.getNeighbors()) {
                        System.out.print(n.getValue() + "\t");
                    }
                    System.out.println();
                }
            }
        }
    }

    public class Level {
        private List<Cell> cells = new ArrayList<Cell>();
        private int levelIndex;
        
        public Level(List<Cell> levelCells, int levelIndex) {
            this.cells = levelCells;
            this.levelIndex = levelIndex;
        }
        
        public Level(Cell onlyCell) {
            cells.add(onlyCell);
        }
        
        public List<Cell> getCells() {
            return cells;
        }

        public void setCells(List<Cell> cells) {
            this.cells = cells;
        }

        public void addCell(Cell newCell) {
            cells.add(newCell);
        }

        public int getLevelIndex() {
            return levelIndex;
        }

        public void setLevelIndex(int levelIndex) {
            this.levelIndex = levelIndex;
        }
    }
    
    public class Cell {

        private char value;
        private List<Cell> neighbors = new ArrayList<Cell>(6);
        private int level;
        private int indexInLevel;

        public Cell(char value, int level, int indexInLevel) {
            this.value = value;
            this.level = level;
            this.indexInLevel = indexInLevel;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public List<Cell> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(List<Cell> neighbors) {
            this.neighbors = neighbors;
        }

        public void addNeighbor(Cell newNeighbor) {
            this.neighbors.add(newNeighbor);
        }

        @Override
        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof Cell)) {
                return false;
            }
            
            Cell anotherCell = (Cell) object;
            return (this.level == anotherCell.level && this.indexInLevel == anotherCell.indexInLevel);
        }

        @Override
        public int hashCode() {
            int hashCode = 1;
            hashCode = hashCode * 31 + level;
            return hashCode * 31 + indexInLevel;
        }

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("value: ").append(this.value)
                        .append(" neighbors: ");
            for (Cell neighbor: neighbors) {
                stringBuffer.append(neighbor.getValue()).append("\t");
            }
            return stringBuffer.toString();
        }
    }
}
