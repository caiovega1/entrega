package entregaPercistente;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Elemento {
	@Id
	private String id;
	
	private String nome;
	private String tipo;
	private String numeroAtomico;

	private Elemento() {
		id = UUID.randomUUID().toString();
	}

	public Elemento(String nome, String tipo, String numeroAtomico) {
		this();
		this.nome = nome;
		this.numeroAtomico = numeroAtomico;
		this.tipo = tipo;

	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroAtomico() {
		return numeroAtomico;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Elemento)) {
			return false;
		}
		Elemento elemento = (Elemento) o;
		return Objects.equals(id, elemento.id);
	}

}
