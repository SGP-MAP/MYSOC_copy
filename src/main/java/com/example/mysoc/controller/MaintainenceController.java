package com.example.mysoc.controller;

import com.example.mysoc.entity.MaintainenceDB;
//import com.example.mysoc.entity.User;
import com.example.mysoc.service.MaintainenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/Maitainence")
public class MaintainenceController {
    @Autowired
    private MaintainenceService maintainenceService;

    @PostMapping("/save")
    public MaintainenceDB saveDetails(@RequestBody MaintainenceDB obj)
    {
        obj.setSkey(maintainenceService.generateSequence(MaintainenceDB.SEQUENCE_NAME));
        return maintainenceService.saveDetails(obj);
    }

    @GetMapping("/getList")
    public List<MaintainenceDB> getList()
    {
        return maintainenceService.getList();
    }

    @PutMapping("/updateStatus")
    public  boolean statusUpdate(@RequestBody MaintainenceDB newobj){
        return maintainenceService.statusUpdate(newobj);
    }

    @GetMapping("/getById/{uid}")
    public Optional<MaintainenceDB> getById(@PathVariable("uid")Long id)
    {
       return maintainenceService.getById(id);
    }

    @GetMapping("/getRemaining")
    public List<MaintainenceDB> getReamaining()
    {
        return maintainenceService.getRemaining();
    }
}
/*


{
    "id": 5,
    "year": 2000,
    "month": 2,
    "paid_on": null,
    "status": true,
    "ammount": 777,
    "fine": 0
}

{
    "id": 6,
    "year": 1990,
    "month": 0,
    "paid_on": "1990-02-01T00:00:00.000+00:00",
    "status": true,
    "ammount": 777,
    "fine": 0
}
* */
