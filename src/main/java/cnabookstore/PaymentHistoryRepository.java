package cnabookstore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Long> {


}