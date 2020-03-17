/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import api.Api;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Producto;

/**
 *
 * @author felip
 */
@ManagedBean (name = "productoBean")
@ViewScoped
public class ProductoBean implements Serializable{
    private List<Producto> lista = new ArrayList<>();
    
    
    @PostConstruct
    public void init() {
        consultar();
    }
    
    
    public void consultar(){         
        lista = new Api().listar();        
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    
    
}
