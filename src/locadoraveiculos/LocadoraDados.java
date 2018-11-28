/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

import java.util.ArrayList;

/**
 *Essa classe guarda todos os dados da locadora dentro de arraylists
 * Manipule os dados de cadastro dentro dessa classe
 * @author renan
 */

public class LocadoraDados {
    
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();  //Guarda todos  os clientes cadastrados
    private static ArrayList<LocacaoVeiculo> listaLocacoes = new ArrayList<LocacaoVeiculo>(); //Guarda todos  as locações registradas
    private static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>(); //Guarda todos  os veículos cadastrados
    
    
    
    /**
     * Esse método gera u código automático para um novo cliente
     * @return Retorna o código gerado
     */
    
    public static long setIdAuto(){
        int index = listaClientes.size()-1;
        
        if(index < 0){
            return 1;
        }
            return listaClientes.get(index).getID()+1;  
       
    }
    
    public static void cadastraCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    
    public static void alteraCliente(int indice, Cliente cliente){
        listaClientes.set(indice, cliente);
    }
    
    public static void removeCliente(int indice){
        listaClientes.remove(indice);
    }
    
    public static ArrayList<Cliente> getClientes(){
        return listaClientes;
    }
    
    /**
     * @param cod Forneça o codigo do veiculo para verificar se o cliente pode ser excluido
     * @return True cado o veiculo possa ser excluido False caso não
     */
    
    public static boolean verificaExclusaoCliente(int id){
        boolean podeExcluir = true;
        
        for(int i = 0; i < listaLocacoes.size(); i++){
           
            if(listaLocacoes.get(i).getCliente().getID() == id){
                
                podeExcluir = false;
                
            }
        }
        
        return podeExcluir;
        
    }
    
    //Fim metodos do cadastro do cliente
    
    
    
    
    
    //Metodos da locação
    
    public static void cadastraLocacao(LocacaoVeiculo locacaoVeiculo){
        System.out.println("CÓDIGO:" + locacaoVeiculo.getVeiculo().getCodigoAuto());
        verificarDisponibilidadeVeiculo(locacaoVeiculo.getVeiculo().getCodigoAuto());
        listaLocacoes.add(locacaoVeiculo);
        alinharDados();
    }
    
    
    public static void alteraLocacao(int indice, LocacaoVeiculo locacao){
        verificarDisponibilidadeVeiculo(locacao.getVeiculo().getCodigoAuto());
        listaLocacoes.set(indice, locacao);
        alinharDados();
        
    }
    
    
    /**
     * Esse método exclui uma locação
     * @param indice Informe o indice´para excluir
     */
    
    public static void removeLocacao(int indice){
        listaLocacoes.remove(indice);
        alinharDados();
    }
    
    public static void baixarLocacao(int indice){
        if(indice == -1){
            throw new IllegalArgumentException ("Indice não localizado!");
        }else if(listaLocacoes.get(indice).getStatus().equals("RECEBIDO")){
            throw new IllegalArgumentException ("Essa locação já se encontra baixada");
        }else{
        listaLocacoes.get(indice).setStatus("RECEBIDO");
        alinharDados();
        }
    }
    
    
    private static void verificarDisponibilidadeVeiculo(long codVeiculo){
        if(listaVeiculos.get(localizaVeiculoPorCodigo(codVeiculo)).isDisponivel() == false){
            throw new IllegalArgumentException("No momento este veículo não está disponívelpara locação");
        }
    }
    
    /**
     * 
     * @return retorna o array de locaçoes
     */
    
    public static ArrayList<LocacaoVeiculo> getLocacao(){
        return listaLocacoes;
    }
    
   
    //FIM Metodos da locação
    
    /**
     * Esse método faz o cadastro de um novo veículo
     * @param veiculo Passe um objeto do tipo veículo como parametro
     */
    public static void cadastraVeiculo(Veiculo veiculo){
        veiculo.setCodigoAuto(String.valueOf(setCodigoAutomatico()));
        listaVeiculos.add(veiculo);
    }
    
