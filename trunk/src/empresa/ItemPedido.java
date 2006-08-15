/*
 * ItemPedido.java
 *
 * Criado em 13 de Agosto de 2006, 14:13
 *
 */

package empresa;

import app.ConSQL;

/**
 *
 * @author Fernando Dettoni
 */
public class ItemPedido {
    private int idProd, idPedido;
    private double qtde, vlUnit, vlBruto, desc; 
    private ConSQL con;
    /** Creates a new instance of ItemPedido */
    public ItemPedido(int idProd, int idPed, double qtde, double vlUnit, double vlBruto, double desc, ConSQL con) {
        this.idProd = idProd;
        this.idPedido = idPed;
        this.qtde = qtde;
        this.vlUnit = vlUnit;
        this.vlBruto = vlBruto;
        this.desc = desc;
        this.con = con;
    }
    public int getIdProd() {
        return idProd;
    }
    public int getIdPed() {
        return idPedido;
    }
    public double getQtde() {
        return qtde;
    }
    public double getvlUnit() {
        return vlUnit;
    }
    public double getVlBruto() {
        return vlBruto;
    }
    public double getDesc() {
        return desc;
    }
    
    
}
