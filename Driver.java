import java.util.Scanner; //may be necessary for input

import javax.swing.JOptionPane; //may be necessary for input

import kareltherobot.*;

public class Driver implements Directions {
    // declared here so it is visible in all the methods!!
    // It will be assigned a value in the getInfo method
    private static Robot roomba;
    static Directions.Direction dir;

    // You will add very many variables!!

    // Converts a direction string to the corresponding integer constant

    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        Driver d = new Driver();
        String streetString = JOptionPane.showInputDialog("Enter the starting street for Karel:");
        int street = Integer.parseInt(streetString);
        String avenueString = JOptionPane.showInputDialog("Enter the starting avenue for Karel:");
        int avenue = Integer.parseInt(avenueString);
        roomba = new Robot(street, avenue, East, 0); // 0 beepers in bag

        /**
         * This section of code gets info from the user in the following order: 1. Ask
         * the user
         * which world file they wish to process. Right now, that world file name is
         * hardcoded in. 2. Ask the user for the starting location and direction of the
         * Robot. A new Robot should be constructed and assigned to the global
         * (instance) variable named roomba that is declared on line 10.
         * 
         * An inelegant way to interact with the user is via the console, using
         * System.out.println and a Scanner that scans System.in (input from the
         * console). A more elegant way to get user input might include using a
         * JOptionPane.
         */

        String wrldName = "basicRoom.wld";

        World.readWorld(wrldName);
        World.setVisible(true);

        /**
         * This section will have all the logic that takes the Robot to every location
         * and cleans up all piles of beepers. Think about ways you can break this
         * large, complex task into smaller, easier to solve problems.
         */

        // the line below causes a null pointer exception
        // what is that and why are we getting it?

        // first check the current direction, then move towards top left corner

        System.out.println("World.beepers()" + World.beepers());
        if (roomba.facingEast()) {
            roomba.turnLeft();
            roomba.turnLeft();
        } else if (roomba.facingNorth()) {
            roomba.turnLeft();
        } else if (roomba.facingSouth()) {
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.turnLeft();
        }
        while (roomba.frontIsClear()) {
            roomba.move();
        }

        // turn left three times to look north
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
        while (roomba.frontIsClear()) {
            roomba.move();
        }
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();

        // now zig zag roomba across the room
        int totalBeepers = 0;
        int beeperPiles = 0;
        int largestPile = 0;
        int largestPileX = 0;
        int largestPileY = 0;

        int height = 1;
        int actualWidth = 0;
        boolean goingEast = true;

        while (true) {
            int innerWidth = 0;
            while (true) {
                if (roomba.nextToABeeper()) {
                    int innerBeepers = 0;
                    beeperPiles += 1;
                    while (roomba.nextToABeeper()) {
                        roomba.pickBeeper();
                        innerBeepers += 1;
                    }
                    if (innerBeepers > largestPile) {
                        largestPile = innerBeepers;
                        largestPileX = innerWidth;
                        largestPileY = height;
                    }
                    totalBeepers += innerBeepers;
                }
                if (!roomba.frontIsClear())
                    break;
                roomba.move();
                innerWidth += 1; // Only increment after a successful move
            }
            actualWidth = Math.max(actualWidth, innerWidth);

            // Try to move down to the next row
            if (goingEast) {
                roomba.turnLeft();
                roomba.turnLeft();
                roomba.turnLeft();
                if (!roomba.frontIsClear())
                    break;
                roomba.move();
                roomba.turnLeft();
                roomba.turnLeft();
                roomba.turnLeft();
            } else {
                roomba.turnLeft();
                if (!roomba.frontIsClear())
                    break;
                roomba.move();
                roomba.turnLeft();
            }
            height += 1;
            goingEast = !goingEast;
        }

        /**
         * This method displays the results of cleaning the room. All of the info
         * in the pdf that describes the problem need to be displayed. You can present
         * this info in the console (boring) or you can present using JOptionPane
         * (cool!)
         */

        int area = height * (actualWidth + 1);
        System.out.println("The area is: " + area);
        System.out.println("The total number of piles is: " + beeperPiles);
        System.out.println("The total number of beepers is: " + totalBeepers);
        System.out.println("Largest pile location: right " + largestPileX + " and down " + (largestPileY-1));
        System.out.println("Average pile size: " + (beeperPiles == 0 ? 0 : (double) totalBeepers / beeperPiles));
        System.out.println("Percent dirty: " + (area == 0 ? 0 : (double) beeperPiles / area));
        System.out.println("The largest pile was " + largestPile + " beepers");
    }
}
