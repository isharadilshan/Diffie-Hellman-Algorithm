import java.util.Scanner;

public class DH {
    
    static int P = 15487469;
    static int G = 97039801;
    static int private_key;
    static int default_private_key_A;
    static int default_private_key_B;
    
    public static void getUserInput(){ 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter private key: ");
        String private_key_str = sc.nextLine();
        private_key = checkIfInt(private_key_str);   
    }
    
    public static int privateNumberGenerator(int num){
        if(num==0){
            System.out.println("Please enter private number greater than Zero");
            getUserInput();
        }
        return (int)Math.pow(G,num)%P;  
    }
    
    public static int checkIfInt(String str){
        try {
            int result = Integer.parseInt(str);
            return result;    
        } catch (Exception e) { 
            System.out.println("Please enter a valid Integer");
            return 0;  
        }
    }
    public static void getSessionKey(){
        default_private_key_A = 12234;
        default_private_key_B = 34424;
        int x = privateNumberGenerator(default_private_key_A);
        System.out.println("Your session key : "+(int)Math.pow(x,default_private_key_B)%P);
    }
    public static void caseFunction(int user_input){
        switch(user_input){
            case 1:
                getUserInput();
                System.out.println("Your public key : "+privateNumberGenerator(private_key));
                System.exit(0);
            case 2:
                getSessionKey();
                System.exit(0);
            default:
                System.out.println("PLEASE SELECT CORRECT ARGUMENT\n");
                onStart();
        }
    }
    
    public static void onStart(){
        Scanner sc = new Scanner(System.in);
        System.out.println("For DH private_key Example please enter 1");
        System.out.println("For DH private_key public_key Example please enter 2");
        String input = sc.nextLine();
        caseFunction(checkIfInt(input));
    }
    public static void main(String args[]){
        onStart();
    }
}
