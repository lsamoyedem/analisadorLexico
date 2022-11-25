package analizadorLexico;

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

    public Estado(int numero, char letra) {
        this.numero = numero;
        this.letra = letra;
    }

    public Estado(int numero, char letra, boolean estadoInical) {
        this.numero = numero;
        this.letra = letra;
        this.estadoInical = estadoInical;
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
