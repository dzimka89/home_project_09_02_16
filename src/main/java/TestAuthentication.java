import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestAuthentication {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean n = true;
        while (n) {
            System.out.println("Please enter user name:");
            String userName = reader.readLine();
            assert (userName.toLowerCase().contains("-") || userName.toLowerCase().contains(".")) : "Wrong char in phrase";
            System.out.println("Please enter your password");
            String userPassword = reader.readLine();
            assert (userPassword.toLowerCase().contains("-") || userPassword.toLowerCase().contains(".")) : "Wrong char in phrase";

            try {
                UserAuthentication userAuthentication = new UserAuthentication(userName, userPassword);
                UserRole userRole = userAuthentication.getUserRole();
                System.out.println(userRole.toString());
                n = false;
            } catch (UserAuthenticationException e) {
                System.out.println("Please try again");

            }
        }


    }
}
