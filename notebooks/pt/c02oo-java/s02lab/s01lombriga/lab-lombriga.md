# Lombriga no Aquário

Escreva uma classe em Java em que cada objeto representa uma lombriga em um aquário.

## Lombriga

A lombriga é representada por um caractere da cabeça `O` seguido por uma sequência de caracteres `@`, cujo número de total caracteres (incluindo a cabeça) é equivalente ao tamanho. Por exemplo, uma lombriga de tamanho 4 seria representada assim:

~~~
O@@@
~~~

A cabeça indica o lado para o qual a lombriga está virada. No exemplo anterior, a lombriga está virada para a esquerda.

## Aquário

O espaço do aquário também é representado por uma sequência de caracteres `#`. Por exemplo, um aquário de tamanho 8 é representado assim:

~~~
########
~~~

## Lombriga no Aquário

Sempre o aquário e a lombriga são representados em uma única linha. A lombriga ocupa espaços vazios do aquário. Por exemplo, uma lombriga de tamanho 4 em um aquário de tamanho 8, pode ser representado assim:

~~~
##O@@@##
~~~

## Se Movendo pelo Aquário

Note que a lombriga pode estar em qualquer posição do aquário, desde que ela caiba no espaço disponível.  A primeira posição no aquário é sempre 1 (e não 0 como em um vetor em Java).

A lombriga pode se mover pelo aquário sempre para a direção para a qual ela está virada. No exemplo anterior, a lombriga daria um passo assim:

~~~
#O@@@###
~~~

## Tamanho da Lombriga

A lombriga pode crescer de tamanho, sempre uma unidade de cada vez na direção oposta à cabeça. No exemplo anterior, se a lombriga crescer ela fica assim:

~~~
#O@@@@##
~~~

## Virar de Lado

Uma lombriga pode virar de lado. No exemplo anterior, se a lombriga virar de lado ela fica assim:

~~~
#@@@@O##
~~~

__________________________________


# Tarefa

Escreva uma classe denominada `AquarioLombriga` em que cada objeto representa uma lombriga dentro de um aquário (ambos estarão juntos em um único objeto).

## Atributos

Você deve decidir quais os atributos definirá.

## Métodos

* `construtor` - No construtor são informados como parâmetros: o tamanho do aquário, o tamanho da lombriga e a posição inicial da cabeça da lombriga no aquário. A lombriga é sempre construída com a cabeça inicialmente virada para a esquerda. Se for informado um tamanho de lombriga maior que a do aquário, a lombriga passa a ter o tamanho do aquário. Se for informada uma posição inválida (fora do aquário ou de um modo que a lombriga fique com um pedaço fora do aquário), a posição passa a ser 1. Ficará a seu critério como tratar outras possibilidades de valores inválidos para parâmetros.
* `crescer` - A lombriga cresce uma unidade dentro do aquário na direção oposta à cabeça. A lombriga só cresce se houver espaço no aquário na direção do crescimento, caso contrário, ela não crescerá, mesmo que o método seja chamado.
* `mover` - A lombriga se move uma unidade na direção para a qual está virada à cabeça. Se ela estiver no limite do aquário (para o lado que ela está virada a cabeça) e for chamado este método ela vira de lado em vez de andar.
* `virar` - A lombriga vira de lado.
* `apresenta` - Retorna uma String contendo a apresentação da lombriga no aquário no estado atual, conforme foi descrito anteriormente.

O Aquário tem tamanho máximo de 15 caracteres.
__________________________________

# Animando a Lombriga no Aquário

Escreva uma classe em Java que representa uma sequência de ações para animar uma lombriga em um aquário. A sequência de ações é representada pela string:

~~~
AALLPP$$$$$$$$$$
~~~

* `AA` - é um número (sempre ocupando dois caracteres) representando o tamanho do aquário; por exemplo, `08` representa um aquário de tamanho 8;
* `LL` - é um número (sempre ocupando dois caracteres) representando o tamanho da lombriga; por exemplo, `04` representa uma lombriga de tamanho 4;
* `PP` - é um número (sempre ocupando dois caracteres) representando a posição inicial da cabeça da lombriga no aquário -- a lombriga começa sempre virada para a esquerda; por exemplo, `03` representa uma lombriga na posição 3.

A sequência:

~~~
080403
~~~

Representa um aquário de tamanho 8, com uma lombriga de tamanho 4, cuja cabeça está na posição 3:

~~~
##O@@@##
~~~

* `$` - cada caractere subsequente (que aparece como `$`) representa um dos possíveis comandos de animação, equivalentes aos métodos da lombriga:
  * `C` - a lombriga cresce;
  * `M` - a lombriga se move;
  * `V` - a lombriga vira.

~~~
080403MCMVM
~~~

A lombriga do exemplo anterior os passos de animação são: se move, cresce, se move, vira e se move.

__________________________________

# Tarefa

Escreva uma classe denominada `Animacao` em que cada objeto representa uma animação de uma lombriga em um aquário.

## Atributos

Você deve decidir quais os atributos definirá.

## Métodos

* `construtor` - no construtor é informado como parâmetro: a string de animação, conforme a descrição anterior;
* `apresenta` - retorna uma String com a lombriga no aquário no estado atual (a primeira vez     que o método é chamado, apresenta o estado inicial da lombriga - sem animação);
* `passo` - executa um único passo da animação.

Por exemplo, considere a animação do exemplo anterior:
~~~
080403MCMVM
~~~

Considere que foi chamada a seguinte sequência de métodos:
* `construtor` - passa como parâmetro `080403MCMVM`;
* `apresenta` - retorna `##O@@@##`
* `passo` - executa primeira ação `M`
* `apresenta` -  retorna `#O@@@###`
* `passo` - executa próxima ação `C`
* `apresenta`- retorna `#O@@@@##`
* `passo` - executa próxima ação `M`
* `apresenta` - retorna `O@@@@###`
* `passo` - executa próxima ação `V`
* `apresenta`- retorna `@@@@O###`
* `passo` - executa próxima ação `M`
* `apresenta` - retorna `#@@@@O##`

__________________________________

# Programa

Escreva um programa que use as suas classes para mostrar todos os passos da animação no console a partir do [TEMPLATE](lombriga.zip).

O programa deve ser criado usando o Eclipse ou equivalente seguindo os critérios:
* todo o código deve estar no pacote: `pt.c02oo.s02classe.s03lombriga` -- não criar sub-pacotes;
* o programa principal (main) deve estar em uma terceira classe chamada `AppLombriga`.
* devem ser usados os métodos:
  * `Toolkit.start()` - para iniciar o toolkit;
  * `recuperaLombrigas()` - para recuperar as sequências de animação em um vetor de strings (uma por linha);
* `gravaPasso()` - para gravar cada passo da animação - cada nova animação deve começar com `=====`;
* `stop()` - no final de tudo.

# Observações Finais Importantes

* O nome das classes e métodos deve ser rigorosamente como o especificado.
* Cada um tem a liberdade de decidir como tratar as condições excepcionais não especificadas.
