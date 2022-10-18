
public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }


    public double distance(){
        double xDiff = x2-x1;
        double yDiff = y2-y1;

        return roundedToHundredth(Math.sqrt((Math.pow(xDiff, 2)) + Math.pow(yDiff,2)));
    }
    public double slope(){
        double xDiff = x2-x1;
        double yDiff = y2-y1;
        return roundedToHundredth(yDiff/xDiff);
    }
    public double yIntercept(){
        return roundedToHundredth(y1-(x1*slope()));
    }
    public String equation() {
        double xDiff = (x2 - x1);
        double yDiff = (y2 - y1);
        if (xDiff < 0){
            xDiff *= -1;
            yDiff *= -1;
        }
        if (yIntercept() == 0){
            return "y = " + yDiff/xDiff + "x";
        }
        if (slope() == 1){
            return  "y = " + "x";
        }
        if (yIntercept() < 0) {
            if (yDiff % xDiff == 0){
                return "y = " + yDiff/xDiff + "x" + " + " + Math.abs(yIntercept());
            }
            return "y = " + yDiff + "/" + xDiff + "x" + " - " + Math.abs(yIntercept());
        }
        if (yIntercept() > 0){
            if (yDiff % xDiff == 0){
                return "y = " + yDiff/xDiff + "x" + " + " + (yIntercept());
            }
            return "y = " + yDiff + "/" + xDiff + "x" + " + " + yIntercept();
        }
        return "";
    }
    public String coordinateForX(double xValue){
        double y = (xValue*slope() + yIntercept());
        return "(" +  xValue + ", " + y + ")";
    }
    public double roundedToHundredth(double toRound){
        return (double)(Math.round(toRound * 100))/100;
    }
    public  String lineInfo(){
        return "The two points are: (" + x1 + ", " + y1 + ")" +  " and (" + x2 + ", " + y2 + ")" + "\n"
                + "The equation of the line between these two points is " + equation() + "\n"
                + "The slope of the line is " + slope() + "\n" + "The y-intercept of the line is " + yIntercept() + "\n"
                + "The distance between the two points is " + distance();
    }




}