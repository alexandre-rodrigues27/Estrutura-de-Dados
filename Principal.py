from Glicemia import Glicemia
from minhas_funcoes import popular_lista_arquivo, exibir_lista, calcular_media

lista = []
nome_base = "dados.csv"

popular_lista_arquivo(lista, nome_base)
exibir_lista(lista)
 
media = calcular_media(lista)
print ("Média glicêmica: ", media)
