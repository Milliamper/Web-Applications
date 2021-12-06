package com.webalk.futas.Controller;

import com.webalk.futas.Controller.ControllerDTO.Futas;
import com.webalk.futas.Controller.ControllerDTO.FutasCreate;
import com.webalk.futas.Service.FutasService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/futas")
public class FutasController {

    private final FutasService futasService;

    public FutasController(FutasService futasService) {
        this.futasService = futasService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Futas save(@RequestBody @Valid FutasCreate futasCreate){
        return new Futas(futasService.createFutas(futasCreate.toServiceDTO()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        futasService.deleteFutasById(id);
    }

    @PutMapping
    public void updateFutas(@RequestBody @Valid Futas futas){
        futasService.updateFutas(futas.toServiceDTO());
    }

    @GetMapping
    public List<Futas> getAllFutas(){
        List<Futas> futasList = new ArrayList<>();
        for(com.webalk.futas.Service.ServiceDTO.Futas futas : futasService.getAllFutas()){
            futasList.add(new Futas(futas));
        }
        return futasList;
    }

    @GetMapping("/{type}")
    public Futas getBest(@PathVariable("type") int type){
        return new Futas(futasService.getBestFutas(type));
    }
}
