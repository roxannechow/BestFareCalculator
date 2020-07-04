import java.util.Arrays;

public class TransitCalculator {
  String[] options = {"Pay-per-ride", "7-day Unlimited Rides", "30-day Unlimited Rides"};
    double[] fares = {2.75, 33, 127};
  int days;
  int rides;

  public TransitCalculator (int numberOfDays, int numberOfRides){
    days = numberOfDays;
    rides = numberOfRides;
  }
  public int numberOf30Days(){
    int numberOf30DayPass;
    if (days <= 21) {
      numberOf30DayPass = 0;
    }
    else if (days > 21 & days <= 30 ){
     numberOf30DayPass = 1;}
    else if (days % 30 == 0) {
      numberOf30DayPass = days / 30;
      }
    else {
      numberOf30DayPass = days / 30 + 1; }
    return numberOf30DayPass;
  }
  
  public int numberOf7Days(){
    int numberOf7DayPass;
    if (days % 30 == 0 | days % 30 / 7 > 3){
     numberOf7DayPass = 0;}
     else if (days > 21 & days <= 30){
     numberOf7DayPass = 0;}
    else {
      int remainingDays = days - ((days / 30) * 30);
      if (remainingDays% 7 ==0) {
        numberOf7DayPass = remainingDays / 7;
      }
      else {
        numberOf7DayPass = remainingDays / 7 + 1;
    } 
    }
  return numberOf7DayPass;
}

 // public double unlimited7Price(){
  //  int weeks;
   // if (days % 7 ==0) {
  //    weeks = days / 7;
  //  }
  //  else {
  //    weeks = days / 7 + 1;
  //  }
  //  double total = weeks * fares[1];
//    double price7DayPerRide = total / rides;
 //   return price7DayPerRide;
 // }

  public double getRidePrices(){
    double pricePerRide;
    int numberOf7DayPass = numberOf7Days();
    int numberOf30DayPass = numberOf30Days();
    double unlimited30Price = numberOf30DayPass * fares[2];
    double unlimited7Price = numberOf7DayPass * fares[1];
    pricePerRide = (unlimited30Price + unlimited7Price) / rides;
    return pricePerRide;
  }

  public String getBestFare(){
    double ridePrice = getRidePrices();
    double lowestPrice;
    int numberOf7DayPass;
    int numberOf30DayPass;
    if (ridePrice < fares[0]){
      lowestPrice = ridePrice;
      numberOf7DayPass = numberOf7Days();
      numberOf30DayPass = numberOf30Days();
      if (numberOf30DayPass == 0 & numberOf7DayPass != 0){
    return "You should get " + numberOf7DayPass + " of the " + options[1] + ", the option at $" + lowestPrice + " per rides.";
  }
  else if (numberOf30DayPass != 0 & numberOf7DayPass == 0){
    return "You should get " + numberOf30DayPass + " of the " + options[2] + ", the option at $" + lowestPrice + " per rides.";
  }
  else {
     return "You should get " + numberOf30DayPass + "of the " + options[2] + " and " + numberOf7DayPass + "of the " + options[1] + " , the option at $" + lowestPrice + " per rides." ;
  }}
    else {
    lowestPrice = fares[0];
    numberOf30DayPass = 0;
    numberOf7DayPass = 0;
    return "You should get the " + options[0] + ", the option at $" + lowestPrice + " per rides.";
    }
  }

  public static void main (String[] args){
    
    TransitCalculator fareCalculator = new TransitCalculator(6, 50);
    System.out.println(fareCalculator.getBestFare());
  }

}