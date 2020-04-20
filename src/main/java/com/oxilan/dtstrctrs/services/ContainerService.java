package com.oxilan.dtstrctrs.services;

import com.oxilan.dtstrctrs.containers.DynamicArray;
import com.oxilan.dtstrctrs.containers.LinList;
import org.springframework.stereotype.Service;

@Service
public class ContainerService {

    DynamicArray dynamicArray = new DynamicArray<>();
    LinList linList = new LinList();

    public DynamicArray getDynamicArray (){
        return dynamicArray;
    }

    public DynamicArray add(String el){
        dynamicArray.add(el);
        return dynamicArray;
    }

}
