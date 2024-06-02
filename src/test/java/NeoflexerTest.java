import mock_map.ModelEnum;
import models.OperationCheckerModel;
import models.PersonInfoModel;
import models.ProductInfoModel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NeoflexerTest extends BaseTest {
    @Test
    public static void simpleTest() {

    }

    @BeforeTest
    public void init() throws IllegalAccessException {
        initMock(new OperationCheckerModel(ModelEnum.OPERATION_CHECKER_ALLOW));
        //initMock(new OperationCheckerModel(ModelEnum.OPERATION_CHECKER_ALLOW).setPermission("DENY"));
        initMock(new PersonInfoModel(ModelEnum.PERSONAL_INFO_INFO_456311));
        initMock(new ProductInfoModel(ModelEnum.PRODUCT_INFO_INFO_787DDFE));

    }
}
