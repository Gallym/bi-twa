package cvut.fit.twasp.Service;

import cvut.fit.twasp.Model.Building;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface BuildingService {
    List<Building> findAll();

    Building findById(Long id) throws NotFoundException;

    Building save(Building building) throws InvalidAttributesException;

    Building update(Long id, Building building) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;
}
