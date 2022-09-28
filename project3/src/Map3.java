public class Map3 {
    //Return a 2D array of the entrance where our Adventures start
    private int[][] lv0(){
        int[][] room0 = {{0,1,1}};
        return room0;
    }
    //Returns a 2D array of the 1st level
    private int[][] lv1(){
        int[][] room1 = {
                {1,0,0}, {1,0,1}, {1,0,2},
                {1,1,0}, {1,1,1}, {1,1,2},
                {1,2,0}, {1,2,1}, {1,2,2}
        };
        return room1;
    }
    //Returns a 2D array of the 2nd level
    private int[][] lv2(){
        int[][] room2 = {
                {2,0,0}, {2,0,1}, {2,0,2},
                {2,1,0}, {2,1,1}, {2,1,2},
                {2,2,0}, {2,2,1}, {2,2,2}
        };
        return room2;
    }
    //Returns a 2D array of the 3rd level
    private int[][] lv3(){
        int[][] room3 = {
                {3,0,0}, {3,0,1}, {3,0,2},
                {3,1,0}, {3,1,1}, {3,1,2},
                {3,2,0}, {3,2,1}, {3,2,2}
        };
        return room3;
    }
    //Returns a 2D array of the 4th level
    private int[][] lv4(){
        int[][] room4 = {
                {4,0,0}, {4,0,1}, {4,0,2},
                {4,1,0}, {4,1,1}, {4,1,2},
                {4,2,0}, {4,2,1}, {4,2,2}
    };
    return room4;
    }

    public int[][][] allfloors(){
        return new int[][][] {lv0(), lv1(), lv2(), lv3(), lv4()};
    }


}
