package org.project.api.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.project.api.dto.mapper.CarMapper;
import org.project.business.CarPurchaseService;
import org.project.business.CarServiceRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SalesmanController {

    private static final String SALESMAN = "/salesman/";

    private final CarPurchaseService carPurchaseService;
    private final CarServiceRequestService carServiceRequestService;
    private final CarMapper carMapper;
    private final SalesmanMapper carMapper;
    private final MechanicMapper carMapper;

    @GetMapping(value = SALESMAN)
    public String homePage(Model model){
        var availableCars = carPurchaseService.availableCars().stream()
                .map(carMapper::map)
                .toList();
        carPurchaseService.availableSalesman();
        carServiceRequestService.availableMechanics();

        model.addAttribute("availableCarDTOs", availableCars);
        model.addAttribute("availableSalesmenDTOs", availableSalesmen);
        model.addAttribute("availableMechanicsDTOs", availableMechanics);

        return "salesman_portal";
    }



}
