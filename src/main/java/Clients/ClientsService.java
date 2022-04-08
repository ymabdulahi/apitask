package Clients;

import com.apibnta.ClientsDAO;
import com.sun.security.ntlm.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    private ClientsDAO clientsDAO;

    public ClientsService(@Qualifier("clientsPostgres") ClientsDAO clientsDAO) {
        this.clientsDAO = clientsDAO;
    }

    public void addClient (Client client) {
        List<Clients> allClient = clientsDAO.getAll();
        int added = clientsDAO.add(client);
        if (added != 1){
            throw new IllegalStateException("Client can't be added");
        }
    }

    public List<Clients> getAll(){
        return clientsDAO.getAll();
    };

    public Clients getById(Integer id){
        Clients selected = clientsDAO.getById(id);
        if (selected == null){
            throw new ClientsNotFoundException("Client with id " + id + " could not be found");
        } else return selected;
    }

    public void updateById(Integer id, Clients clients) {
        if (clientsDAO.getById(id) == null) {
            throw new ClientsNotFoundException("Client with id " + id + " could not be found");
        }

        int result = clientsDAO.updateById(id, clients);

        if (result != 1) {
            throw new IllegalStateException("Client with id " + id + " could not be updated");
        }
    }

    public void deleteById(Integer id) {
        if (clientsDAO.getById(id) == null) {
            throw new ClientsNotFoundException("Client with id " + id + " could not be found");
        }

        int result = clientsDAO.deleteById(id);

        if (result != 1) {
            throw new IllegalStateException("Client with id " + id + " could not be deleted");
        }

    }

    public Optional<Clients> getAllConsultants (long id){
        if (clientsDAO.getAllConsultants(id).isEmpty())
        {
            throw new ClientsNotFoundException("Consultants for client doesn't exist");
        }
        return clientsDAO.getAllConsultants(id);
    }
}

