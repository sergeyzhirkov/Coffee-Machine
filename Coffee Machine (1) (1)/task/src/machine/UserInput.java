package machine;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void userRun() throws IOException {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String string;
        while (!coffeeMachine.isExit) {
            if (coffeeMachine.status==Condition.INFO){
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                coffeeMachine.status = Condition.CHOOSE_ACTION;
            }
            string = reader.readLine();
            coffeeMachine.inputStringData(string);
        }
    }
}
