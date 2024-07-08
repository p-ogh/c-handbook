package testdome.java;

//wrong incomplete
public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {

       boolean canTravel = gameMatrix[fromRow][fromColumn];
        //figure out direction



        if(fromRow == toRow) {
            //boot is going left or right
            boolean[] row = gameMatrix[fromRow];
            if (toColumn > row.length) {
                canTravel = false;
            }else{

            if (fromColumn > toColumn) {
                //boat is going left
                for (int i = fromColumn; i >= toColumn; i--) {
                    if (row[i]) {
                        continue;
                    } else {
                        canTravel = row[i];
                        break;
                    }

                }
            } else {
                //boat is going right
                for (int i = fromColumn; i <= toColumn; i++) {
                    if (row[i]) {
                        continue;
                    } else {
                        canTravel = row[i];
                        break;
                    }

                }
            }
        }

        }
        else {
            if (toRow > gameMatrix.length) {
                canTravel = false;
            }else{
            //boot is going up or down

            if (fromRow > toRow) {
                //boat is going up
                for (int i = fromRow; i >= toRow; i--) {
                    if (gameMatrix[i][toColumn]) {
                        continue;
                    } else {
                        canTravel = false;
                        break;

                    }
                }


            } else {
                //boat is going down
                //boat is going up
                for (int i = fromRow; i <= toRow; i++) {
                    if (gameMatrix[i][toColumn]) {
                        continue;
                    } else {
                        canTravel = false;
                        break;

                    }
                }
            }
        }
        }


        return canTravel;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
                {false, true,  true,  false, false, false},
                {true,  true,  true,  false, false, false},
                {true,  true,  true,  true,  true,  true},
                {false, true,  true,  false, true,  true},
                {false, true,  true,  true,  false, true},
                {false, false, false, false, false, false},
        };

        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
}
