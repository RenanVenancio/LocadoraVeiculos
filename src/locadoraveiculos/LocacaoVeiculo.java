package locadoraveiculos;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class LocacaoVeiculo {
	
	private Veiculo veiculo;
	private Cliente cliente; 
	private double valorDiaria = 0.00;
	private int dias = 1;
	private double valorSeguro = 0.00;
	private double desconto = 0.00;
	private boolean disponibilidade;
        private String dataIni;
        private String dataFin;
        private boolean possuiSeguro;
        private double valorTotal = 0.00;
        private String status;
        
        
        
    public LocacaoVeiculo(){
        
    }    

    public LocacaoVeiculo(Veiculo veiculo, Cliente cliente, String valorDiaria, String dias, String desconto, boolean disponibilidade, String dataIni, String dataFin, boolean possuiSeguro) {
        setVeiculo(veiculo);
        setCliente(cliente);
        setValorDiaria(valorDiaria);
        setDias(dias);
        setDesconto(desconto);
        setDisponibilidade(disponibilidade);
        setDataIni(dataIni);
        setDataFin(dataFin);
        setPossuiSeguro(possuiSeguro);
        
        setValorLocacao();      //Setando o valor da locação
    }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

	public void setValorDiaria(String valorDiaria) {
            
            try{
            valorDiaria = valorDiaria.replaceAll(",", ".");    
            double valorDiariaConv = Double.parseDouble(valorDiaria);
            this.valorDiaria = valorDiariaConv;
            
            }catch(NumberFormatException e){
                
                throw new IllegalArgumentException("O valor da diária é inválido");
                
            }
            
		
	}
	
	
	
	public double valorLocacao() {
		
		return (valorDiaria * dias * getValorSeguro());
	}
   
	public double locacaoComDesconto() {
		
		return valorLocacao() - valorLocacao() * 0.12;
	}
	
	public void exibirListaVeiculos() {
		
		
		
	}
        
        public Cliente getCliente(){
            return cliente;
        }
        
        public void setCliente(Cliente cliente){
            this.cliente = cliente;
        }
        
        public void setDesconto(String desconto){
            
            try{
                desconto = desconto.replaceAll(",", ".");
                double descontoConv = Double.parseDouble(desconto);
                this.desconto = descontoConv;
            
            }catch(NumberFormatException e){
                
                throw new IllegalArgumentException("Informe um valor válido para o desconto");
                
            }
            
        }

        public double getValorDiaria() {
            return valorDiaria;
        }

        public double getDesconto() {
            return desconto;
        }
        
        

        public Veiculo getVeiculo() {
            return veiculo;
        }

        public void setVeiculo(Veiculo veiculo) {
            this.veiculo = veiculo;
        }

        public String getDataIni() {
            return dataIni;
        }

        public void setDataIni(String dataIni) {
            
            if(dataIni.isEmpty()){
                throw new IllegalArgumentException("A data inicial não pode ficar em branco");
             }else{
                this.dataIni = dataIni;
            }
            
            
        }

        public String getDataFin() {
            return dataFin;
        }

        public void setDataFin(String dataFin) {
            
             if(dataFin.isEmpty()){
                throw new IllegalArgumentException("A data inicial não pode ficar em branco");
             }else{
                this.dataFin = dataFin;
            }
                        
        }

        public int getDias() {
            return dias;
        }

        public void setDias(String dias) {
            
            try{
                
                int diasConv = Integer.parseInt(dias);
                this.dias = diasConv;
            
            }catch(NumberFormatException e){
                
                throw new IllegalArgumentException("A quantidade de dias deve ser um número inteiro");
                
            }
         
        }

        public boolean isDisponibilidade() {
            return disponibilidade;
        }

        public void setDisponibilidade(boolean disponibilidade) {
            this.disponibilidade = disponibilidade;
        }

        public boolean isPossuiSeguro() {
            return possuiSeguro;
        }

        public void setPossuiSeguro(boolean possuiSeguro) {
            this.possuiSeguro = possuiSeguro;
        }
        
        
        public void setValorSeguro() {
		DecimalFormat df = new DecimalFormat("0.00");
                df.setRoundingMode(RoundingMode.HALF_UP);
	
		if(veiculo.getTipo().equals("CARRO") && (possuiSeguro == true)){
                        
			 valorSeguro =  (0.05 * valorDiaria * (1.0 + veiculo.getPassageiros()/20.0));
                         
                        
		}
                else if(veiculo.getTipo().equals("MOTO") && (possuiSeguro == true))
		{       System.out.println("Calculando valor do seguro da moto");
			 valorSeguro =  0.09 * valorDiaria;
		}else{
                    System.out.println("Veiculo sem seguro");
                    valorSeguro = 0.00;
                }
	}
        
        
        public double getValorSeguro() {
		
		return valorSeguro;
	}
        
        public void setValorLocacao(){
            
            
            
            setValorSeguro();
            valorTotal = getValorLocacao();
            
            
            if(desconto > 12.00){
                throw new IllegalArgumentException("A porcentagem de desconto não deve ultrapassar 12%");
                
            }else if(desconto < 0.00){
                throw new IllegalArgumentException("A porcentagem de desconto deve ser um valor positivo");
            }else{
                
                
                valorTotal = ((((veiculo.getValorDiaria()+valorSeguro) * dias)) - ((((veiculo.getValorDiaria()+valorSeguro) * dias))*(desconto/100)));
                
                
                
            }
            
            
        }
        
        public double getValorLocacao(){
            
            
            return valorTotal;
           
        }

    @Override
    public String toString() {
        
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        
        return "CLIENTE: " + cliente.getID()+ " | " + cliente.getNome() + 
                "   VEICULO: " + veiculo.getDescricao() +
                "   R$ DIA: " + veiculo.getValorDiaria() +
                "   DIAS: " + dias + 
                "   R$ SEGURO: " + df.format(valorSeguro) + 
                "   DECONTO (%): " + df.format(desconto) + 
                "   TOTAL: " + df.format(valorTotal) +
                "   STATUS: " + status;
                
    } 
        
        
       
        
        
        
        

}