    /**
     * Este método realiza uma busca nos veículos cadastrados e retonra o indice no qual o mesmo está
     * @param cod deve ser informado o codigo do veiculo
     * @return retorna o indice onde o veiculo está localizado
     */
    
    public static int localizaVeiculoPorCodigo(long cod){
        int index = -1;
        for(int i=0; i < listaVeiculos.size(); i++){
            if(listaVeiculos.get(i).getCodigoAuto() == cod){
                index = i;
            }
        }
        return index;
        
    }
    
    
    /**
     * @param cod Forneça o codigo do veiculo para realizar a verificação
     * @return True cado o veiculo possa ser excluido False caso não
     */
    public static boolean verificaExclusaoVeiculo(long cod){
        boolean podeExcluir = true;
        
        for(int i = 0; i < listaLocacoes.size(); i++){
           
            if(listaLocacoes.get(i).getVeiculo().getCodigoAuto() == cod){
                
                podeExcluir = false;
               
            }
        }
       
        return podeExcluir;
        
    }
    
    
    /**
     * 
     * @return Retorna o arraylist com os veículos cadastradoos
     */
    
    public static ArrayList<Veiculo> getVeiculos(){
        return listaVeiculos;
    }
    
    
    /**
     * 
     * @param indice Forneça o indice do veículo para removê-lo
     */
    
    public static void removeVeiculo(int indice){
        
        long cod =  listaVeiculos.get(indice).getCodigoAuto();
        System.out.println("Delete o veidulo cod: " + cod);
        if(verificaExclusaoVeiculo(cod) == true){
        
        listaVeiculos.remove(localizaVeiculoPorCodigo(listaVeiculos.get(indice).getCodigoAuto()));
        
        }else{
            throw new IllegalArgumentException("Desculpe, esse veículo não pode ser deletado, pois evistem locações vinculadas a ele");
        }
        
    }
    
    
   /** 
    * 
    * @param cod Passe o código do viculo para removê-lo
    * @throws Lança excecão caso o veiculo não possa ser excluido
    */
    public static void removeVeiculoPorCod(int cod){
        
        
        
        if(verificaExclusaoVeiculo(cod)){
            listaVeiculos.remove(localizaVeiculoPorCodigo(cod));            
        }else{
            throw new IllegalArgumentException("Desculpe, esse veiculo não pode ser removido, pois existem locações vinculadas a ele");
        }
        
        
    }
    
    /**
     * 
     * @param indice Forneça o indice para alterar 
     * @param veiculo Forneça o objeto veículo com os dados já setados
     */
    
    public static void alteraVeiculo(int indice, Veiculo veiculo){
        listaVeiculos.set(indice, veiculo);
    }
    
    /**
     * 
     * @return Retorna o código gerado para usar no veículo
     */
    
    public static long setCodigoAutomatico(){
        int index = listaVeiculos.size()-1;
        
        if(index < 0){
            return 1;
        }
            return listaVeiculos.get(index).getCodigoAuto()+1;  
       
    }
    
       
    
    
    
    public static void baixaVeiculo(int cod){ //Torna veiculo indisponivel quando locado
        
        listaVeiculos.get(localizaVeiculoPorCodigo(cod)).setDisponivel(false);
        
    }
    //Metodos dos veiculos
    
    
    
    
    
    private static void alinharDados(){
        long atualizarCod;
        int indiceDoVeiculo;
        
        for(int j = 0; j < listaVeiculos.size(); j++){
            listaVeiculos.get(j).setDisponivel(true);
        }
        
        for(int i = 0; i < listaLocacoes.size(); i++){
            
            if(listaLocacoes.get(i).getStatus().equals("LOCADO")){
                atualizarCod = listaLocacoes.get(i).getVeiculo().getCodigoAuto();
                indiceDoVeiculo = localizaVeiculoPorCodigo(atualizarCod);
                listaVeiculos.get(indiceDoVeiculo).setDisponivel(false);
            }
        }
    }
    
    //FIM Metodos da veiculos
}
