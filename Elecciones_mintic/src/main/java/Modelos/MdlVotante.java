/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsVotante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;



/**
 *
 * @author leine
 */
public class MdlVotante {
    
        ClsJdbc jdbc;
    
    //MdlCandidato modelocandidato;

    public MdlVotante() {
        this.jdbc = new ClsJdbc();
        this.jdbc.crearConexion();
    }
    
    public ClsMensaje agregarVotante(ClsVotante votante) {

        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_registro_votante VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement sentencia = this.jdbc.conexio.prepareStatement(sql);
            sentencia.setString(1, votante.getCedula());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());


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
    
    public LinkedList <ClsVotante> llamarcandidato (){    
        try{
                LinkedList <ClsVotante> lista = new LinkedList<>();
                String cosulta = "SELECT * FROM tbl_registro_votante";
                PreparedStatement sentencia = this.jdbc.conexio.prepareStatement(cosulta);
                ResultSet  resultado = sentencia.executeQuery();
                
                while (resultado.next()){
                        String ndocumento = resultado.getString("ncedula ");
                        String nombre = resultado.getString("nombre");
                        String telefono = resultado.getString("telefono");
                        String correo =  resultado.getString("correo");
                        String ciudad = resultado.getString("ciudad");
                        String contrasena = resultado .getString("contrasena");
                        int estado = resultado.getInt("estado");

            
                        ClsVotante votante = new ClsVotante(ndocumento, nombre, telefono, correo, ciudad, contrasena, estado);
                        
                        lista. add(votante);
                }

                return  lista;    
        }  
        catch (Exception e){
                return null;
        }
    }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
    public ClsMensaje eliminarVotante(String id) {

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
    **/
    
    
    
    
}
