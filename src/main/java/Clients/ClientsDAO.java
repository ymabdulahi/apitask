package com.apibnta.Clients;

package Clients.Clients;

import Clients.Clients;
import ch.qos.logback.core.net.server.Client;

import java.util.List;
import java.util.Optional;

public interface ClientsDAO {
    public int add(Client client);
    public List<Clients> getAll();
    public Clients getById(Integer id);
    public int updateById(Integer id, Clients update);
    public int deleteById(Integer id);
    public Optional<Clients> getAllConsultants(long numOfConsultants);
}
