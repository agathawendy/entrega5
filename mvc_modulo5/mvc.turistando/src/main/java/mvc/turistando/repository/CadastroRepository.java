
package mvc.turistando.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mvc.turistando.model.Cadastro;


public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    

}

