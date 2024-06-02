package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import mock_map.MocksMap;
import mock_map.ModelEnum;

public class MockModel {
    @Getter
    private final ObjectNode model;
    @Getter
    private final ModelEnum modelEnum;

    public MockModel(ModelEnum mockEnum){
        this.model= MocksMap.getInstance().getMocksMap().get(mockEnum).deepCopy();
        this.modelEnum=mockEnum;
    }
}
