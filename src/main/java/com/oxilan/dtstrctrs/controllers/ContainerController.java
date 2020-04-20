package com.oxilan.dtstrctrs.controllers;

import com.oxilan.dtstrctrs.containers.DynamicArray;
import com.oxilan.dtstrctrs.services.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ContainerController {

    private ContainerService containerService;

    @Autowired
    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping(path = "/get/dynamic-array")
    public @ResponseBody
    DynamicArray getDynamicArray() {
        DynamicArray dynamicArray = containerService.getDynamicArray();
        return dynamicArray;
    }

    @PostMapping(path = "/get/dynamic-array-add", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    DynamicArray add(@RequestBody String value) {

        return containerService.add(value);

    }

}
