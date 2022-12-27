import System.IO
import Data.Char
import Data.List

{-Funcoes Primarias-}
numLines lines = zip [1..] lines

allNumWords (x:xs) = map (\x ->  map (\y -> (fst x,y)) (words(snd x))) (x:xs)

sortLs (x:xs) = inverteTupla (sortBy compare (inverteTupla(x:xs)))

almalgamate [] = []
almalgamate (x:xs) = removePalavrasIguais ((filtraPalavraIgual (snd x) (x:xs), (snd x)): almalgamate (xs))

shorten [] = []
shorten (x:xs) = (x:shorten (filter (/=x) (xs)))

imprime [] = []
imprime (x:xs) = "A palavra " ++ (snd x) ++ " aparece " ++ show(length(fst x)) ++ " vezes na(s) linha(s) " ++ imprimeWithShorten (fst x) ++ "\n" ++ imprime (xs)

{-Funções Secundarias-}
inverteTupla (x:xs) = map (\x -> (snd x, fst x)) (x:xs)

concatena xs = foldr (++) [] xs

filtraPalavraIgual palavra (x:xs) = filter (\x -> x /= -1) (map (\x -> if (snd x) `compare` palavra == EQ then (fst x) else (-1)) (x:xs))

removePalavrasIguais [] = []
removePalavrasIguais (x:xs) = removePalavrasIguais' (snd x) (x:xs)
removePalavrasIguais' palavra (x:xs) = x:filter (\x -> if (snd x) `compare` palavra == EQ then False else True) (xs)

imprimeWithShorten (x:xs) = show (shorten(x:xs))

{-Função main-}
main = do 
        texto <- readFile "testehsk.txt"
        let tratarFuncao = filter (\x -> if isPunctuation (x) == True then False else True) texto
        let funcao =  almalgamate $ sortLs $ concatena $ allNumWords $ numLines (lines (tratarFuncao))
        putStrLn (imprime (funcao))
