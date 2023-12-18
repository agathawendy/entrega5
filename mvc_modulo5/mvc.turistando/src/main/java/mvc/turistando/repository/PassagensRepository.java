package mvc.turistando.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import mvc.turistando.model.Passagens;


public interface PassagensRepository extends JpaRepository<Passagens, Long> {
	
	 List<Passagens> findAll();

}
