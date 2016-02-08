
public class UserAuthentication {
    private UserRole userRole;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void checkUserRole(String userName, String userPassword) throws UserAuthenticationException {
        if(userName.toLowerCase().contains("-") || userName.toLowerCase().contains(".")||userPassword.toLowerCase().contains("-") || userPassword.toLowerCase().contains(".")){
            throw new UserAuthenticationException();
        }
        
        if(userName.equals(userRole.userNameADMIN)||userPassword.equals(userRole.userPasswordADMIN)){
            this.userRole = UserRole.ADMIN;
        }else if(userName.equals(userRole.userNameGUEST)||userPassword.equals(userRole.userPasswordGUEST)){
            this.userRole = UserRole.GUEST;
        } else {
            this.userRole = UserRole.DEFAULT_USER;
        }
    }

    public UserAuthentication(String userName, String userPassword) throws UserAuthenticationException {
        checkUserRole(userName, userPassword);

    }
}
