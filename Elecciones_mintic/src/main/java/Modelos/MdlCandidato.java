/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


import Clases.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;


/**
 *
 * @author leiner
 */
public class MdlCandidato {
    
    ClsJdbc jdbc;
    
    //MdlCandidato modelocandidato;

    public MdlCandidato() {
        this.jdbc = new ClsJdbc();
        this.jdbc.crearConexion();
    }

    public ClsMensaje eliminarCandidato(String id) {

        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_registro_candidato WHERE tipo_cedula = ?";
            
            
            PreparedStatement sentencia = this.jdbc.conexio.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado un cadidato exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }
    
 
    
    
    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_registro_candidato VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement sentencia = this.jdbc.conexio.prepareStatement(sql);
            sentencia.setString(1, candidato.getCedula());
            sentencia.setString(2, candidato.getNombre());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getPartidoPoliticoCandidato());
            sentencia.setString(5, candidato.getCiudad());
            sentencia.setString(6, candidato.getBiografiaCandidato());
            sentencia.setString(7, candidato.getSmsCampana());
            sentencia.setString(8, candidato.getPropuestaCandidato());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has creado un cadidato exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }
     
    
    public LinkedList <ClsCandidato> llamarcandidato (){    
        try{
                LinkedList <ClsCandidato> lista = new LinkedList<>();
                String cosulta = "SELECT * FROM tbl_registro_candidato";
                PreparedStatement sentencia = this.jdbc.conexio.prepareStatement(cosulta);
                ResultSet  resultado = sentencia.executeQuery();
                
                while (resultado.next()){
                        String ndocumento = resultado.getString("numeroCedula");
                        String nombre = resultado.getString("nombre");
                        String telefono = resultado.getString("telefono");
                        String partido =  resultado.getString("partido");
                        String ciudad = resultado.getString("ciudad");
                        String biografia = resultado .getString("biografia");                  
                        String campania = resultado.getString("smsCampana");
                        String propuesta = resultado.getString("propuesta");
            
                        ClsCandidato candidato = new ClsCandidato(ndocumento, nombre, telefono, 
                                partido, ciudad, biografia, campania, propuesta);
                        
                        lista. add(candidato);
                }

                return  lista;    
        }  
        catch (Exception e){
                return null;
        }
    }   
}
