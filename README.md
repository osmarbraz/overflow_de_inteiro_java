# Demonstração de Overflow em Tipos Inteiros em Java

## Descrição

Este programa demonstra o fenômeno conhecido como **overflow de inteiro com sinal (*signed integer overflow*)** utilizando os tipos `short`, `int` e `long` da linguagem Java.

O objetivo é mostrar o que acontece quando uma operação aritmética ultrapassa os limites de representação de uma variável inteira. O programa realiza operações de soma e subtração nos limites máximo e mínimo de cada tipo, permitindo observar como os valores passam de um extremo ao outro da faixa representável.

## Objetivos

- Conhecer os limites de representação dos tipos `short`, `int` e `long`.
- Compreender o conceito de overflow.
- Observar o comportamento de uma variável ao ultrapassar o limite máximo ou mínimo.
- Relacionar os resultados à representação de inteiros com sinal em complemento de dois.
- Comparar os diferentes tamanhos de representação dos tipos inteiros em Java.

## Limites dos tipos inteiros

Os tipos inteiros apresentados utilizam quantidades diferentes de bits para armazenar seus valores.

| Tipo | Tamanho | Menor valor | Maior valor |
|---|---:|---:|---:|
| `short` | 16 bits | -32.768 | 32.767 |
| `int` | 32 bits | -2.147.483.648 | 2.147.483.647 |
| `long` | 64 bits | -9.223.372.036.854.775.808 | 9.223.372.036.854.775.807 |

Os limites também podem ser consultados por meio das constantes disponibilizadas pelo Java:

- `Short.MIN_VALUE` e `Short.MAX_VALUE`
- `Integer.MIN_VALUE` e `Integer.MAX_VALUE`
- `Long.MIN_VALUE` e `Long.MAX_VALUE`

## Funcionamento do programa

O programa está organizado em três partes, uma para cada tipo inteiro.

### 1. Overflow do tipo `short`

O programa começa atribuindo o maior valor representável pelo tipo `short` à variável `numeroShort`.

Em seguida, soma `1` ao valor máximo. O resultado ultrapassa o limite positivo e passa para o menor valor negativo representável.

Depois, o programa atribui o menor valor à variável e subtrai `1`, fazendo o resultado passar para o maior valor positivo.

O tipo `short` utiliza 16 bits, e as operações aritméticas com esse tipo são promovidas a `int`. Por isso, o programa utiliza a conversão explícita `(short)` para armazenar novamente o resultado em uma variável `short`.

### 2. Overflow do tipo `int`

O programa utiliza `Integer.MAX_VALUE` para obter o maior valor positivo do tipo `int`.

Ao somar `1`, o resultado passa de `2147483647` para `-2147483648`.

Na operação inversa, ao subtrair `1` do menor valor, o resultado passa de `-2147483648` para `2147483647`.

Como as operações são realizadas diretamente com `int`, não é necessário realizar uma conversão explícita.

### 3. Overflow do tipo `long`

O tipo `long` utiliza 64 bits e possui uma faixa de valores muito maior que a dos tipos `short` e `int`.

O programa demonstra o mesmo comportamento nos limites desse tipo:

- Somar `1` ao maior valor de `long` produz o menor valor negativo.
- Subtrair `1` do menor valor de `long` produz o maior valor positivo.

Esse comportamento ocorre mesmo com números muito grandes, pois o tipo `long` também possui uma quantidade fixa de bits.

## Código-fonte

O arquivo `Principal.java` contém a implementação completa do programa.

## Como executar

É necessário ter o Java Development Kit (JDK) instalado.

**1. Compile o programa:**

```bash
javac Principal.java
```

**2. Execute o programa:**

```bash
java Principal
```

## Saída esperada

```text
OVERFLOW DO TIPO SHORT
Maior short=32767
short + 1=-32768
---------------------------
Menor short=-32768
short - 1=32767

OVERFLOW DO TIPO INT
Maior int=2147483647
int + 1=-2147483648
---------------------------
Menor int=-2147483648
int - 1=2147483647

OVERFLOW DO TIPO LONG
Maior long=9223372036854775807
long + 1=-9223372036854775808
---------------------------
Menor long=-9223372036854775808
long - 1=9223372036854775807
```

## Conceito fundamental: overflow

O overflow ocorre quando o resultado de uma operação ultrapassa a faixa de valores que um tipo numérico consegue representar.

Os tipos `short`, `int` e `long` utilizam representação de inteiros com sinal em complemento de dois. Quando ocorre overflow, o resultado mantém a quantidade fixa de bits do tipo e o padrão binário resultante é interpretado como outro valor inteiro.

Em Java, o overflow desses tipos não gera automaticamente uma exceção. A operação continua e o programa recebe o resultado correspondente à representação de largura fixa.

## Relação com a aritmética modular

O comportamento pode ser compreendido por meio da aritmética modular.

Para um tipo inteiro com sinal de `n` bits, a representação utiliza um total de \(2^n\) padrões binários. Após o maior valor positivo, a sequência de representações passa ao menor valor negativo.

Por exemplo, no tipo `int`, que possui 32 bits:

```text
 2147483647 + 1 = -2147483648
-2147483648 - 1 =  2147483647
```

Esse comportamento decorre da manutenção dos 32 bits do resultado.

## Conclusão

O programa demonstra que os tipos inteiros em Java possuem limites de representação definidos por sua quantidade de bits. Embora `short`, `int` e `long` suportem faixas diferentes de valores, os três apresentam o mesmo princípio de overflow.

Compreender esse fenômeno ajuda a entender como os computadores realizam operações aritméticas com inteiros e por que é necessário considerar os limites dos tipos de dados ao desenvolver programas.