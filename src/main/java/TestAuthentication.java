import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.*;


public class TestAuthentication {
    private static Logger log = Logger.getLogger(UserAuthentication.class.getName());


    public static void main(String[] args) throws IOException {
        Handler handler = new FileHandler("./test.log", 1024,5);
        handler.setFormatter(new SimpleFormatter());
        log.addHandler(handler);
        log.setLevel(Level.INFO);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean n = true;
        while (n) {
            System.out.println("Please enter user name:");
            String userName = reader.readLine();
            log.info("Getting user name");
            assert (userName.toLowerCase().contains("-") || userName.toLowerCase().contains(".")) : "Wrong char in phrase";
            System.out.println("Please enter your password");
            String userPassword = reader.readLine();
            log.info("Getting user password");
            assert (userPassword.toLowerCase().contains("-") || userPassword.toLowerCase().contains(".")) : "Wrong char in phrase";

            try {
                UserAuthentication userAuthentication = new UserAuthentication();
                userAuthentication.checkUserRole(userName, userPassword);
                UserRole userRole = userAuthentication.getUserRole();
                System.out.println(userRole.toString());
                log.info("User is authenticated");
                n = false;
            } catch (UserAuthenticationException e) {
                e.printStackTrace();
                log.warning("impermissible char is entered");
                System.out.println("Please try again");

            }
        }


    }
}


