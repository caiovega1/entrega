package entregaPercistente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/elementoquimico")
public class ElementoQuimicoController {
	@Autowired
	private ElementoQuimicoRepository repo;

	
	@GetMapping("/quantidadedeelementos")
	public int quantidadedeelementos(){
		
		int find;
		find = repo.buscarNome();
		return find;
		
	}
	@GetMapping
	public List<Elemento> getAll() {
		return repo.findAll();
	}

	@PostMapping
	public String post(@RequestBody Elemento novoElemento) {
		if (repo.findById(novoElemento.getId()).isPresent()) {
			throw new ElementoExistenteException();
		}
		novoElemento = repo.save(novoElemento);
		return novoElemento.getId();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
    		repo.deleteById(id);
    		return ResponseEntity.ok().build();
		} catch (Exception e) {
    		return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	public Elemento getById(@PathVariable String id) {
		return repo.findById(id).get();
	}

	
	

	@PutMapping("/{id}")
	public ResponseEntity<Void> put(@PathVariable("id") String id, @RequestBody Elemento novoElemento) {
		if (!id.equals(novoElemento.getId())) {
			throw new IdIncompativelException();
		}
		if (!repo.findById(novoElemento.getId()).isPresent()) {            
			return ResponseEntity.notFound().build();

        }
		repo.save(novoElemento);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
