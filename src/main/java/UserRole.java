
public enum UserRole {
    ADMIN{
        public String userName = "ADMIN";
        public String userPassword = "21041989";
        @Override
        public String toString() {
            return "You have entered as ADMIN";
        }
    },
    GUEST{
        public String userName = "GUEST";
        public String userPassword = "21041989";
        @Override
        public String toString() {
            return "You have entered as GUEST";
        }
    },
    DEFAULT_USER{
        @Override
        public String toString() {
            return "You have entered as DEFAULT USER";
        }
    };
    public String userNameADMIN = "Dmitriy";
    public String userPasswordADMIN = "21041989";
    public String userNameGUEST = "Guest";
    public String userPasswordGUEST = "02071996";
    }
