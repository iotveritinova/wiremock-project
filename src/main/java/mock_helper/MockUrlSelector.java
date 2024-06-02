package mock_helper;

import config_qa.ConfigQa;
import config_qa.UrlEnum;
import mock_map.ModelEnum;

import java.util.Map;

public class MockUrlSelector {

    public static String mockUrlSelector(ModelEnum mockEnum) throws IllegalAccessException {
        Map<UrlEnum, String> mapOfProperties = ConfigQa.
                getInstance().getMapOfProperties();
        switch (mockEnum) {
            case OPERATION_CHECKER_ALLOW:
                return mapOfProperties.get(UrlEnum.OPERATION_CHECKER_URL);
            case PERSONAL_INFO_INFO_456311:
                return mapOfProperties.get(UrlEnum.PERSONAL_INFO_URL);
            case PRODUCT_INFO_INFO_787DDFE:
                return mapOfProperties.get(UrlEnum.PRODUCT_INFO_URL);
            default:
                throw new IllegalAccessException();
        }
    }
}
