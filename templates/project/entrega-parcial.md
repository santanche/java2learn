# Modelo de Apresentação Parcial do Projeto

# Estrutura de Arquivos e Pastas

A estrutura aqui apresentada é uma simplificação daquela proposta pelo [Cookiecutter Data Science](https://drivendata.github.io/cookiecutter-data-science/). Também será aceito que o projeto adote a estrutura completa do Cookiecutter Data Science e isso será considerado um diferencial. A estrutura geral é a seguinte e será detalhada a seguir:

~~~
├── README.md          <- apresentação do projeto
│
├── data               <- dados usados pelo jogo (se houver)
│
├── notebooks          <- Jupyter notebooks ou equivalentes
│
├── src                <- projeto em Java (preferencialmente projeto no Eclipse)
│   │
│   ├── src            <- arquivos-fonte do projeto (.java)
│   │
│   ├── bin            <- arquivos em bytecode (.class)
│   │
│   └── README.md      <- instruções básicas de instalação/execução
│
└── assets             <- mídias usadas no projeto
~~~

Na raiz deve haver um arquivo de nome `README.md` contendo a apresentação do projeto, como detalhado na seção seguinte.

## `data`

Arquivos de dados usados no projeto, quando isso ocorrer. Por exemplo, se o jogo lê mapas de labirintos que estão em arquivo-texto, coloque os arquivos aqui (mesmo que você mantenha uma cópia no diretório do código).

## `notebooks`

Testes ou prototipos relacionados ao projeto que tenham sido executados no Jupyter. Por exemplo, coloque aqui uma cópia dos testes feitos nas Exceptions.

## `src`

Projeto em Java, preferencialmente em Eclipse, incluindo todos os arquivos de dados e bibliotecas necessários para a sua execução. Dentro dessa pasta sugerimos que você mantenha uma estrutura equivalente ao Eclipse, com uma subpasta `src` onde estarão os fontes e outra subpasta `bin` onde estarão os bytecodes.

 Acrescente na raiz um arquivo `README.md` com as instruções básicas de instalação e execução.

## `assets`

Qualquer mídia usada no seu projeto: vídeo, imagens, animações, slides etc. Coloque os arquivos aqui (mesmo que você mantenha uma cópia no diretório do código).

# Modelo para Apresentação do Projeto

# Projeto `<Título do Projeto/Jogo>`

# Descrição Resumida do Projeto/Jogo

> Descreva resumidamente o jogo e seu propósito.

# Equipe
* `<nome completo>` - `<RA>`
* `<nome completo>` - `<RA>`

# Arquivo Executável do Jogo

> Coloque aqui um link para download do arquivo `jar` ou equivalente para execução do seu jogo.

# Slides do Projeto

## Slides da Prévia
> Coloque um link para os slides da prévia do projeto.

## Slides da Apresentação Final
> Coloque um link para os slides da apresentação final do projeto.

# Diagramas

## Diagrama Geral da Arquitetura do Jogo

> Apresente um diagrama geral da arquitetura do jogo. O formato é livre. A escolha de um ou mais estilos arquiteturais será considerado um diferencial.
