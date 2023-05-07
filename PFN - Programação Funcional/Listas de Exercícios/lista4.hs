import Data.Char

{-1. Declare uma função que receba uma lista de duplas [(a,b)], e retorne uma lista com o primeiro elemento de cada dupla [a]-}
primeiros [] = []
primeiros (x:xs) = fst x : primeiros xs

primeiros' [] = []
primeiros' ((a,_):xs) = a : primeiros' xs

primeiros'' [] = []
primeiros'' xs = fst (head xs) : primeiros'' (tail xs)

primeiros''' xs = [a | (a,b) <- xs]

{-2. Declare uma função que receba uma lista de duplas e retorne uma lista com a soma dos elementos de cada dupla-}
somarDuplas :: [(Int,Int)] -> [Int]
somarDuplas [] = []
somarDuplas (x:xs) = fst x + snd x : somarDuplas xs

somarDuplas' xs = [a + b| (a,b) <- xs]
{-3. Declare uma função que receba uma lista e retorna uma dupla com o maior e o menor elemento da lista-}
maiorMenor (x:xs) = [maximum (x:xs), minimum (x:xs)]

{-4. Declare uma função que receba um elemento e e uma lista de duplas, a função deve procurar a primeira dupla cujo primeiro 
elemento da dupla seja igual ao parâmetro e. A função deve retornar o segundo elemento dessa dupla-}
procurar _ [] = ""
procurar n (x:xs) | fst x == n = snd x
                  | otherwise = procurar n xs 

procurar' n xs = head [snd x | x <- xs, fst x == n]

{-5. Declare uma função que recebe uma lista de duplas e retorna uma lista contendo todas as duplas cujo primeiro elemento seja menor que o segundo-}
menores [] = []
menores (x:xs) = if fst x< snd x then x: menores(xs) else menores (xs)

{-6. Declare uma função que receba como parâmetro uma String e retorne uma dupla de Strings, a primeira String deve
conter as letras maiúsculas e a segunda as letras minúsculas. Os caracteres que não forem letras devem ser ignorados-}
minusc [] = []
minusc (x:xs) = if isLower x == True then x:minusc xs else minusc xs

maiusc [] = []
maiusc (x:xs) = if isUpper x == True then x:maiusc xs else maiusc xs

maiuscMinusc :: [Char] -> ([Char],[Char])
maiuscMinusc l@(x:xs) = (maiusc l, minusc l)

maiuscMinusc' xs = ([a | a <- xs, isUpper a],[b | b <- xs, isLower b])

{-7. Declare uma função que receba um valor v e uma lista, a função deve retornar uma dupla de listas, a primeira lista deve conter os 
elementos que são menores ou iguais a v e a segunda lista deve retornar os elementos maiores que v-}
separar v (x:xs) = [separar_menores v (x:xs), separar_maiores v (x:xs)]
separar_menores _ [] = []
separar_menores v (x:xs) = if v >= x then x: separar_menores v (xs) else separar_menores v (xs)
separar_maiores _ [] = []
separar_maiores v (x:xs) = if v < x then x: separar_maiores v (xs) else separar_maiores v (xs)

separar' n xs = ([y | y <- xs, y <= n],[y | y <- xs, y >= n])
{-8. Implemente o Algoritmo de Euclides Estendido-}
inverte (x,y,z) = (y,x,z)

eMDC a 0 = (1,0,a)
eMDC a b = (y,x-(div a b)*y,d)
 where 
   (x,y,d) = eMDC b (mod a b)
   
euclides a b = if a < 0 || b < 0 then error "parâmetros devem ser positivos" else if a > b then eMDC a b else inverte (eMDC b a)

{-9. Declare uma função que receba uma lista de duplas [(x,y)], e retorne uma lista com o inverso de cada dupla, ou seja [(y,x)]-}
inverso [] = []
inverso (x:xs) = [(snd x , fst x)] ++ inverso (xs)

{-10. Declare uma função que receba uma lista de duplas, e retorne lista indicando se os elementos são iguais ou não (True/False)-}
simetrico [] = []
simetrico (x:xs) = if fst x == snd x then True : simetrico (xs) else False : simetrico (xs)

{-11. Declare uma função que recebe 2 listas de duplas [(a,b)] e [(c,d)], e retorna a composição da primeira com a segunda lista, na forma 
[(a,d)], onde a é o primeiro elemento da primeira lista, e c é o segundo elemento da segunda lista.-}
comporDuplas [] _ = []
comporDuplas _ [] = []
comporDuplas ((x1,_):xs) ((_,y2):ys) = (x1,y2) : comporDuplas xs ys

comporDuplas' [] _ = []
comporDuplas' _ [] = []
comporDuplas' (x:xs) (y:ys) = (fst x, snd y) : comporDuplas' xs ys

{-12. Declare uma função que recebe um número inteiro, e retorna uma lista de duplas de inteiros distintos (x,y) tal que 1 ≤ x, y ≤ i-}
pares n = [(a,b) | a <- [1..n], b <- [1..n], a /= b]
