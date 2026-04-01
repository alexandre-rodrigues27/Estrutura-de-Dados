//cd Downloads
//javac Principal.java Clima.java
//java Principal

public class Clima {
    public String ano;
    public String mes;
    public String temperatura;
    public String precipitacao;

    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    //Reescrevemo toString para exibir um objeto completo da classe
    @Override
    public String toString() {
        return "Clima [Ano = " + this.ano + ", Mes = " + this.mes + ", Temperatura = " + this.temperatura + ", Precipitacao = " + this.precipitacao + "]";
    }

    //Reescrevemo esquals para definir os atributos identificadores
    @Override
    public boolean equals(Object obj) { 

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Clima c = (Clima) obj;

        return this.ano.equals(c.ano) && this.mes.equals(c.mes);
    }
}