import java.util.Scanner;

public class Safeinput {
    Scanner console = new Scanner(System.in);

    /**
     * Return a user supplied int within the specified range
     *
     * @param pipe   The Scanner instance to use for the console input
     * @param prompt A String that tells the user what to input
     * @param low    the lower bound for the range of valid values
     * @param high   the upper bound for the range of values
     * @return an integer within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = low - 1;
        boolean done = false;
        String trash = "";

        do {
            //favorite number 1-10
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); //clear the new line from the buffer
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You said the number is " + retVal + " but that is out of range [" + low + " - " + high + "]: ");
                }
            } else // don't have an int
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Takes a Y or an N and returns true or false respectively
     *
     * @param pipe   Scanner to use for console input
     * @param prompt String
     * @return A boolean true or false based on the Y or N input
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retVal = false;
        boolean done = false;
        String inputYN = "";

        do {
            System.out.print(prompt + ": [Y/N] ");
            inputYN = pipe.nextLine();
            if (inputYN.equalsIgnoreCase("Y")) {
                done = true;
                retVal = false;
            } else if (inputYN.equalsIgnoreCase("N")) {
                done = true;
                retVal = false;
                System.exit(0);
            } else {
                System.out.println("You must enter Y or N:");
            }

        } while (!done);

        return retVal;
    }
}