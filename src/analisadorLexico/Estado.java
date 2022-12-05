package analisadorLexico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Samoyedem
 */
public class Estado {

    private int numero;
    private char letra;
    private boolean estadoInical;
    private boolean estadoFinal;
    private List<Estado> proximosEstados = new ArrayList<>();
    private boolean valido;

    public Estado(int numero, char letra) {
        this.numero = numero;
        this.letra = letra;
        this.valido = true;
    }

    public Estado(int numero, char letra, boolean estadoInical) {
        this.numero = numero;
        this.letra = letra;
        this.estadoInical = estadoInical;
        this.valido = true;
    }

    public Estado(char letra, boolean valido) {
        this.numero = 0;
        this.letra = letra;
        this.valido = valido;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public List<Estado> getProximosEstados() {
        return proximosEstados;
    }

    public void setProximosEstados(List<Estado> proximosEstados) {
        this.proximosEstados = proximosEstados;
    }

    public boolean isEstadoInical() {
        return estadoInical;
    }

    public void setEstadoInical(boolean estadoInical) {
        this.estadoInical = estadoInical;
    }

    public boolean isEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getDescricaoEstado() {
        String q = "";
        if (estadoInical) {
            q += "->";
        }
        if (estadoFinal) {
            q += "*";
        }
        q += "Q" + numero;
        return q;
    }

    public Estado getProximoEstado(char token) {
        if (proximosEstados != null && !proximosEstados.isEmpty()) {
            for (Estado proximosEstado : proximosEstados) {
                if (proximosEstado.getLetra() == token) {
                    return proximosEstado;
                }
            }
        }
        return null;
    }
}
