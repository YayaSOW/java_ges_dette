package org.example.core.services.impl;

import java.io.InputStream;
import java.util.Map;

import org.example.core.services.YamlService;
import org.yaml.snakeyaml.Yaml;

public class YamlServiceImp implements YamlService {

    private String path = "UnitPersitence.yaml";
    private String activeUnit;
    private Map<String, String> units;

    @Override
    public Map<String, Object> loadYaml() {
        return this.loadYaml(path);
    }

    @Override
    public Map<String, Object> loadYaml(String path) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(path);
        return yaml.load(inputStream);
    }

    public String getActivePersistenceUnit() {
        Map<String, Object> yamlMap = this.loadYaml();
        Map<String, Object> persistence = (Map<String, Object>) yamlMap.get("persitence");
        this.activeUnit = (String) persistence.get("active_unit");
        this.units = (Map<String, String>) persistence.get("units");
        return units.get(activeUnit);
    }

    // public void YamlPersistenceConfig() {
    // try (InputStream inputStream =
    // getClass().getClassLoader().getResourceAsStream("persistence.yaml")) {
    // Yaml yaml = new Yaml();
    // Map<String, Object> yamlMap = yaml.load(inputStream);

    // Map<String, Object> persistence = (Map<String, Object>)
    // yamlMap.get("persistence");
    // this.activeUnit = (String) persistence.get("active_unit");
    // this.units = (Map<String, String>) persistence.get("units");
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    // public String getActivePersistenceUnit() {
    // return units.get(activeUnit);
    // }
}
