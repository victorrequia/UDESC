import Data.Char

{-2. Definir uma função que recebe duas strings como parâmetro, e remove da segunda lista as letras que
ocorrerem na primeira lista.
Ex: "Programacao" "Funcional" => "Funinl"-}
removeLetras _ [] = []
removeLetras (x:xs) (y:ys) = removeLetraDaLista x (y:ys) : removeLetras (xs) (ys)
removeLetraDaLista _ [] = []
removeLetraDaLista letra (x:xs) = filter (\x -> if x == letra then False else True) (x:xs)


{-3. Definir uma função que recebe uma string, e retorna uma lista de todos as substrings possíveis que
formam um prefixo da string.
Ex: "fim" => ["fim","fi","f"]-}
substrings [] = []
substrings (y:ys) = (y:ys) : take (length(substrings' (inverteLista(y:ys)))-1) (substrings' (inverteLista(y:ys)))
substrings' [] = []
substrings' (y:ys) = removeLetraDaLista y (inverteLista(y:ys)) : substrings' ys


{-4. Definir uma função que recebe uma lista e um número inteiro, que indica o número de trocas de
posições. Uma troca envolve capturar o primeiro elemento da lista e adicioná-lo ao fim da lista.
Ex: [1,2,3,4,5] 2 => [3,4,5,1,2]-}
trocaNumeros n (x:xs) = inverteLista(trocaNumeros' n (inverteLista((x:xs)++take n (x:xs))))
trocaNumeros' n (xs) = take (length(xs)-n) xs


{-5. Definir uma função que recebe uma lista de duplas, e retorne uma lista os elementos reposicionados.
Reposicionar a lista envolve capturar o segundo elemento da cabeça da lista e o primeiro elemento
da dupla seguinte, enquanto seja possível.-}
reposicionamento (x:xs) = if length(x:xs) > 1 then (snd x, reposicionamento' xs): reposicionamento (xs) else []
reposicionamento' (x:xs) = fst x


{-6. Definir a função zip3, que recebe 3 listas [a] -> [b] -> [c], e retorna uma lista de tuplas de tamanho 3
[(a,b,c)].
Ex: zip3 [1,2,3] ['a','b'] [True, False] => [(1,'a',True),(2,'b',False)]-}
zipars _ _ [] = []
zipars _ [] _ = []
zipars [] _ _ = []
zipars (a:ax) (b:bx) (c:cx) = (a,b,c) : zipars (ax) (bx) (cx)


{-7. Definir uma função que recebe uma String, avalie cada letra e retorne True caso seja vogal, e False
caso contrário. Devem ser removidos os espaços em branco antes. Utilizar função de ordem superior
na implementação.
Ex: ehVogal "Fim da Aula" => [False,True,False,False,True,True,True,False,True]-}
ehVogal (x:xs) = map (\x -> isVogal x) (removeEspacos(paraMinuscula(x:xs)))

paraMinuscula [] = []
paraMinuscula (x:xs) = toLower x:paraMinuscula (xs)

removeEspacos (x:xs) = filter (\x -> if isSpace x == True then False else True) (x:xs)

isVogal letra | letra == 'a' = True
              | letra == 'e' = True
              | letra == 'i' = True
              | letra == 'o' = True
              | letra == 'u' = True
              | otherwise = False


{-8. Definir uma função que recebe uma lista de strings, e inverta cada elemento da lista, e então inverta
a lista resultante. Não deve ser utiliza a função reverse do Prelude.
Ex: inversoExtInt ["Fim","da","Aula"] => ["aluA","ad","miF"]-}
inversoExtInt (a:b) = inverteLista (inverteLista a:inverteLista b)
inverteLista [] = []
inverteLista (x:xs) = inverteLista (xs) ++ [x]




