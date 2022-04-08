package Clients;

import Clients.Clients;
import ch.qos.logback.core.net.server.Client;
import com.apibnta.Clients.ClientsDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("clientsPostgres")
public class ClientsSQL implements ClientsDAO {
    private JdbcTemplate jdbcTemplate;

    public ClientsSQL(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int add(Clients client) {

        String sql = "INSERT INTO client (name, sector, location) VALUES(?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                client.getName(),
                client.getSector(),
                client.getLocation()
        );
    }

    @Override
    public List<Clients> getAll() {

        String sql = "SELECT id, name, sector, location FROM clients";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("sector"),
                        rs.getString("location")
//                        rs.getString("numberOfConsultants")

                )
        );
    }

    @Override
    public Clients getById(Integer id) {

        String sql = "SELECT id, name, sector, location FROM clients WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                            new Client(
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("sector"),
                                    rs.getString("location"),
//                                    rs.getString("numberOfConsultants")
                            ),
                    id
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int updateById(Integer id, Clients update) {
        String sql = "UPDATE venues SET (name, sector, location, numberOfConsultant)=(?, ?, ?) WHERE id = ?";

        Clients original = getById(id);

        String newName = update.getName();
        if (newName == null) newName = original.getName();
        String newSector = update.getSector();
        if (newSector == null) newSector = original.getSector();
        String newLocation = update.getLocation();
        if (newLocation == null) newLocation = original.getLocation();
//        String newNumberOfConsultants = update.getNumberOfConsultants();
//        if (newNumberOfConsultants == null) newNumberOfConsultants = original.getNumberOfConsultants();

        return jdbcTemplate.update(sql,
                newName,
                newSector,
                newLocation,
//                newNumberOfConsultants,
                id
        );
    }

//    @Override
//    public int updateById(Integer id, Client update) {
//
//        String sql = "UPDATE venues SET (name, sector, location, numberOfConsultant)=(?, ?, ?) WHERE id = ?";
//
//        Clients original = getById(id);
//
//        String newName = update.getName();
//        if (newName == null) newName = original.getName();
//        String newSector = update.getSector();
//        if (newSector == null) newSector = original.getSector();
//        String newLocation = update.getLocation();
//        if (newLocation == null) newLocation = original.getLocation();
//        String newNumberOfConsultants = update.getNumberOfConsultants();
//        if (newNumberOfConsultants == null) newNumberOfConsultants = original.getNumberOfConsultants();
//
//        return jdbcTemplate.update(sql,
//                newName,
//                newSector,
//                newLocation,
//                newNumberOfConsultants,
//                id
//        );
//    }

    @Override
    public int deleteById(Integer id) {

        String sql = "DELETE FROM venues WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Clients> getAllConsultants(long numOfConsultants) {
        return Optional.empty();
    }
}
