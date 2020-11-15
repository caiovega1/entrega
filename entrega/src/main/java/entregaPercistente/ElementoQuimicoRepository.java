package entregaPercistente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ElementoQuimicoRepository extends JpaRepository<Elemento, String> {

	@Query(value = "select count(nome)  from elemento", nativeQuery = true)
	int buscarNome();

	

}