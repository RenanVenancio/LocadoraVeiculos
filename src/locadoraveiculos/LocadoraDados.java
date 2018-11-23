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
    
    public static void cadastraCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    
    public static void removeCliente(int indice){
        listaClientes.remove(indice);
    }
    
    public static ArrayList<Cliente> getClientes(){
        return listaClientes;
    }
    
}
