# Perguntas Frequentes

## Menos Perguntas
* **Pergunta:** Se o processo para se fazer menos perguntas consumir mais processamento que simplesmente fazer a pergunta, vale a pena?
* **Resposta:** Sim, sempre vale a pena fazer menos perguntas, porque este sistema simula o que seria no mundo real, em que sempre vale a pena perguntar menos.

## Eclipse ou Jupyter
* **Pergunta:** Qual ambiente deve ser usado para o desenvolvimento do trabalho?
* **Resposta:** Pode ser usado o Jupyter ou o Eclipse. Sugere-se que o Jupyter seja usado para prototipar, mas será difícil a importação de outros componentes nele, portanto, recomenda-se o Eclipse para a versão final.

## Distribuição de Componentes
* **Pergunta:** Como serão organizados os componentes para distribuição?
* **Resposta:** Será usado um modelo Java de empacotamento baseado no `.jar`.

## Sugestões de expansão para a Parte 2
* **Pergunta:** Que coisas a mais podem ser feitas além de melhorar o desempenho do diagnóstico?
* **Resposta:** Segue uma lista de ideias:
    * melhorando o desempenho do diagnóstico (parte 1 que será usada na parte 2);
    * criar outras possibilidades de análise (e.g., gerando gráficos; listando doenças com sintomas comuns);
    * melhorando o sistema de casos com novas possibilidades - por exemplo, criando bases com casos reais;
    * usando aprendizagem de máquina para diagnósticos;
    * melhorando a apresentação visual - e.g., interface gráfica.

## Mais de um diagnóstico possível
* **Pergunta:** Quando há mais de um diagnóstico possível, como definir um único diagnóstico final (`finalAnswer`)?
* **Resposta:** O médico tem que sempre decidir, mas não necessariamente ele acerta sempre, já que não é um sistema determinístico. Para melhorar a resposta, quando houver mais de uma possibilidade, sugere-se o uso de heurísticas como, por exemplo, em qual das opções há mais casos registrados.
