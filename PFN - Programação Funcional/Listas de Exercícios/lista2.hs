{-1. somaPares: escreva uma função que recebe um número e retorne a soma dos números pares entre 0 e ele mesmo-}
numeroPar 0 = 0
numeroPar n = if n `rem` 2 == 0 then n + numeroPar (n-1) else numeroPar (n-1)

{-2 somaQuadrado: escreva uma função que recebe dois parâmetros (m e n) e retorna a seguinte série: 2^1*m + 2^2*m + 2^3*m + ... + 2^n*m.-}
somaQuadrado _ 0 = 0
somaQuadrado m n = m*2^n + somaQuadrado m (n-1)

{-3. fibonacci: escreva uma função que recebe um número inteiro positivo e retorna o n-ésimo elemento da seqüência de Fibonacci.-}
fibonacci_guarda n |n == 0 = 0
                   |n == 1 = 1
                   |True = fibonacci_guarda (n-1) + fibonacci_guarda (n-2)

fibonacci_if n = if n > 1 then fibonacci_if (n-1) + fibonacci_if (n-2) else if n == 1 then 1 else if n == 0 then 0 else -1

fibonacci_casamento 0 = 0
fibonacci_casamento 1 = 1
fibonacci_casamento y = fibonacci_casamento (y-1) + fibonacci_casamento (y-2)

{-4. multiComSoma: escreva uma função que recebe dois números (fatores da multiplicação) e retorna seu produto. A função deve ser escrita utilizando apenas o operador de soma.-}
multiComSoma x y |y == 0 = 0
                 |True = x + multiComSoma x (y-1)

{-5. primo: escreva uma função que recebe um número e retorne True caso ele seja primo e False-}
primo n = if verifica_primo n == 2 then True else False

verifica_primo n = quant_divisores n 1

quant_divisores x y | y == x = 1
                    | True = if x `rem` y == 0 then 1 + quant_divisores x (y+1) else quant_divisores x (y+1)
	
{-Numero perfeito: escreva uma função que receba um número inteiro e retorne True caso ele seja pefeito e false do contrário-}
numPerfeito n | numPerfeito' n (n-1) == n = True
              | otherwise = False

numPerfeito' _ 1 = 1
numPerfeito' num controle | num `rem` controle == 0 = controle + numPerfeito' num (controle-1)
                          | otherwise = numPerfeito' num (controle-1)
