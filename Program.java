package j.s.p0070;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Program {

    final String letter = "abcdefghijklmnopqrstuvwxyz";
    final String digit = "1234567890";
    final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    ResourceBundle rb;
    Scanner sc = new Scanner(System.in);

    public Program(String languageCode, String countryCode) {
        this.rb = ResourceBundle.getBundle("Properties.Language", new Locale(languageCode, countryCode));
    }

    // check account
    public void checkInputAccount() {       
        while (true) {
            System.out.print(rb.getString("Account_Number")); // get string tương ứng trong file properties
            String account = sc.nextLine();
            if (account.matches("[0-9]{10}")) { // tài khoản phải là số và có 10 chữ số 
                return;
            }
            System.err.println(rb.getString("Account_Invalid"));
        }
    }

    // check password
    public void checkInputPassword() {
        while (true) {
            boolean checkLeter = false, checkDigit = false;
            System.out.print(rb.getString("Password")); // get string tương ứng trong file properties
            String pass = sc.nextLine();
            
            if (pass.length() >= 8 && pass.length() <= 31) { // password phải có độ dài từ 8 - 31 kí tự
                // check các kí tự trong password
                for (int i = 0; i < pass.length(); i++) {
                    char x = pass.charAt(i);
                    if (Character.isLetter(x)) { // check kí tự chữ tồn tại trong password
                        checkLeter = true;
                    } else if (Character.isDigit(x)) { //check digit in password.
                        checkDigit = true;
                    }
                    if (checkLeter && checkDigit) {
                        return;
                    }
                }
            }
            
            System.err.println(rb.getString("Passwowd_Invalid"));
        }
    }

    // create and check capcha
    public void checkInputCaptcah(){
        System.out.print(rb.getString("Captcha")); // get string tương ứng trong file properties
        String captcha = "";
        Random rd = new Random();
        
        //random 5 character for captcha.
        for (int i = 0; i < 5; i++) {
            int r = rd.nextInt(alphabet.length()); // get indext của character
            captcha += alphabet.charAt(r); // add character vào captcha
        }
        System.out.println(captcha);

        // check captcha
        while (true) {
            System.out.print(rb.getString("Captcha_Input")); //get value Captcha_Input in ResourceBundle.
            String captchaInput = sc.nextLine();
            
            if (captchaInput.equals(captcha)) {
                return;
            }
            
            System.err.println("Captcha_Invalid");
        }
    }

    // message login
    public void CheckLogin() {
        System.out.println(rb.getString("Report"));
    }

}
