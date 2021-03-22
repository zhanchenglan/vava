package page;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class LoginPage extends StartPage{
    By username= By.id("com.vava.ipc:id/username_et");
    By password= By.id("com.vava.ipc:id/password_et");
    By login= By.id("com.vava.ipc:id/login_ll");

    public LoginPage() throws MalformedURLException {
        super();
    }

    public void toMainPage(String userName,String passWord) {
        sendkeys(username,userName);
        sendkeys(password,passWord);
        click(login);
    }

}
