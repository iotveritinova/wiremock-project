import io.restassured.response.Response;
import mock_helper.MockHelper;
import mock_helper.MockUrlSelector;
import models.MockModel;
import org.testng.annotations.AfterMethod;

import java.util.HashSet;

import static endpoints.Endpoints.ADMIN_MAPPINGS;

public class BaseTest {
    private static final HashSet<String> MOCKS_SET=new HashSet<>();
    protected void initMock(MockModel mockModel) throws IllegalAccessException {
        String url= MockUrlSelector.mockUrlSelector(mockModel.getModelEnum())
                +ADMIN_MAPPINGS.getEndpoint();
        Response response= MockHelper.post(mockModel.getModel(),url);
        String mockId=response
                .getBody()
                .jsonPath()
                .prettyPeek()
                .get("id");
        MOCKS_SET.add(url+"/"+mockId);
    }

    @AfterMethod
    public void cleanup(){
        MockHelper.deleteMocks(MOCKS_SET);
    }
}
