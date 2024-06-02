package config_qa;

import lombok.Getter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigQa {
    private static final ConfigQa INSTANCE=new ConfigQa();
    @Getter
    private final Map<UrlEnum,String> mapOfProperties=new HashMap<>();

    public ConfigQa(){
        Properties properties=new Properties();
        try{properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (UrlEnum value:UrlEnum.values()){
            mapOfProperties.put(value, properties.getProperty(value.name().toLowerCase()));
        }
    }

    public static ConfigQa getInstance(){
        return INSTANCE;
    }
}
