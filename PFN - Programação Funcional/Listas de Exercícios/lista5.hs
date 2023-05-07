import Data.Char
{-- 1. Usando a função filter declare uma lista infinita com os números naturais que são
simultaneamente múltiplos de dois e três --}
multiplos = filter (\x -> x `mod` 3==0) (filter (\x -> x `mod` 2 == 0) [1..]);

{--2. Declare uma função que recebe uma lista de Strings e retorna uma lista de duplas onde, o
primeiro elemento é a String recebida, e e o segundo é o tamanho desta String.
Ex: contaPalavras ["Programacao", "Funcional"] => [("Programacao",11),("Funcional",9)] --}
contaPalavras xs = zip xs (map length xs)

{-- 3. Declare uma função que recebe um número n e retorna pares de valores distintos (x, y), tal
que: 1<=x, y<=n. Utilize filter na construção.
Ex: pares 3 => [(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (3, 2)] --}
pares n = filter (\(x,y) -> x /= y) ([(a,b) | a <- [1..n], b <- [1..n]])

{--4. Declare uma função que recebe uma lista de caracteres, e retorne a mesma lista porém
removendo as letras maiúsculas.
Ex: semMaiusc "Programacao Funcional" => "rogramacao uncional"--}
semMaiusc (xs) = filter (isLower) xs

{--5. Declare uma função que recebe uma lista de listas, e remove toda a ocorrência de lista vazia
desta lista de listas.
Ex: semListasVazias [[1, 2], [], [1, 3]] => [[1,2], [1, 3]]--}
semListasVazias ((xs)) = filter (\xs -> if xs == [] then False else True) xs
{--semListasVazias' ((xs)) = filter (\xs -> xs not null) xs--}

{--6. Declare uma função que recebe uma lista com pares de inteiros e retorna outra lista que
contém a soma de cada par.
Ex: somaPares [(2,3),(1,8)] => [5,9]--}
somaPares (x:xs) = map (\x -> fst x + snd x) (x:xs)

{--7. Declare uma função que recebe uma lista de números inteiros e retorna uma dupla de listas
([a],[b]), onde [a] contempla os elementos ímpares, e [b] os elementos pares.
Ex: separaParImpar [1,2,3,4,5,6,7] => ([1,3,5,7],[2,4,6])--}
separaParImpar (x:xs) = (filter (\x -> x `mod` 2 /= 0) (x:xs),(filter (\x -> x `mod` 2 ==0) (x:xs)))

{--8. Declare uma função com comportamento equivalente a função take da biblioteca prelude
de Haskell, ou seja, deve receber um número inteiro n e uma lista, e retornar os n primeiros
desta lista. Utilize as funções de ordem superior.
Ex: take' 2 [1,2,3,4] => [1,2]--}
take' n xs = map snd (filter (\x -> fst x <= n) (zip [1..] xs))

{--9. Declare uma função, usando foldr, que receba um lista de valores booleanos e retorne a True
se todos elementos da lista forem True, a função deve retornar False caso contrário.--}
allTrue (x:xs) = foldr (&&) True (x:xs)

{--10. Declare uma função que recebe um número inteiro n, e retorna a soma do quadrado dos n
primeiros números. Defina duas versões desta função, uma utilizando map e outra utilizando
fold.
Ex: somaQuadrado 4 = 1^2 + 2^2 + 3^2 + 4^2 => 30--}
somaQuadrado n = foldr (+) 0 (map (\x -> x^2) [a | a <- [1..n]])

{--11. Declare a sua versão da função length disponível na biblioteca de Haskell Prelude, porém
utilizando a função de ordem superior foldr.
Ex: length' "Programacao Funcional" => 21--}
length' (x:xs) = foldr (+) 0 (map (snd) ( map (\x -> (x,1)) (x:xs)))

{--12. Declare uma função que recebe uma lista de inteiros, e retorna o menor número inteiro desta
lista. Defina 2 versões desta implementação, uma utilizando foldr e outra utilizando foldl.
Ex: minlista [2,5,1,8] => 1--}
minlista (x:xs) = foldr (\x y -> if x<y then x else y) x (x:xs)

minlista' (x:xs) = foldl (\x y -> if x<y then x else y) x (x:xs)

{--13. Declare uma função que recebe uma lista de Strings e retorna uma lista de booleanos tal
que, True é o enésimo elemento da lista de inteiros se o enésimo elemento da lista de Strings
tem um número de caracteres par, e False caso seja ímpar.
Ex: paridade ["um","dois","tres","quatro","cinco"] => [True,True,True,True,False]--}
paridade (xs) = map (\x -> if length' x `mod` 2 == 0 then True else False) (xs)

{--14. Declare uma lista infinita de números primos, use o crivo de Eratóstenes.--}
crivo = 2:3:5:7: crivo' [2..]
crivo' n = filter (\x -> if x `mod` 2 == 0 || x `mod` 3 == 0 || x `mod` 5 == 0 || x `mod` 7 == 0 || x `mod` 9 == 0 then False else True) n