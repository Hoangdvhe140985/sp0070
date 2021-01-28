package j.s.p0070;

public class JSP0070 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option;
        Program program = new Program("en", "US");
        
        while (true) {
            System.out.println("\n======= Login Proram =======");
            System.out.println("1. Vietnamese.");
            System.out.println("2. English.");
            System.out.println("3. Exit.");
            
            option = Validation.getInt("Please choose one option: ", 1, 3);
            
            switch (option) {
                case 1:
                    program = new Program("vi", "VN");
                    break;
                case 2:
                    program = new Program("en", "US");
                    break;
                case 3:
                    System.exit(0);             
            }
            
            program.checkInputAccount();
            program.checkInputPassword();
            program.checkInputCaptcah();
            program.CheckLogin();
        }        
    }
}
