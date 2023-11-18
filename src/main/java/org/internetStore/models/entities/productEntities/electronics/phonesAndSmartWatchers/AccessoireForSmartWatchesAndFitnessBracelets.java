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
public class AccessoireForSmartWatchesAndFitnessBracelets extends AbstractElectronicsDevice {
    private String braceletOrSmartwatchModel;
    private int dialSize;
    private int strapLength;
    private String braceletOrStrapMaterial;
    private String suitableFor;
    private String color;

    public AccessoireForSmartWatchesAndFitnessBracelets(@Autowired int productId, @Autowired String productName, @Autowired List<Warehouse> warehouses,
                                                        @Autowired int productCount, @Autowired String companyName, @Autowired double price,
                                                        @Autowired String productType, @Autowired String country, @Autowired Date announcementYear,
                                                        @Autowired String deviceModel, @Autowired String braceletOrSmartwatchModel,
                                                        @Autowired int dialSize, @Autowired int strapLength, @Autowired String braceletOrStrapMaterial,
                                                        @Autowired String suitableFor, @Autowired String color)
    {
        super(productId, productName, warehouses, productCount, companyName, price, productType, country, announcementYear, deviceModel);
        setBraceletOrSmartwatchModel(braceletOrSmartwatchModel);
        setDialSize(dialSize);
        setStrapLength(strapLength);
        setBraceletOrStrapMaterial(braceletOrStrapMaterial);
        setSuitableFor(suitableFor);
        setColor(color);
    }
}
