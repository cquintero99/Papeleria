/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;



import DAO.RegistrarProducto;
import Servicios.Conexion;
import VO.Producto;
import java.sql.PreparedStatement;

import java.util.ArrayList;

/**
 *
 * @author 57310
 */
public class Control {
    private RegistrarProducto rp=new RegistrarProducto();

    public void registrar(Producto p) {
        try {
         //   RegistrarProducto rp = new RegistrarProducto();

            rp.registrar(Conexion.obtener(), p);
        } catch (Exception e) {

        }
    }
    public void actualizar(Integer codigo,String categoria,String descripcion ,Integer valor,Integer stock){
        try{
          //  RegistrarProducto rp=new RegistrarProducto();
            rp.actualizar(Conexion.obtener(), codigo,categoria, descripcion, valor, stock);
        }catch(Exception e){
            
        }
    }
    public Producto buscarProducto(String codigo){
        try{
        return rp.buscar(Conexion.obtener(), codigo);
        }catch(Exception e){
            
        }
        return null;
    }
    public void eliminar(Integer codigo){
        try{
            //RegistrarProducto rp=new RegistrarProducto();
            rp.eliminar(Conexion.obtener(), codigo);
        }catch(Exception e){
            
        }
    }
    public void comprar(Integer cantida,Integer codigo){
        try{
          //  RegistrarProducto rp=new RegistrarProducto();
            rp.compra(Conexion.obtener(), cantida, codigo);
        }catch(Exception e){
            
        }
    }

    public ArrayList productos(String categoria) {
        try {
          //  RegistrarProducto rp = new RegistrarProducto();
            return rp.buscarProductos(Conexion.obtener(), categoria);
        } catch (Exception e) {

        }

        return null;
    }
    public Producto buscar(String decripcion){
        try{
          //  RegistrarProducto rp=new RegistrarProducto();
           return  rp.buscarporNombre(Conexion.obtener(), decripcion);
        }catch(Exception e){
            
        }
        return null;
    }
  
}
