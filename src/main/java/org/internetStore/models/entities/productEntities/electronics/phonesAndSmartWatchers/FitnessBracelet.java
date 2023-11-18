package org.internetStore.models.entities.productEntities.electronics.phonesAndSmartWatchers;

import lombok.Getter;
import lombok.Setter;
import org.internetStore.models.entities.productEntities.electronics.AbstractElectronicsDevice;
import org.internetStore.models.entities.warehouseEntities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FitnessBracelet extends AbstractElectronicsDevice {
    private String builtInSensors;
    private String features;
    private String color;
    private boolean displayAvailability;
    private String displayType;
    private String braceletOrStrapMaterial;
    private String bodyMaterial;
    private String compatibility;
    private String wirelessInterfaces;
    private String alertsType;
    private int batteryLife;
    private int screenDiagonal;
    private String braceletModel;
    private String monitoring;
    private String security;
    private String organizer;
    private boolean sensorDisplay;
    private double weight;
    public FitnessBracelet(@Autowired int productId, @Autowired String productName, @Autowired List<Warehouse> warehouses,
                           @Autowired int productCount, @Autowired String companyName, @Autowired double price, @Autowired String productType,
                           @Autowired String country, @Autowired Date announcementYear, @Autowired String deviceModel,
                           @Autowired String builtInSensors, @Autowired String features, @Autowired String color,
                           @Autowired boolean displayAvailability, @Autowired String displayType, @Autowired String braceletOrStrapMaterial,
                           @Autowired String bodyMaterial, @Autowired String compatibility, @Autowired String wirelessInterfaces,
                           @Autowired String alertsType, @Autowired int batteryLife, @Autowired int screenDiagonal, @Autowired String braceletModel,
                           @Autowired String monitoring, @Autowired String security, @Autowired String organizer, @Autowired boolean sensorDisplay,
                           @Autowired double weight) {
        super(productId, productName, warehouses, productCount, companyName, price, productType, country, announcementYear, deviceModel);
        setBuiltInSensors(builtInSensors);
        setFeatures(features);
        setColor(color);
        setDisplayAvailability(displayAvailability);
        setDisplayType(displayType);
        setBraceletOrStrapMaterial(braceletOrStrapMaterial);
        setBodyMaterial(bodyMaterial);
        setCompatibility(compatibility);
        setWirelessInterfaces(wirelessInterfaces);
        setAlertsType(alertsType);
        setBatteryLife(batteryLife);
        setScreenDiagonal(screenDiagonal);
        setBraceletModel(braceletModel);
        setMonitoring(monitoring);
        setSecurity(security);
        setOrganizer(organizer);
        setSensorDisplay(sensorDisplay);
        setWeight(weight);
    }
}
