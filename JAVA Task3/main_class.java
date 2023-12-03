import java.util.Scanner;
interface user{
    public void withdraw(double amount);
    public void deposit(double amount);
    public void checkBalance();
}

class ATM_machine{
    public static void withdraw(double amount){
        if ((amount>0)&&(amount <= bank_account.balance)){
            bank_account.balance -= amount;
            System.out.println("Amount withdrawn : "+amount);
            System.out.println("Transaction successful...");
        }
        else{
            System.out.println("Insufficient funds or invalid amount entered");
            System.out.println("Transaction failed!...");
        }
    }
    public static void deposit(double amount){
        if (amount>0){
            bank_account.balance += amount;
            System.out.println("Amount deposited : "+amount);
            System.out.println("Transaction successful...");
        }
        else{
            System.out.println("Invalid amount for deposit");
            System.out.println("Transaction failed!...");
        }
    }
    public static double checkBalance(){
        return bank_account.balance;
    }
}

class bank_account extends ATM_machine{
    static double balance;
    bank_account(double balance){
        this.balance=balance;
    }
    void display(){
        System.out.println("Welcome");
        System.out.print("1.Deposit     2.Withdraw      3.Check Balance     4.Exit      ");
        Scanner input = new Scanner(System.in);
        int option=input.nextInt();
        switch(option){
            case 1:
                System.out.println("Enter amount to be deposited : ");
                double deposit_amount=input.nextInt();
                deposit(deposit_amount);
                display();
                break;
            case 2:
                System.out.println("Enter amount to be withdrawn : ");
                double withdraw_amount=input.nextInt();
                withdraw(withdraw_amount);
                display();
                break;
            case 3:
                System.out.println(checkBalance());
                display();
                break;
            case 4:System.out.println("Transaction completed");
                break;
            default: System.out.println("Invalid Choice");
        }
    }
}

public class main_class{
    static double balance;
    public static void main(String args[]){
        bank_account.balance=20543;
        bank_account  obj1=new bank_account(bank_account.balance);
        obj1.display();
    }
}