package Consultants;

import Clients.Clients;
import ch.qos.logback.core.net.server.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("consultantsPostgres")
public class ConsultantsSQL {private JdbcTemplate jdbcTemplate;

    public ConsultantsSQL(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int add(Consultants consultants) {

        String sql = "INSERT INTO client (name, location, currentClient) VALUES(?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                consultants.getName(),
                consultants.getLocation(),
                consultants.getCurrentClient()
        );
    }

    @Override
    public List<Consultants> getAll() {

        String sql = "SELECT id, name, location, currentClients FROM consultants";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Consultants(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("currentClient")
                )
        );
    }

    @Override
    public Consultants getById(Integer id) {

        String sql = "SELECT id, name, location, currentClient FROM clients WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                            new Consultants(
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("sector"),
                                    rs.getString("currentClient")
                            ),
                    id
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int updateById(Integer id, Consultants update) {
        String sql = "UPDATE venues SET (name, location, currentClient)=(?, ?, ?) WHERE id = ?";

        Consultants original = getById(id);

        String newName = update.getName();
        if (newName == null) newName = original.getName();
        String newLocation = update.getLocation();
        if (newLocation == null) newLocation = original.getLocation();
        String newCurrentClients = update.getCurrentClient();
        if (newCurrentClients == null) newCurrentClients = original.getCurrentClient();

        return jdbcTemplate.update(sql,
                newName,
                newLocation,
                newCurrentClients,
                id
        );
    }

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
