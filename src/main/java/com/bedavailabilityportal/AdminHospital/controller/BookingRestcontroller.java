package com.bedavailabilityportal.AdminHospital.controller;

import com.bedavailabilityportal.AdminHospital.entity.AddBed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("booking")
public class BookingRestcontroller {
    static final String BOOKING_URL= "http://localhost:8083/booking";
    static final String BED_URL= "http://localhost:8084/AddBed";


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/restbookinglists")
    public String fetchbed(){
        return restTemplate.exchange(BOOKING_URL+"/getAll", HttpMethod.GET,null,String.class).getBody();
    }
    @PostMapping("/restaddbed")
    public String addbed( @RequestBody AddBed addBed){
        return restTemplate.postForObject(BED_URL+"/addbeds",addBed,String.class);
    }
}
