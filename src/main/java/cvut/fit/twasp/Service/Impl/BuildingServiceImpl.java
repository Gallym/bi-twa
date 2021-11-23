package cvut.fit.twasp.Service.Impl;

import cvut.fit.twasp.Model.Building;
import cvut.fit.twasp.Service.BuildingService;
import javassist.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;


public class BuildingServiceImpl implements BuildingService {
    @Override
    public List<Building> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Building findById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    @Transactional
    public Building save(Building building) throws InvalidAttributesException {
        return null;
    }

    @Override
    @Transactional
    public Building update(Long id, Building building) throws NotFoundException, InvalidAttributesException {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {

    }
}
