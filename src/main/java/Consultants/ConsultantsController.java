package Consultants;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultantsController {

    private ConsultantsService consultantsService;

    public ConsultantsController(ConsultantsService consultantsService){
        this.consultantsService = consultantsService;
    }

    @PostMapping(path = "consultants")
    public void addConsultant(@RequestBody Consultants consultants){
        consultantsService.addConsultant(consultants);
    }

    @GetMapping(path = "consultants")
    public List<Consultants> getAllConsultants(){
        return consultantsService.getAllConsultants();
    }

    @GetMapping(path = "consultants/{id}")
    public Consultants getById(@PathVariable("id") Integer id) {
        return consultantsService.getById(id);
    }

    @PutMapping(path = "consultants/{id}")
    public void updateById(@PathVariable("id") Integer id, @RequestBody Consultants update) {
        consultantsService.updateById(id, update);
    }

    @DeleteMapping(path = "consultants/{id}")
    public void deleteClientsById(@PathVariable("id") Integer id){
        consultantsService.deleteById(id);
    }

//    update consultant with new client
}

