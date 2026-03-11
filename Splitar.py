from Glicemia import Glicemia

linha = "120,11/03/2026,9:00"

#splitar linha
vetor_linha = linha.split(",")

#criar objeto de Glicemia
obj = Glicemia(int(vetor_linha[0]), vetor_linha[1], vetor_linha[2])

if obj not in lista:
    lista.append(obj)
