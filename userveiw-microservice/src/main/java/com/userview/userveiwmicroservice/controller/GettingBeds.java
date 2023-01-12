package com.userview.userveiwmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/userView")
public class GettingBeds {

    @Autowired
    private RestTemplate restTemplate;

    static  final  String USERVIEW_URL = "http://localhost:8081/hospital";

    static final String BOOKING_URL= "http://localhost:8083/booking";
    static final String bed_URL= "http://localhost:8084/AddBed";

    @GetMapping("/resthospitallist")
    public String hospital(){
        return restTemplate.exchange(USERVIEW_URL+"/getAll", HttpMethod.GET,null,String.class).getBody();
    }
    @PostMapping("/restsavebooking")
    public String addbooking( @RequestBody Booking booking){
        return restTemplate.postForObject(BOOKING_URL+"/save",booking,String.class);
    }
    @GetMapping("/restbedlist")
    public String fetchbed(){
        return restTemplate.exchange(bed_URL+"/getAll", HttpMethod.GET,null,String.class).getBody();
    }

}
