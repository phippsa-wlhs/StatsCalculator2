import java.util.Arrays;
/**
 * @file StatsCalculator.java
 * @Date 3/16/23
 * @Author Andrew Phipps
 *
 * @Description identifies the array and sorts it then finds minimum, first quartile, median, third quartile, maximum, and mean
 */
public class StatsCalculator {
    /**
     * @description creates double array of values
     */
    private double[] values;
    /**
     * @description creates double array of sortedValues
     */
    private double[] sortedValues;

    /**
     * @description creates an array of 20 with 0 as the default value
     */
    public StatsCalculator(){
        double values[] = new double[20];
    }

    /**
     * @description sets values equal to values in the runner
     * @param values
     */
    public StatsCalculator(double[] values){
        this.values = values;
    }

    /**
     * @description calls and returns an array with commas in between
     */
    public void print(){
        for(double value: values){
            System.out.print(value + ", ");
        }
    }
    /**
     * @description calls and returns a sorted array with commas in between
     */
    public void printSorted(){
        sortedValues = new double [values.length];
        for(int i = 0; i < values.length; i++){
            sortedValues[i] = values[i];
        }
        Arrays.sort(sortedValues);
        for(double value: sortedValues){
            System.out.print(value + ", ");
        }
        System.out.println();
    }

    /**
     * @description finds the max in the sorted array and returns it
     * @return max of the array
     */
    public double calculateMax(){
        if(sortedValues.length == 0){
            return Integer.MIN_VALUE;
        }
        double max = sortedValues[0];
        for(double value: sortedValues){
            if(value > max){
                max = value;
            }
        }
        return max;
    }

    /**
     * @description finds the min of the sorted array and returns it
     * @return min of the array
     */
    public double calculateMin(){
        if(sortedValues.length == 0){
            return Integer.MAX_VALUE;
        }
        double min = sortedValues[0];
        for(double value: sortedValues){
            if(value < min){
                min = value;
            }
        }
        return min;
    }
    /**
     * @description finds the first quartile of the sorted array
     * @return the first quartile
     */
    public double calculateFirstQuartile(){
        double first;
        if(sortedValues.length % 4 == 0) { //even length mod 4
            first = (sortedValues[(sortedValues.length / 4) - 1] + sortedValues[(sortedValues.length / 4)]) / 2;
            //first = sortedValues[(int)(sortedValues.length * .25)];
        }else if(sortedValues.length % 2 == 0) { // even length mod 2
            first = sortedValues[(sortedValues.length / 4)] ;
        }else{ // odd length
            first = sortedValues[sortedValues.length / 4];
            //first = sortedValues[(int) (sortedValues.length *.25)];
        }
        return first;
    }

    /**
     * @description finds the third quartile of the sorted array
     * @return the third quartile
     */
    public double calculateThirdQuartile(){
        double third;
        if(sortedValues.length % 4 == 0) { // even length
            third = (sortedValues[(sortedValues.length / 4) + (sortedValues.length / 2) - 1] + sortedValues[(sortedValues.length / 4) + (sortedValues.length / 2)]) / 2;
            //third = sortedValues[(int) (sortedValues.length * .75)-1];
        }else if(sortedValues.length % 2 == 0) { // even length mod 2
            third = sortedValues[(sortedValues.length / 4)+ (sortedValues.length / 2)];
        }else{ // odd length
            third = sortedValues[(sortedValues.length / 4) + (sortedValues.length/2)+1];
            //third = sortedValues[(int) (sortedValues.length * .75)];
        }
        return third;
    }

    /**
     * @description finds the median of the sorted array
     * @return the median
     */
    public double calculateMedian(){
        double median;
        if(sortedValues.length % 2 == 0){
            median = (sortedValues[sortedValues.length / 2] + sortedValues[sortedValues.length / 2 - 1]) /2;
        }else{
            median = sortedValues[sortedValues.length / 2];
        }
        return median;
    }

    /**
     * @description finds the sum of the sorted array
     * @return the sum
     */
    public double  calculateSum(){
        int sum = 0;
        for(int i = 0; i < sortedValues.length; i++){
            sum += sortedValues[i];
        }
        return sum;
    }

    /**
     * @description finds the mean of the sorted array
     * @return the mean
     */
    public double calculateMean(){
        double sum = 0;
        double mean = 0;
        for(int i = 0; i < sortedValues.length; i++){
            sum += sortedValues[i];

        }
        mean = sum/sortedValues.length;
        return mean;
    }

    /**
     * @description prints out the five number summary which is the minimum, first quartile, median, third quartile, and maximum
     */
    public void printFiveNumberSummary(){
        System.out.println("\tMinimum: " + calculateMin());
        System.out.println("\tFirst quartile: " + calculateFirstQuartile());
        System.out.println("\tMedian: " + calculateMedian());
        System.out.println("\tThird quartile: " + calculateThirdQuartile());
        System.out.println("\tMaximum: " + calculateMax());
    }
}