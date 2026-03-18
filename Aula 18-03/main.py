from clima import Clima

lista = []
nome_base = "base.csv"

try:
    #Abrindo o arquivo no modo leitura
    leitor = open(nome_base, "r", encoding="utf-8")

    for linha in leitor:
        dados_linha = linha.split(",")
        obj_clima = Clima(dados_linha[0], dados_linha[1], dados_linha[2], dados_linha[3])
        
        if obj_clima not in lista:
            lista.append(obj_clima)

    #Fechando o arquivo
    leitor.close()

    for item in lista:
        print(item, end="")

except Exception as e:
    print("Ocorreu algum erro..", e)
    
