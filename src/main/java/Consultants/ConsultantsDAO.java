package Consultants;
import Consultants.Consultants;

import java.util.List;

public interface ConsultantsDAO {
    public int add(Consultants consultant);
    public List<Consultants> getAll();
    public Consultants getById(Integer id);
    public int updateById(Integer id, Consultants update);
    public int deleteById(Integer id);
}
