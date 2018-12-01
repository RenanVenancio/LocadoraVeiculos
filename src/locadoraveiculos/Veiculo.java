package locadoraveiculos;

public class Veiculo {
    long codigoAuto = 0;
    private String tipo;
    private double valorDiaria;	
    private String descricao;
    private String placa;
    private int passageiros;
    private String partida;	
    private String marca;
    private boolean disponivel;

   public Veiculo(){
       
   }
    
    
    public Veiculo(String codigoAuto, String tipo, String valorDiaria, String descricao, String placa, String passageiros, String partida, String marca, boolean disponivel) {
        setCodigoAuto(codigoAuto);
        setTipo(tipo);
        setValorDiaria(valorDiaria);
        setDescricao(descricao);
        setPlaca(placa);
        setPassageiros(passageiros);
        setPartida(partida);
        setMarca(marca);
        setDisponivel(disponivel);
    }

    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(String valorDiaria) {
        try{
            valorDiaria = valorDiaria.replaceAll(",", ".");
            double valorDiariaConv = Double.parseDouble(valorDiaria);
            this.valorDiaria = valorDiariaConv;
            
            if(valorDiariaConv < 0){
                throw new IllegalArgumentException("O Valor da diária deve ser um valor positivo");
            }else if(valorDiariaConv > 1000000){
                throw new IllegalArgumentException("O Valor da diária está incorreto");
            }
            
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("O valor da diária é inválido");
        }
        
        
        
        
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao.isEmpty()){
            throw new IllegalArgumentException("A descrição do veículo deve ser preenchida");
        }else{
            this.descricao = descricao;
        }
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        
        if(placa.isEmpty()){
            throw new IllegalArgumentException("Por favor, informe a placa do veículo");
        }else{
            this.placa = placa;
        }
    }

    public int getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(String passageiros) {
        
        int passageirosConv;
         
        try{
            passageirosConv = Integer.parseInt(passageiros);
            this.passageiros = passageirosConv;
            
            if((passageirosConv >= 100) || (passageirosConv <= 0)){
                throw new IllegalArgumentException("O número de passageiros não é válido: Informe um numero entre 1 e 100");
            }
            
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("O número de passageiros deve ser um número inteiro");
        }
        
        
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public long getCodigoAuto(){
        return codigoAuto;
    }
    public void setCodigoAuto(String codigo){
        
        try{
            long codConvetido = Long.parseLong(codigo);
            this.codigoAuto = codConvetido;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Por favor, clique em novo para iniciar o cadastro");
        }
      
    }
        
    
    public String toString(){
        
        String disp;
        if(isDisponivel()){
            disp = "DISPONIVEL";
        }else{
            disp = "INDISPONIVEL";
        }
		return String.format("CÓD: %s     "  
				          + "TIPO: %s     "
				          + "DESCRIÇÃO: %s     "
				          + "PLACA: %s     "
                                          + "Nº PASSAGEIROS: %s     "
                                          + "%s      ",     String.valueOf(getCodigoAuto()), getTipo(), getDescricao(), getPlaca(), String.valueOf(getPassageiros()), disp);
	}    
        
    }
    
    
    
    
    
        
        
	
	


