import java.util.Scanner;
import java.text.*;

public class StockProfit {

    public static void main (String[]args){
        //Create a scan object for taking input from user.
        Scanner scan = new Scanner(System.in);
        //Give user a message for entering a buying price.
        System.out.println("Enter the buying price:");
        //Taking input from user and assign this input to the buyingPrice variable.
        double buyingPrice= scan.nextDouble();

        int day=1;

        //This decimalFormat object use for formatting the decimals in one integer two double type.
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

            while(true){
                System.out.println("Enter the closing price for day:"+ day +"(Any negative value to leave)");
                //Taking input from user and assign this input to the closingPrice variable.
                double closingPrice=scan.nextDouble();
                //We should end the loop so if user types negative closingPrice loop will end.
                if(closingPrice<0.0) break;
                //For calculating the total profit/loss  we subtract the last price and buy price of stock.
                double earnings=closingPrice-buyingPrice;
                //Prints the profit per share
                if(earnings>0.0){
                         System.out.println("After day " + day +" you earned "+ decimalFormat.format(earnings)+" per share ");
                }
                //Prints the loss per share
                else if (earnings<0.0){
                    System.out.println("After day "+ day +" you lost  "+ decimalFormat.format(-earnings)+"per share");
                }
                //Triggers if the buyingPrice==closingPrice.
                else {
                    System.out.println("After day "+ day +" you don't earn anything ");
                }
                //Increment the day
                day+=1;
            }

            scan.close();
    }
}
