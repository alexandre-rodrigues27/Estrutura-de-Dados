from clima import Clima

lista = []

linha = "2020, Janeiro, Quente, Pouca";
dadosLinha = linha.split(",");

    
obj_Clima = Clima (dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);

if obj_Clima not in lista:
    lista.append(obj_Clima)

#sugunda linha
linha = "2020, Janeiro, Frio, Muita";
dadosLinha = linha.split(",");

    
obj_Clima = Clima (dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);

if obj_Clima not in lista:
    lista.append(obj_Clima)

for c in lista:
    print(c)
