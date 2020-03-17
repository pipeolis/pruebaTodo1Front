/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Remote;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import model.Origen;
import model.Producto;
import model.TipoProducto;

/**
 *
 * @author felip
 */
@Remote
public class Api {
    
    private final String URL_GET_PRODUCTOS = "http://localhost:7070/producto";
    private final String URL_GET_TIPOPRODUCTOS = "http://localhost:7070/tipoproducto";
    private final String URL_GET_ORIGENES = "http://localhost:7070/origen";

    public Api() {
    }   
    
    public List<Producto> listar(){
        List<Producto> lista = new ArrayList<>();
        Client client = ClientBuilder.newClient();
        WebTarget rs = client.target(URL_GET_PRODUCTOS);
        JsonArray jsonArray = (JsonArray) rs
                            .request(MediaType.APPLICATION_JSON)
                            .get(JsonObject.class);
        
        Gson gson =  new Gson();        
        if (jsonArray != null) {
            Iterator iter = jsonArray.iterator();
            while (iter.hasNext()) {
               JsonObject json = (JsonObject) iter.next();
               lista.add(gson.fromJson(json.toString(), Producto.class));
            }
        }  
        try {
            lista.forEach((Producto p) -> {
                p.setTipo(getDescTipoProducto(p));
                p.setOrigen(getDescTipoProducto(p));
            });         
        } catch (Exception e) {
            Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }
    
    

        
    public List<TipoProducto> listarTipoProducto(){
        List<TipoProducto> lista = new ArrayList<>();
        Client client = ClientBuilder.newClient();
        WebTarget rs = client.target(URL_GET_TIPOPRODUCTOS);
        JsonArray jsonArray = (JsonArray) rs
                            .request(MediaType.APPLICATION_JSON)
                            .get(JsonObject.class);
        
        Gson gson =  new Gson();        
        if (jsonArray != null) {
            Iterator iter = jsonArray.iterator();
            while (iter.hasNext()) {
               JsonObject json = (JsonObject) iter.next();
               lista.add(gson.fromJson(json.toString(), TipoProducto.class));
            }
        }        
        return lista;
    }
    
    public String getDescTipoProducto(Producto p){
        List<TipoProducto> listaTipoProd = listarTipoProducto();
        return listaTipoProd.stream()
                            .filter(t -> t.getIdTipoProducto() == p.getIdProducto())
                            .collect(Collectors.toList()).get(0).getDescripcion();
    }
    
    public List<Origen> listarOrigen(){
        List<Origen> lista = new ArrayList<>();
        Client client = ClientBuilder.newClient();
        WebTarget rs = client.target(URL_GET_ORIGENES);
        JsonArray jsonArray = (JsonArray) rs
                            .request(MediaType.APPLICATION_JSON)
                            .get(JsonObject.class);
        
        Gson gson =  new Gson();        
        if (jsonArray != null) {
            Iterator iter = jsonArray.iterator();
            while (iter.hasNext()) {
               JsonObject json = (JsonObject) iter.next();
               lista.add(gson.fromJson(json.toString(), Origen.class));
            }
        }        
        return lista;
    }
    
    public String getDescOrigen(Producto p){
        List<Origen> listaOrigen = listarOrigen();
        return listaOrigen.stream()
                            .filter(t -> t.getIdOrigen() == p.getIdOrigen())
                            .collect(Collectors.toList()).get(0).getDescripcion();
    }
}
