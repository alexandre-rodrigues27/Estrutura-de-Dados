public class Aluno {
	
	public String nome;
	public String curso;
	public String sexo;
	public int anoIngresso;
	
	Aluno(String nome, String curso, String sexo, int anoIngresso) {
		this.nome = nome;
	    this.curso = curso;
	    this.sexo = sexo;
	    this.anoIngresso = anoIngresso;
	}
	
	public String getNome() {
        return nome;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", curso=" + curso + ", sexo=" + sexo + ", anoIngresso=" + anoIngresso + "]";
    }
    
   
}
