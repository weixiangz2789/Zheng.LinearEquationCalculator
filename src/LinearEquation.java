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
        return Math.sqrt((Math.pow(xDiff, 2)) + Math.pow(yDiff,2));
    }
    public double slope(){
        double slope = (y2-y1)/(x2-x1);
    }
    public double yIntercept(){
        double slope = (y2-y1)/(x2-x1);

    }



}