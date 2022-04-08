package com.apibnta;

import Clients.Clients;
import Clients.ClientsService;
import ch.qos.logback.core.net.server.Client;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientsController {

    private ClientsService clientsService;

    public ClientsController(ClientsService clientsService){
        this.clientsService = clientsService;
    }

    @PostMapping(path = "clients")
    public void addClients(@RequestBody Client clients){
        clientsService.addClient(clients);
    }

    @GetMapping(path = "clients")
    public List<Clients> getAllClients(){
        return clientsService.getAllConsultants();
    }

    @GetMapping(path = "clients/{id}")
    public Clients getById(@PathVariable("id") Integer id) {
        return clientsService.getById(id);
    }

    @PutMapping(path = "clients/{id}")
    public void updateById(@PathVariable("id") Integer id, @RequestBody Clients update) {
        clientsService.updateById(id, update);
    }

    @DeleteMapping(path = "clients/{id}")
    public void deleteClientsById(@PathVariable("id") Integer id){
        clientsService.deleteById(id);
    }

//    view the client a given consultant is working for
}
