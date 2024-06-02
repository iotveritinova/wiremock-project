import io.restassured.response.Response;
import mock_map.ModelEnum;
import models.OperationCheckerModel;
import models.PersonInfoModel;
import models.ProductInfoModel;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NeoflexerTest extends BaseTest {
    public static String operationCheckUrl = "http://localhost:9999/check";
    public static String personalInfoUrl = "http://localhost:9999/get/personal/info";
    public static String productInfoUrl = "http://localhost:9999/get/product/info";

    @Test
    public static void getOperationCheckerTest() {
        Response response = given().get(operationCheckUrl);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().prettyPeek().get("result"), "OK");
        Assert.assertEquals(response.getBody().jsonPath().prettyPeek().get("permission "), "ALLOW");
    }

    @Test
    public static void getPersonalInfoTest() {
        Response response = given().header("clientId", "456311").get(personalInfoUrl);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().prettyPeek().get("phone"), "+79670916709");
        Assert.assertEquals(response.getContentType(), "application/json");
    }

    @Test
    public static void getProductInfoTest() {
        Response response = given().header("productId", "787DDFE").get(productInfoUrl);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().prettyPeek().get("status"), "BankStatus.Active");
        Assert.assertTrue((Integer) response.getBody().jsonPath().prettyPeek().get("creditLimit") > 5000);
    }

    @BeforeSuite
    public void init() throws IllegalAccessException {
        initMock(new OperationCheckerModel(ModelEnum.OPERATION_CHECKER_ALLOW));
        //initMock(new OperationCheckerModel(ModelEnum.OPERATION_CHECKER_ALLOW).setPermission("DENY"));
        initMock(new PersonInfoModel(ModelEnum.PERSONAL_INFO_INFO_456311));
        initMock(new ProductInfoModel(ModelEnum.PRODUCT_INFO_INFO_787DDFE));

    }
}
