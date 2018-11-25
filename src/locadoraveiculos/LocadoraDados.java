/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

import java.util.ArrayList;

/**
 *
 * @author renan
 */
public class LocadoraDados {
    
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private static ArrayList<LocacaoVeiculo> listaLocacoes = new ArrayList<LocacaoVeiculo>();
    private static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
    
    
    //Metodos do cadastro do cliente
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
    //Fim metodos do cadastro do cliente
    
    
    
    //Metodos da locação
    
    public static void cadastraLocacao(LocacaoVeiculo locacaoVeiculo){
        listaLocacoes.add(locacaoVeiculo);
    }
    
    public static ArrayList<LocacaoVeiculo> getLocacao(){
        return listaLocacoes;
    }
    
    public static void removeLocacao(int indice){
        listaLocacoes.remove(indice);
    }
    
    
    
    //FIM Metodos da locação
    
    
    public static void cadastraVeiculo(Veiculo veiculo){
        listaVeiculos.add(veiculo);
    }
    
    /**
     * 
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
    
    
    public static ArrayList<Veiculo> getVeiculos(){
        return listaVeiculos;
    }
    
    public static void removeVeiculo(int indice){
        listaVeiculos.remove(indice);
    }
    
    public static void alteraVeiculo(int indice, Veiculo veiculo){
        listaVeiculos.set(indice, veiculo);
    }
    
    public static long setCodigoAuto(){
        int index = listaVeiculos.size()-1;
        
        if(index < 0){
            return 1;
        }
            return listaVeiculos.get(index).getCodigoAuto()+1;  
       
    }
    
    
    public static void baixaVeiculo(int indice){ //Torna veiculo indisponivel quando locado
        
        listaVeiculos.get(indice).setDisponivel(false);
        
    }
    //Metodos dos veiculos
    
    
    
    //FIM Metodos da veiculos
}
