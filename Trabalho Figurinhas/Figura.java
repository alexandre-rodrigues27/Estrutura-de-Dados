package pkg;

public class Figura {
    private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean rara;

    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    public String toCSV() {
        return nomeSelecao + ";" + numeroFigura + ";" + descricao + ";" + quantidade + ";" + rara;
    }

    public static Figura fromCSV(String linha) {
        String[] partes = linha.split(";");
        if (partes.length < 5) return null;
        return new Figura(
            partes[0],
            Integer.parseInt(partes[1]),
            partes[2],
            Integer.parseInt(partes[3]),
            Boolean.parseBoolean(partes[4])
        );
    }

    public String getNomeSelecao() {
		return nomeSelecao;
	}

	public int getNumeroFigura() {
		return numeroFigura;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isRara() {
		return rara;
	}

	@Override
    public String toString() {
        return String.format("[%d] %s - %s (%s) | Qtd: %d", 
                numeroFigura, nomeSelecao, descricao, (rara ? "RARA" : "Normal"), quantidade);
    }

}
