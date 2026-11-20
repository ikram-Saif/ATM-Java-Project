import java.util.Scanner;

public class Atm{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pin = 1234;
        int pinTry =0;
        int depositCount = 0;
        int withdrawCount = 0;
        double initialBalance = 2500.75;
        while(pinTry < 3){
            System.out.println("Enter your PIN");
            int userpin = scan.nextInt();
           
            if(userpin == pin){
                pinTry = 0;
                 int choice ;
                 do{
                    System.out.println("======ATM========");
                    System.out.println("1-Check Balance\n 2-Deposit\n 3-Withdrwal\n 4-Show Account Status \n 5-Exit\n");
                    System.out.println("==================");
                    choice = scan.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Your balance is: " + initialBalance);
                            break;
                        case 2:
                            System.out.println("Enter the amount to deposit: ");
                            double depositAmount = scan.nextDouble();
                            if(depositAmount == 0){
                                System.out.println("Transaction cancelled.");
                                break;
                            } else if(depositAmount <= 0){
                                System.out.println("Invalid deposit amount. Please enter a positive value.");
                            } else {
                                initialBalance += depositAmount;
                                System.out.println("Deposit successful. New balance: " + initialBalance);
                                depositCount++;
                            }
                            break;
                        case 3:
                            System.out.println("Enter the amount to withdraw: ");
                            double withdrawAmount = scan.nextDouble();
                            if(withdrawAmount <= 0 || withdrawAmount > initialBalance){
                                System.out.println("Invalid withdrawal amount. Please enter a positive value less than or equal to your balance.");
                            } else {
                                initialBalance -= withdrawAmount;
                                System.out.println("Withdrawal successful. New balance: " + initialBalance);
                                withdrawCount++;
                            }
                            break;
                        case 4:
                            if(initialBalance >= 5000){
                                System.out.println("You Are VIP Customer.");
                            }else if(initialBalance >= 1000 && initialBalance < (5000 -1))
                            {
                                System.out.println("You Are Regular Customer.");
                             } 
                            else if(initialBalance < 1000){
                                System.out.println("You Are Low Balance Customer.");
                            } 
                            break;
                        case 5:
                            System.out.println("Thank you for using our ATM. Goodbye!");
                            System.out.println("Deposit Count: " + depositCount);
                            System.out.println("Withdrawal Count: " + withdrawCount);
                            break;

                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                            break;
                    }


                }while(choice != 5);
                

            }else pinTry++;

        }
        if(pinTry == 3){
            System.err.println("Your Account Has Been Blocked");
        }
        scan.close();

    }
}