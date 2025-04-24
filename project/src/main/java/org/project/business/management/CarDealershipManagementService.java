package org.project.business.management;

import lombok.AllArgsConstructor;
import org.project.business.dao.management.CarDealershipManagementDAO;

import java.util.List;

@AllArgsConstructor
public class CarDealershipManagementService {

    private final CarDealershipManagementDAO carDealershipManagementService;
    private final FileDataPreparationService fileDataPreparationService;

    public void purge() {
        carDealershipManagementService.purge();
    }

    public void init() {
        List<?> entities = fileDataPreparationService.prepareInitData();
        carDealershipManagementService.saveAll(entities);
    }

}
