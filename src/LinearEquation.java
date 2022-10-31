
public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    //Constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /* Calculates the distance by finding the difference between the two x and y coordinates, squaring them, then adding them,
    and finally taking the square root of that number
     */
    public double distance(){
        double xDiff = x2-x1;
        double yDiff = y2-y1;

        return roundedToHundredth(Math.sqrt((Math.pow(xDiff, 2)) + Math.pow(yDiff,2)));
    }

    /* Finds the slope by finding the difference between the x and y coordinates, then dividing the y difference by
    the x difference
     */
    public double slope(){
        double xDiff = x2-x1;
        double yDiff = y2-y1;
        return roundedToHundredth(yDiff/xDiff);
    }

    /* Finds the y-intercept by subtracting the slope multiplied by the first x-coordinate from the first y-coordinate
     */
    public double yIntercept(){

        return roundedToHundredth(y1-(x1*slope()));
    }

    public String equation() {
        int xDiff = (int)(x2 - x1);
        int yDiff = (int)(y2 - y1);
        // Accounts for when the denominator is negative by multiplying both the x and y difference by -1
        if (xDiff < 0){
            xDiff *= -1;
            yDiff *= -1;
        }

        if (slope() == 1){      // If statements that return y = x instead of y = 1x
            if (yIntercept() == 0){
                return "y = " + "x";
            }
            return  "y = " + "x" + " + " + yIntercept();
        }
        if (slope() == -1){     // If statements that return y = -x instead of y = -1x
            if (yIntercept() == 0){
                return "y = -" + "x";
            }
            return  "y = -" + "x" + " + " + yIntercept();
        }
        if (slope() == 0){      // Returns y-intercept instead of 0x + y-intercept
            return  "y = " + (int) yIntercept();
        }
        if (yIntercept() == 0){     // Prints out the slope as a fraction by concating strings and ints
            if (yDiff % xDiff == 0){
                return "y = " + yDiff/xDiff + "x";      // Prints the slope as an integer when its divisible
            }
            return "y = " + yDiff + "/" + xDiff + "x";
        }
        if (yIntercept() < 0) {     // Prints y-intercept as negative
            if (yDiff % xDiff == 0){
                return "y = " + yDiff/xDiff + "x" + " - " + Math.abs(yIntercept());
            }
            return "y = " + yDiff + "/" + xDiff + "x" + " - " + Math.abs(yIntercept());
        }
        if (yIntercept() > 0){
            if (yDiff % xDiff == 0){
                return "y = " + yDiff/xDiff + "x" + " + " + yIntercept();
            }
            return "y = " + yDiff + "/" + xDiff + "x" + " + " + yIntercept();
        }
        return "";
    }

    // Finds the new y-coordinate by multiplying the x value the user inputs with the slope and adding the y-intercept
    public String coordinateForX(double xValue){
        double y = (xValue*slope() + yIntercept());
        return "(" +  xValue + ", " + y + ")";
    }


    public double roundedToHundredth(double toRound){
        return (double)(Math.round(toRound * 100))/100;
    }

    // Prints everything
    public String lineInfo(){
        return "The two points are: (" + x1 + ", " + y1 + ")" +  " and (" + x2 + ", " + y2 + ")" + "\n"
                + "The equation of the line between these two points is: " + equation() + "\n"
                + "The slope of the line is: " + slope() + "\n"
                + "The y-intercept of the line is: " + yIntercept() + "\n"
                + "The distance between the two points is: " + distance();
    }
}