package cvut.fit.twasp.Repository;


import cvut.fit.twasp.Model.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepo extends CrudRepository<Building, Long> {
}
