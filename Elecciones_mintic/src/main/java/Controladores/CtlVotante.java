/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ClsVotante;
import Clases.ClsMensaje;
import Modelos.MdlVotante;
import java.util.LinkedList;
/**
 *
 * @author leiner
 */
public class CtlVotante {
    
    MdlVotante modeloVotante;
    
    public CtlVotante(){
    this.modeloVotante = new MdlVotante();
    }
    
 //   public LinkedList <ClsVotante> llamarVotante (){
 //       LinkedList<ClsVotante> listaVotante = this.modeloVotante.llamarVotante();
 //       return listaVotante;
 //   }  
    
    public ClsMensaje agregarVotante (ClsVotante votante){
        ClsMensaje mensaje = this.modeloVotante.agregarVotante(votante);
        return mensaje;
    }
    
 //   public ClsMensaje eliminarVotante(String id){
        
        
  //      ClsMensaje mensaje = this.modeloVotante.eliminarVotante(id);
        
 //       return mensaje;
  //  }
       
}
