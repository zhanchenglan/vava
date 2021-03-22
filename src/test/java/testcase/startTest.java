package testcase;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import page.LoginPage;
import page.StartPage;

@Epic("vava app自动化测试报告")
@Feature("vava app登录模块测试用例")
@Owner("jina")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class startTest {
      static LoginPage loginPage;

    @Test
    void testToMainPage() throws Exception {
        //登录成功之后跳转到首页
         loginPage=new LoginPage();
        loginPage.toMainPage("jina.zhan@sunvalley.com.cn","zclan1121");
    }

    @AfterAll
    static void AfterAll() {
        loginPage.quit();
    }
}
