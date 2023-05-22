package jpaMaven;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity //Anotação Entity - Faz com que o JPA saiba que aquela classe deve ser manipulada por ele
@Table(name = "Pessoa") //define que esta classe possui uma tabela chamada Pessoa no banco de dados
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id //Obrigatório definir a anotação @Id para que o JPA não apresente erros
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que o id é auto increment
	Integer id;
	
	@Column //Descrevem que estas propriedades possuem uma coluna correspondente no banco de dados.
	String nome;
	
	@Column
	String email;
	
	@Column
	String cargo;
	 
	public Pessoa(Integer id, String nome, String email, String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
	}
	public Pessoa () {
	}
	//@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", cargo=" + cargo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
