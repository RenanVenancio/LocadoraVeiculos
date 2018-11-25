package locadoraveiculos;

public class Cliente {
	
	private String nome;
	private int ID;
	private String endereco;
	private String tel;
	
        public Cliente(){
            
        }
        
	public Cliente(String name, String id, String end, String tel) {
		
		setNome(name);
		setID(id);
		setEndereco(end);
		setTel(tel);
		
	}
	
	public void setNome(String nome) {
		
            if(nome.isEmpty()){
                throw new IllegalArgumentException("O nome do cliente não deve ficar em branco");
            }else{
		this.nome = nome;
            }
		
	}
	
	public void setID(String ID) {
		
            try{
                int IdConvertido = Integer.parseInt(ID);
		this.ID = IdConvertido;
            }catch(java.lang.NumberFormatException e){
                throw new IllegalArgumentException("O ID informado deve conter apenas números");
            }
	}
	
	public void setEndereco(String endereco) {
		
            if(endereco.isEmpty()){
                throw new IllegalArgumentException("O endereço não deve ficar em branco");
            }else{
		this.endereco = endereco;
            }
	}
	
	public void setTel(String tel) {
		
            if(tel.isEmpty()){
                throw new IllegalArgumentException("Por favor, informe um telefone para contato");
            }else{
		this.tel = tel;
            }
                
		
	}
	
	public String getNome() {
		
		return nome;
		
	}
	
	public int getID() {
		
		return ID;
	}
	
	public String getTel() {
		
		return tel;
	}
	
	public String getEndereco() {
		
		return endereco;
	}
	
	public String toString()
	{
		return String.format("ID: %s\t"
				          + "NOME: %s     "
				          + "ENDEREÇO: %s     "
				          + "TELEFONE: %s     ", getID(), getNome(), getEndereco(), getTel());
	}

}
