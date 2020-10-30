package ge.dhl.activator.repositories;

import ge.dhl.activator.entities.PhoneNumbers;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumbersRepository extends CrudRepository<PhoneNumbers, Integer> {
}
