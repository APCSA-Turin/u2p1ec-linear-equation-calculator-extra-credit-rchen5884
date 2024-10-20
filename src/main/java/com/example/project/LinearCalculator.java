package com.example.project;
public class LinearCalculator {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //4 INTEGER variables (name them: x1,x2,y1,y2) 



    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){
    // Parse the first coordinate string
        String firstCoord = coord1.substring(1, coord1.length() - 1); // remove parentheses
        int x1 = Integer.parseInt(firstCoord.substring(0,firstCoord.indexOf(","))); // parse the x1 value
        int y1 = Integer.parseInt(firstCoord.substring(firstCoord.indexOf(",") + 1)); // parse the x2 value
    // Parse the second coordinate string
        String secondCoord = coord2.substring(1, coord2.length() - 1); 
        int x2 = Integer.parseInt(secondCoord.substring(0,secondCoord.indexOf(","))); 
        int y2 = Integer.parseInt(secondCoord.substring(secondCoord.indexOf(",") + 1)); 
    // This will assign the parsed values to instance variables
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    


    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){
        return x1;
    }
    public int getY1(){
        return y1;
    }

    public int getX2(){
        return x2;
    }
    public int getY2(){
        return y2;
    }
    public void setX1(int newX1){
        x1 = newX1;
    }
    public void setY1(int newY1){
        y1 = newY1;

    }
    public void setX2(int newX2){
        x2 = newX2;
    }
    public void setY2(int newY2){
        y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        // Calculate using the Distance formula
        double tempX = Math.pow(x2 - x1, 2);
        double tempY = Math.pow(y2- y1, 2);
        double d = Math.sqrt(tempX + tempY);
        d = Math.round(d * 100.0) / 100.0;
        return d;
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
    // if there is no y intercept
        if (x1 == x2) {
            return -999.99;
        }

        double b = y1 - slope() * x1;
        b = Math.round(b * 100.0) / 100.0;
        return b;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        // Calculate using the slope formula
    // if there is no slope
        if (x1 == x2) {
            return -999.99;
        }

        double numerator = y2 - y1;
        double denominator = x2 - x1;
        double slope = numerator/denominator;
        slope = Math.round(slope * 100) / 100.0;
        return slope;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
    // if there is no slope, return undefined
        if (slope() == -999.99) {
            return "undefined";
        }

        if (yInt() < 0) {
            return "y=" + slope() + "x" + yInt();
        }
        // if the y intercept is 0, don't need to print it
        if (yInt() == 0) {
            return "y=" + slope() + "x";
        }
        // if the slope is 0, dont need to print it
        if (slope() == 0) {
            return "y=" + yInt();
        }


        return "y=" + slope() + "x+" + yInt();
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        x = Math.round(x * 100.0) / 100.0;
        return x;
    }

    public String Midpoint() {
        double avgX = (x1 + x2) / 2.0;
        double avgY = (y1 + y2) / 2.0;
        return "The midpoint of this line is: (" + avgX + "," + avgY + ")";
    }
    

    public String findSymmetry() {
        if (x1 == -x2 && y1 == -y2) {
            return "Symmetric about the origin";
        } else if (x1 == -x2) {
            return "Symmetric about the y-axis";
        } else if (y1 == -y2) {
            return "Symmetric about the x-axis";
        } 
        return "No symmetry";
    }
    
    

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
 
        return str;
    }
}