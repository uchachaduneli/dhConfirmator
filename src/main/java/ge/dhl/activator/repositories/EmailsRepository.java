package ge.dhl.activator.repositories;

import ge.dhl.activator.entities.Emails;
import org.springframework.data.repository.CrudRepository;

public interface EmailsRepository extends CrudRepository<Emails, Integer> {
}
