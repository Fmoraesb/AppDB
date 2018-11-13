package negocio;

public class Conta {

	private Long id;
	private String descricao;
	private float valor;
	private boolean debito;
	
	public Conta() {
		
	}
	
	public Conta(Long id, String descricao, float valor, boolean debito) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.debito = debito;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean isDebito() {
		return debito;
	}
	public void setDebito(boolean debito) {
		this.debito = debito;
	}
}