package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import mock_map.ModelEnum;

public class OperationCheckerModel extends MockModel {
    public OperationCheckerModel(ModelEnum mockEnum) {
        super(mockEnum);
    }

    public OperationCheckerModel setPermission(String permission){
        ((ObjectNode) getModel().get("response").get("jsonBody")).put("permission",permission);
        return this;
    }
}