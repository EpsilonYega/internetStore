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
public class AccessoireForTheSmartphone extends AbstractElectronicsDevice {
    private String appointment;
    private String fastChargingStandard;
    private String compatibleBrand;
    private double maxOutputCurrent;
    private String recommendedFor;
    private String typeOfCover;
    private String glassHardness;
    private int maxDiagonal;
    private int minDiagonal;
    private boolean fastCharging;
    private double weight;
    private String compatibleModels;
    private boolean transparencyOfTheCoating;
    private String technologicalFeatures;
    public AccessoireForTheSmartphone(@Autowired int productId, @Autowired String productName, @Autowired List<Warehouse> warehouses,
                                      @Autowired int productCount, @Autowired String companyName, @Autowired double price,
                                      @Autowired String productType, @Autowired String country, @Autowired Date announcementYear,
                                      @Autowired String deviceModel, @Autowired String appointment, @Autowired String fastChargingStandard,
                                      @Autowired String compatibleBrand, @Autowired double maxOutputCurrent, @Autowired String recommendedFor,
                                      @Autowired String typeOfCover, @Autowired String glassHardness, @Autowired int maxDiagonal,
                                      @Autowired int minDiagonal, @Autowired boolean fastCharging, @Autowired double weight,
                                      @Autowired String compatibleModels, @Autowired boolean transparencyOfTheCoating,
                                      @Autowired String technologicalFeatures)
    {
        super(productId, productName, warehouses, productCount, companyName, price, productType, country, announcementYear, deviceModel);
        setAppointment(appointment);
        setFastChargingStandard(fastChargingStandard);
        setCompatibleBrand(compatibleBrand);
        setMaxOutputCurrent(maxOutputCurrent);
        setRecommendedFor(recommendedFor);
        setTypeOfCover(typeOfCover);
        setGlassHardness(glassHardness);
        setMaxDiagonal(maxDiagonal);
        setMinDiagonal(minDiagonal);
        setFastCharging(fastCharging);
        setWeight(weight);
        setCompatibleModels(compatibleModels);
        setTransparencyOfTheCoating(transparencyOfTheCoating);
        setTechnologicalFeatures(technologicalFeatures);
    }
}
