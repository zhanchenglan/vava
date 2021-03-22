import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Epic("美甲涂涂app测试报告")
@Feature("美甲涂涂app特辑模块测试用例")
@Owner("jina")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class demoTest {
    @BeforeAll
    static void beforeTest(){
        System.out.println("111");
    }

    @Test
    @DisplayName("特辑一键收藏取消收藏测试用例")
    @Story("特辑一键收藏取消收藏测试用例")
    @Description("登录成功后进入首页-特辑推荐，选择特辑进入特辑详情页点击一键收藏、取消收藏，收藏取消收藏成功")
    @Severity(SeverityLevel.CRITICAL)
    void demoTest(){
        System.out.println("222");
    }

    @AfterAll
    static void afterTest(){
        System.out.println("333");
    }
}
