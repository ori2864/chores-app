package com.ori.chores.Controllers;

import com.ori.chores.Beans.Responsible;
import com.ori.chores.Services.ResponsibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responsible")
@CrossOrigin
@RequiredArgsConstructor
public class RespController {
    private final ResponsibleService respService;
    @PostMapping("/add/{responsible}")
    public void addResponsible(@RequestBody Responsible resp){
        respService.addResponsible(resp);
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Responsible getResponsible(@PathVariable Integer id) throws Exception {
        return respService.getResponsible(id);
    }
}
