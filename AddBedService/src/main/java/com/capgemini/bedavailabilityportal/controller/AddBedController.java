package com.capgemini.bedavailabilityportal.controller;

import com.capgemini.bedavailabilityportal.exception.ResourceNotFoundException;

import com.capgemini.bedavailabilityportal.model.AddBed;
import com.capgemini.bedavailabilityportal.repository.AddBedRepository;
import com.capgemini.bedavailabilityportal.service.BedAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/AddBed")
public class AddBedController {
    @Autowired
    BedAddService bedAddService;
    @Autowired
    AddBedRepository addBedRepository;

    @GetMapping("/getAll")
    public List<AddBed> getAddBedlist(){
        return  this.addBedRepository.findAll();
    }

    @GetMapping("bed/{id}")
    public ResponseEntity<AddBed> getAddBedById(@PathVariable(value="id") Long addBedId)throws ResourceNotFoundException {
        AddBed addBed=addBedRepository.findById(addBedId)
                .orElseThrow(()->new ResourceNotFoundException("room  not found:: "+addBedId));
        return ResponseEntity.ok().body(addBed);
    }

    // Save operation
    @RequestMapping(value ="/addbeds", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AddBed> createAddBed(@Validated @RequestBody AddBed addBed){
        System.out.println("Rest");
        AddBed mv = bedAddService.addAddBed(addBed);
        return new ResponseEntity<AddBed>(mv, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public String updateAddBeds(@PathVariable(value = "id") Long addBedId, @RequestBody AddBed addBed) {
        return bedAddService.updateAddBed(addBedId,addBed );
    }

    public ResponseEntity<List<AddBed>> getAddMovieId(@PathVariable Long addBedId) throws ResourceNotFoundException {
        Optional<AddBed> addBed = bedAddService.findByAddBed(addBedId);
        if(addBed.isPresent()) {
            return new ResponseEntity(addBed.get(), HttpStatus.OK);
        }else{
            throw new ResourceNotFoundException("Record not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteaddBed(@PathVariable(value = "id") Long  addBedId)throws ResourceNotFoundException {
        AddBed addBed=addBedRepository.findById(addBedId)
                .orElseThrow(() -> new ResourceNotFoundException("room not found for this id :: " +addBedId ));

        this.addBedRepository.delete(addBed);
        Map<String,Boolean>response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("delete/bed/{id}")
    public String deleteBed(@PathVariable("id") Long hId){
        return bedAddService.deleteBed(hId);
    }
    @GetMapping("getAll/beds")
    public List<AddBed> getAllBeds(){
        return bedAddService.findAllBeds();
    }
}
