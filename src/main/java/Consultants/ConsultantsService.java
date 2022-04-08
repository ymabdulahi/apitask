package Consultants;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class ConsultantsService {
    private ConsultantsDAO consultantsDAO;

    public ConsultantsService(@Qualifier("clientsPostgres") ConsultantsDAO consultantsDAO) {
        this.consultantsDAO = consultantsDAO;
    }

    public void addConsultant (Consultants consultant) {
        List<Consultants> allConsultant = consultantsDAO.getAll();
        int added = consultantsDAO.add(consultant);
        if (added != 1){
            throw new IllegalStateException("Consultant can't be added");
        }
    }

    public List<Consultants> getAll(){
        return consultantsDAO.getAll();
    };

    public Consultants getById(Integer id) throws ConsultantsNotFoundException {
        Consultants selected = consultantsDAO.getById(id);
        if (selected == null){
            throw new ConsultantsNotFoundException("Consultant with id " + id + " could not be found");
        } else return selected;
    }

    public void updateById(Integer id, Consultants consultants) throws ConsultantsNotFoundException {
        if (consultantsDAO.getById(id) == null) {
            throw new ConsultantsNotFoundException("Consultant with id " + id + " could not be found");
        }

        int result = consultantsDAO.updateById(id, consultants);

        if (result != 1) {
            throw new IllegalStateException("Consultant with id " + id + " could not be updated");
        }
    }

    public void deleteById(Integer id) throws ConsultantsNotFoundException {
        if (consultantsDAO.getById(id) == null) {
            throw new ConsultantsNotFoundException("Client with id " + id + " could not be found");
        }

        int result = consultantsDAO.deleteById(id);

        if (result != 1) {
            throw new IllegalStateException("Client with id " + id + " could not be deleted");
        }

    }

    public List<Consultants> getAllConsultants() {
    }
}
