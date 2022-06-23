package produto;

import ingredientes.*;

import java.util.ArrayList;
import java.util.List;

public class Shake {
    private Base base;
    private Fruta fruta;
    private Topping topping;
    private List<Adicional> adicionais;
    private TipoTamanho  tipoTamanho;

    public Shake(Base base,Fruta fruta,Topping topping,TipoTamanho tamanho){

        this.base=base;
        this.fruta= fruta;
        this.topping=topping;
        this.tipoTamanho=tamanho;
        this.adicionais= new ArrayList<>();

    }
    public Shake(Base base,Fruta fruta,Topping topping,List<Adicional> adicionais,TipoTamanho tamanho){
        this.base=base;
        this.fruta= fruta;
        this.topping=topping;
        this.adicionais=adicionais;
        this.tipoTamanho=tamanho;

        this.adicionais.sort(null);
    }

    public Base getBase() {
        return base;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public Topping getTopping() {
        return topping;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public TipoTamanho getTipoTamanho() {
        return tipoTamanho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shake)) return false;

        Shake shake = (Shake) o;

        if (base != null ? !base.equals(shake.base) : shake.base != null) return false;
        if (fruta != null ? !fruta.equals(shake.fruta) : shake.fruta != null) return false;
        if (topping != null ? !topping.equals(shake.topping) : shake.topping != null) return false;
        if (adicionais != null ? !adicionais.equals(shake.adicionais) : shake.adicionais != null) return false;
        return tipoTamanho == shake.tipoTamanho;
    }

    @Override
    public int hashCode() {
        int result = base != null ? base.hashCode() : 0;
        result = 31 * result + (fruta != null ? fruta.hashCode() : 0);
        result = 31 * result + (topping != null ? topping.hashCode() : 0);
        result = 31 * result + (adicionais != null ? adicionais.hashCode() : 0);
        result = 31 * result + (tipoTamanho != null ? tipoTamanho.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.base.getTipoBase().toString() + " / " + this.fruta.getTipoFruta().toString() + " / " + this.topping.getTipoTopping().toString() + " / " + this.adicionais + " / " + this.tipoTamanho.toString();
    }
}
