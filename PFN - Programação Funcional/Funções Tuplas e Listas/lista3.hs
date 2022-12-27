import Data.Char

{-Lista3 haskell-}

{-1. Declare uma função que verifica se um elemento pertente a uma lista, a função deve retornar
a True se o elemento estiver na lista e False caso contrário.-}
elemento_pertence elemento [] = False
elemento_pertence elemento (x:xs) = if elemento == x then True else elemento_pertence elemento xs

{-2. Declare uma função que retorne a intercessão entre duas listas.-}
intercessao _ [] = []
intercessao[] _ = []
intercessao (x:xs) lista2 | elemento_pertence x lista2 = x:r
                      | otherwise = r
                      where r = intercessao xs lista2


{-3. Declare uma função que retorne o inverso de uma lista.-}
[ ] +++ ys = ys
(x:xs) +++ ys = x:((+++) xs ys)

inverso [] = []
inverso (x:xs) = inverso xs +++ [x]


{-4. Declare uma função que retorne os n últimos elementos de uma lista-}
{-4 Usanado inverso e ultimo take-}
n_primeiros 0 _ = []
n_primeiros _ [] = []
n_primeiros n (x:xs) = x:n_primeiros (n-1) xs

n_ultimos' n (x:xs) =  n_primeiros n (inverso (x:xs))

n_ultimos n (x:xs) = inverso (n_ultimos' n (x:xs)) 

{-5. Declare uma função que receba duas listas de números e crie uma lista com a soma do primeiro elemento da
primeira lista com o primeiro elemento da segunda lista, a soma do segundo elemento da primeira lista com o segundo
elemento da segunda lista e assim sucessivamente até que uma das listas termine.-}
soma [] _ = []
soma _ [] = [] 
soma (x:xs) (y:ys) = x+y:soma (xs) (ys)

{-6. Declare uma função que receba como parâmetro um número n e retorne uma lista com todas
as potências de 2 até 2n.-}
pot2 0 = [1]
pot2 1 = [2]
pot2 n = 2^n:pot2 (n-1)

pot2' 0 = [1]
pot2' 1 = [2]
pot2' n = pot2' (n-1) ++ [2^n]

{-7. Declare uma função que receba duas listas previamente ordenadas e faça a intercalação (merge) dos elementos
tendo como resultado a junção das duas listas em uma lista também ordenada. -}
{-Menor e remover elemento-}
intercalacao [] xs = ordenar xs
intercalacao xs [] = ordenar xs
intercalacao (x:xs) (y:ys) = ordenar ((x:xs) ++ (y:ys))

{-OU / OR
Merge
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys) = if x<y then x:merge xs (y:ys) else (x:xs) ys
-}

{-8. Declare uma função que retorne o menor valor de uma lista.-}
menor_valor [x] = x 
menor_valor (x:xs) = if x < menor_valor (xs) then x else menor_valor (xs)

{-9. Declare uma função que receba uma lista e um elemento e retorne a lista sem a primeira
ocorrência desse elemento-}
tira_numero _ [] = []
tira_numero n (x:xs) = if n /= x then x:tira_numero n (xs) else (xs)

{-10. Usando as declarações anteriores, declare uma função que ordene os elementos de uma lista. -}
ordenar [] = []
ordenar xs = [menor_valor xs] ++ ordenar ( tira_numero (menor_valor xs) xs ) 

{-11. Declare uma função que receba um elemento é uma lista ordenada insira este elemento na lista
colocando-o na posição correta, ou seja, a lista resultante deve estar ordenada. Se o elemento já
pertencer à lista, ele não deve ser incluído. -}
inserir n [] = [n]
inserir n (x:xs) | elemento_pertence n (x:xs) == True = (x:xs)
                 | elemento_pertence n (x:xs) == False = ordenar ([n] ++ (x:xs))

{-12. Declare uma função que receba um número n e uma lista e retorne o n-ésimo elemento da
lista.-}
tamanho [] = 0
tamanho (x:xs) = 1 + tamanho xs 

enesimo' n (x:xs) = if n == 1 then  [x] else enesimo' (n-1) (xs)

enesimo n (x:xs) | n > tamanho (x:xs) = []
                 | n <= tamanho (x:xs) = enesimo' n (x:xs)

{-13. Declare uma função que receba um inteiro n e um elemento e e crie uma lista com n elementos e. -}
repetir 0 _ = []
repetir n e = e:repetir (n-1) e

{-14. Declare uma função que converta um inteiro em um número inteiro em uma String.-}
digito 0 = '0'
digito 1 = '1'
digito 2 = '2'
digito 3 = '3'
digito 4 = '4'
digito 5 = '5'
digito 6 = '6'
digito 7 = '7'
digito 8 = '8'
digito 9 = '9'

intString n = inverso (intString' n)

intString' 0 = []
intString' n = digito(rem n 10):intString' (div n 10)

{-15. Declare uma função que converta uma String contendo uma sequência de dígitos para um inteiro. -}
{-15.Função read-}
string '0' = 0
string '1' = 1
string '2' = 2
string '3' = 3
string '4' = 4
string '5' = 5
string '6' = 6
string '7' = 7
string '8' = 8
string '9' = 9

stringNum'' 0 _ = 0
stringNum'' n (x:xs) = (string (x) *(10^(n-1)))+stringNum'' (n-1) (xs)
stringNum' (x:xs) = stringNum'' (tamanho (x:xs)) (x:xs)
stringNum (x:xs) = stringNum' (x:xs)

{-16. Declare uma função que receba uma String e converta todas letras maiúsculas dessa String em letras minúsculas-}
minusculas [] = []
minusculas (x:xs) = toLower(x):minusculas (xs) 