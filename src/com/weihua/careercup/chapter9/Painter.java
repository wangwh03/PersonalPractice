package com.weihua.careercup.chapter9;

public class Painter {

    public static void main(String[] args) {
        Painter test = new Painter();
        
        int[][] map = {{1,1,0,2,0,3},
                       {1,1,0,2,3,3},
                       {1,1,0,2,4,4},
                       {0,1,0,2,2,4}};
        test.printMap(map);
        test.paint(map, 7, 0, 1);
        System.out.println();
        test.printMap(map);
        
        test.paint(map, 8, 0, 3);
        System.out.println();
        test.printMap(map);
    }
    
    public void paint(int[][] map, int newColor, int startX, int startY) {
        paint(map, newColor, map[startX][startY], startX, startY);
    }
    
    public void paint(int[][] map, int newColor, int startPointColor, int currentX, int currentY) {
        if (currentX < 0 || currentX >= map.length 
                        || currentY < 0 || currentY >= map[0].length) {
            return;
        }
        
        if (map[currentX][currentY] == startPointColor 
                        && map[currentX][currentY] != newColor) {
            map[currentX][currentY] = newColor;
            paint(map, newColor, startPointColor, currentX - 1, currentY);
            paint(map, newColor, startPointColor, currentX + 1, currentY);
            paint(map, newColor, startPointColor, currentX, currentY - 1);
            paint(map, newColor, startPointColor, currentX, currentY + 1);
        }
    }
    
    public class Point {
        private int x;
        private int y;
        private int color;
        
        public Point(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public int getColor() {
            return color;
        }
    }
    
    public void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
