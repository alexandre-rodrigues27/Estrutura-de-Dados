import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Clima> lista = new ArrayList<>();
        /*Clima umClima = new Clima (ano: "2020", mes: "Janeiro", temperatura: "Quente", precipitacao: "Pouca")*/

        String linha = "2020,Janeiro,Quente,Pouca";
        String dadosLinha[] = linha.split(","); 
        Clima objClima = new Clima (dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);
        if (!lista.contains(objClima)) {
            lista.add (objClima);
        }

        //segunda linha
        linha = "2020,Janeiro,Frio,Muita";
        dadosLinha = linha.split(",");
        objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);
        if (!lista.contains(objClima)) {
            lista.add (objClima);
    }

        for (Clima c : lista) {
            System.out.println(c);
        }
    }
}
