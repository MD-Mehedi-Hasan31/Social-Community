package com.sc.controllers;

import com.sc.dao.LocationDao;
import com.sc.entity.Location;
import com.sc.model.LocationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/")
public class LocationController {

    @Autowired
    private LocationDao locationDao;

    @GetMapping("/location/show")
    public String getLocations(Model model) {

        List<Location> locationList=locationDao.getLocations();
        model.addAttribute("locationList", locationList);
        return "/location/show";
    }

    @GetMapping("location/createLocation")
    public String store(Model model){
        LocationModel locationModel = new LocationModel();
        model.addAttribute("location", locationModel);
        return "/location/createLocation";
    }

    @PostMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") LocationModel locationModel, Model model){
        locationDao.save(locationModel);
        return getLocations(model);
    }

}
