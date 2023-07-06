package com.example.otes06.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public String userRanking = """
                        [
                {
                    "name": "Flavinho do Pneu",
                    "score": 5098
                },
                {
                    "name": "Shaolin Matador de Porco",
                    "score": 4670
                },
                {
                    "name": "Ja Lin Habei",
                    "score": 4510
                },
                {
                    "name": "Tambem num sei",
                    "score": 1230
                },
                {
                    "name": "Num sei de nada",
                    "score": 1056
                },
                {
                    "name": "Pra q nome",
                    "score": 1034
                },
                {
                    "name": "Valdir Sanguinário",
                    "score": 1012
                },
                {
                    "name": "Comi o debaixo",
                    "score": 109
                },
                {
                    "name": "Comi o de cima",
                    "score": 105
                },
                {
                    "name": "asdadsfaASs",
                    "score": 31
                }
            ]
                        """;
    public String questions = """
                    [
                {
                    "id": 1,
                    "question_text": "Qual é a função principal de um sistema operacional?",
                    "difficult": 1
                },
                {
                    "id": 2,
                    "question_text": "O que é um navegador de internet?",
                    "difficult": 1
                },
                {
                    "id": 3,
                    "question_text": "O que é um firewall?",
                    "difficult": 1
                },
                {
                    "id": 4,
                    "question_text": "O que é um backup de dados?",
                    "difficult": 1
                },
                {
                    "id": 5,
                    "question_text": "O que é a computação em nuvem?",
                    "difficult": 1
                },
                {
                    "id": 6,
                    "question_text": "O que é um banco de dados relacional?",
                    "difficult": 1
                },
                {
                    "id": 7,
                    "question_text": "O que é um algoritmo?",
                    "difficult": 1
                },
                {
                    "id": 8,
                    "question_text": "O que é a inteligência artificial?",
                    "difficult": 1
                },
                {
                    "id": 9,
                    "question_text": "O que é um hacker?",
                    "difficult": 1
                },
                {
                    "id": 10,
                    "question_text": "O que é um sistema de gerenciamento de banco de dados (SGBD)?",
                    "difficult": 1
                },
                {
                    "id": 11,
                    "question_text": "O que é um servidor web?",
                    "difficult": 3
                },
                {
                    "id": 12,
                    "question_text": "O que é um banco de dados relacional?",
                    "difficult": 3
                },
                {
                    "id": 13,
                    "question_text": "O que é criptografia de dados?",
                    "difficult": 3
                },
                {
                    "id": 14,
                    "question_text": "O que é um sistema operacional?",
                    "difficult": 3
                },
                {
                    "id": 15,
                    "question_text": "O que é programação orientada a objetos?",
                    "difficult": 3
                },
                {
                    "id": 16,
                    "question_text": "O que é cloud computing?",
                    "difficult": 3
                },
                {
                    "id": 17,
                    "question_text": "O que é um algoritmo?",
                    "difficult": 3
                },
                {
                    "id": 18,
                    "question_text": "O que é inteligência artificial?",
                    "difficult": 3
                },
                {
                    "id": 19,
                    "question_text": "O que é virtualização?",
                    "difficult": 3
                },
                {
                    "id": 20,
                    "question_text": "O que é big data?",
                    "difficult": 3
                },
                {
                    "id": 21,
                    "question_text": "Qual é o protocolo de criptografia usado para garantir a segurança das transações online?",
                    "difficult": 5
                },
                {
                    "id": 22,
                    "question_text": "O que é SQL Injection?",
                    "difficult": 5
                },
                {
                    "id": 23,
                    "question_text": "O que é uma rede VPN?",
                    "difficult": 5
                },
                {
                    "id": 24,
                    "question_text": "O que é o protocolo IPv6?",
                    "difficult": 5
                },
                {
                    "id": 25,
                    "question_text": "O que é um ataque de força bruta?",
                    "difficult": 5
                },
                {
                    "id": 26,
                    "question_text": "O que é um algoritmo de criptografia assimétrica?",
                    "difficult": 5
                },
                {
                    "id": 27,
                    "question_text": "O que é um sistema operacional de código aberto?",
                    "difficult": 5
                },
                {
                    "id": 28,
                    "question_text": "O que é um ataque de negação de serviço (DDoS)?",
                    "difficult": 5
                },
                {
                    "id": 29,
                    "question_text": "O que é a computação em nuvem?",
                    "difficult": 5
                },
                {
                    "id": 30,
                    "question_text": "O que é a Internet das Coisas (IoT)?",
                    "difficult": 5
                }
            ]""";

    public String answers = """
                    [
            {
                "id": 1,
                "question_id": 1,
                "correct_answer": false,
                "answer_text": "Gerenciar a conexão de internet"
            },
            {
                "id": 2,
                "question_id": 1,
                "correct_answer": false,
                "answer_text": "Executar programas de edição de texto"
            },
            {
                "id": 3,
                "question_id": 1,
                "correct_answer": true,
                "answer_text": "Controlar o hardware e os recursos do computador"
            },
            {
                "id": 4,
                "question_id": 1,
                "correct_answer": false,
                "answer_text": "Fornecer energia para o computador"
            },
            {
                "id": 5,
                "question_id": 1,
                "correct_answer": false,
                "answer_text": "Aquecer o processador"
            },
            {
                "id": 6,
                "question_id": 2,
                "correct_answer": false,
                "answer_text": "Um dispositivo de armazenamento externo"
            },
            {
                "id": 7,
                "question_id": 2,
                "correct_answer": false,
                "answer_text": "Um programa para reproduzir músicas"
            },
            {
                "id": 8,
                "question_id": 2,
                "correct_answer": false,
                "answer_text": "Um software de edição de imagens"
            },
            {
                "id": 9,
                "question_id": 2,
                "correct_answer": true,
                "answer_text": "Um programa para acessar páginas da web"
            },
            {
                "id": 10,
                "question_id": 2,
                "correct_answer": false,
                "answer_text": "Um sistema operacional para dispositivos móveis"
            },
            {
                "id": 11,
                "question_id": 3,
                "correct_answer": false,
                "answer_text": "Um dispositivo para impressão de documentos"
            },
            {
                "id": 12,
                "question_id": 3,
                "correct_answer": false,
                "answer_text": "Um programa para criar apresentações de slides"
            },
            {
                "id": 13,
                "question_id": 3,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 14,
                "question_id": 3,
                "correct_answer": true,
                "answer_text": "Um mecanismo de segurança para proteger redes"
            },
            {
                "id": 15,
                "question_id": 3,
                "correct_answer": false,
                "answer_text": "Uma ferramenta para backup de arquivos"
            },
            {
                "id": 16,
                "question_id": 4,
                "correct_answer": false,
                "answer_text": "Um tipo de arquivo compactado"
            },
            {
                "id": 17,
                "question_id": 4,
                "correct_answer": true,
                "answer_text": "Uma cópia de segurança dos dados para proteção"
            },
            {
                "id": 18,
                "question_id": 4,
                "correct_answer": false,
                "answer_text": "Um formato de vídeo de alta resolução"
            },
            {
                "id": 19,
                "question_id": 4,
                "correct_answer": false,
                "answer_text": "Uma tecnologia para conexão de dispositivos sem fio"
            },
            {
                "id": 20,
                "question_id": 4,
                "correct_answer": false,
                "answer_text": "Um dispositivo de armazenamento externo"
            },
            {
                "id": 21,
                "question_id": 5,
                "correct_answer": false,
                "answer_text": "Um tipo de impressora portátil"
            },
            {
                "id": 22,
                "question_id": 5,
                "correct_answer": false,
                "answer_text": "Um software para edição de vídeos"
            },
            {
                "id": 23,
                "question_id": 5,
                "correct_answer": false,
                "answer_text": "Uma rede de computadores interligados"
            },
            {
                "id": 24,
                "question_id": 5,
                "correct_answer": true,
                "answer_text": "Uma tecnologia para armazenamento e processamento de dados na internet"
            },
            {
                "id": 25,
                "question_id": 5,
                "correct_answer": false,
                "answer_text": "Um sistema operacional para dispositivos móveis"
            },
            {
                "id": 26,
                "question_id": 6,
                "correct_answer": false,
                "answer_text": "Um software para edição de imagens"
            },
            {
                "id": 27,
                "question_id": 6,
                "correct_answer": false,
                "answer_text": "Um dispositivo para reprodução de áudio"
            },
            {
                "id": 28,
                "question_id": 6,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 29,
                "question_id": 6,
                "correct_answer": true,
                "answer_text": "Um sistema para armazenar e gerenciar dados relacionados em tabelas"
            },
            {
                "id": 30,
                "question_id": 6,
                "correct_answer": false,
                "answer_text": "Um tipo de dispositivo de entrada"
            },
            {
                "id": 31,
                "question_id": 7,
                "correct_answer": false,
                "answer_text": "Um tipo de software malicioso"
            },
            {
                "id": 32,
                "question_id": 7,
                "correct_answer": false,
                "answer_text": "Um dispositivo para fazer ligações telefônicas"
            },
            {
                "id": 33,
                "question_id": 7,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação"
            },
            {
                "id": 34,
                "question_id": 7,
                "correct_answer": true,
                "answer_text": "Um conjunto de instruções para resolver um problema"
            },
            {
                "id": 35,
                "question_id": 7,
                "correct_answer": false,
                "answer_text": "Um formato de arquivo de texto"
            },
            {
                "id": 36,
                "question_id": 8,
                "correct_answer": false,
                "answer_text": "Um tipo de processador de alta velocidade"
            },
            {
                "id": 37,
                "question_id": 8,
                "correct_answer": false,
                "answer_text": "Um software para criar gráficos em 3D"
            },
            {
                "id": 38,
                "question_id": 8,
                "correct_answer": true,
                "answer_text": "Uma área da ciência da computação que busca desenvolver máquinas capazes de realizar tarefas que exigem inteligência humana"
            },
            {
                "id": 39,
                "question_id": 8,
                "correct_answer": false,
                "answer_text": "Um tipo de conexão de internet de alta velocidade"
            },
            {
                "id": 40,
                "question_id": 8,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação orientada a objetos"
            },
            {
                "id": 41,
                "question_id": 9,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 42,
                "question_id": 9,
                "correct_answer": false,
                "answer_text": "Um dispositivo de armazenamento externo"
            },
            {
                "id": 43,
                "question_id": 9,
                "correct_answer": true,
                "answer_text": "Uma pessoa que possui habilidades avançadas em computação e utiliza seus conhecimentos para descobrir falhas em sistemas de segurança"
            },
            {
                "id": 44,
                "question_id": 9,
                "correct_answer": false,
                "answer_text": "Um tipo de software para monitoramento de redes"
            },
            {
                "id": 45,
                "question_id": 9,
                "correct_answer": false,
                "answer_text": "Um programa para recuperação de dados perdidos"
            },
            {
                "id": 46,
                "question_id": 10,
                "correct_answer": false,
                "answer_text": "Um programa para edição de vídeos"
            },
            {
                "id": 47,
                "question_id": 10,
                "correct_answer": false,
                "answer_text": "Um dispositivo para armazenar arquivos"
            },
            {
                "id": 48,
                "question_id": 10,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 49,
                "question_id": 10,
                "correct_answer": false,
                "answer_text": "Um sistema para controlar a temperatura do computador"
            },
            {
                "id": 50,
                "question_id": 10,
                "correct_answer": true,
                "answer_text": "Um software para armazenar, gerenciar e recuperar informações em um banco de dados"
            },
            {
                "id": 51,
                "question_id": 11,
                "correct_answer": true,
                "answer_text": "Um servidor responsável por processar solicitações e fornecer páginas web aos clientes"
            },
            {
                "id": 52,
                "question_id": 11,
                "correct_answer": false,
                "answer_text": "Um software para gerenciar e-mails"
            },
            {
                "id": 53,
                "question_id": 11,
                "correct_answer": false,
                "answer_text": "Um dispositivo utilizado para armazenar arquivos"
            },
            {
                "id": 54,
                "question_id": 11,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 55,
                "question_id": 11,
                "correct_answer": false,
                "answer_text": "Um programa para criar animações em 3D"
            },
            {
                "id": 56,
                "question_id": 12,
                "correct_answer": true,
                "answer_text": "Um tipo de banco de dados que organiza os dados em tabelas relacionadas"
            },
            {
                "id": 57,
                "question_id": 12,
                "correct_answer": false,
                "answer_text": "Um software para desenho gráfico"
            },
            {
                "id": 58,
                "question_id": 12,
                "correct_answer": false,
                "answer_text": "Um dispositivo para armazenar arquivos em nuvem"
            },
            {
                "id": 59,
                "question_id": 12,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação orientada a objetos"
            },
            {
                "id": 60,
                "question_id": 12,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 61,
                "question_id": 13,
                "correct_answer": true,
                "answer_text": "Um conjunto de técnicas para tornar os dados ininteligíveis para pessoas não autorizadas"
            },
            {
                "id": 62,
                "question_id": 13,
                "correct_answer": false,
                "answer_text": "Um software para criar modelos 3D"
            },
            {
                "id": 63,
                "question_id": 13,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 64,
                "question_id": 13,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação utilizada para criptografar dados"
            },
            {
                "id": 65,
                "question_id": 13,
                "correct_answer": false,
                "answer_text": "Um dispositivo de armazenamento externo"
            },
            {
                "id": 66,
                "question_id": 14,
                "correct_answer": true,
                "answer_text": "Um software responsável por gerenciar recursos e fornecer uma interface entre o usuário e o hardware"
            },
            {
                "id": 67,
                "question_id": 14,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 68,
                "question_id": 14,
                "correct_answer": false,
                "answer_text": "Um dispositivo para fazer ligações telefônicas"
            },
            {
                "id": 69,
                "question_id": 14,
                "correct_answer": false,
                "answer_text": "Um programa para edição de vídeos"
            },
            {
                "id": 70,
                "question_id": 14,
                "correct_answer": false,
                "answer_text": "Um tipo de software malicioso"
            },
            {
                "id": 71,
                "question_id": 15,
                "correct_answer": true,
                "answer_text": "Um paradigma de programação que utiliza objetos como unidades fundamentais"
            },
            {
                "id": 72,
                "question_id": 15,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 73,
                "question_id": 15,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação para cálculos matemáticos"
            },
            {
                "id": 74,
                "question_id": 15,
                "correct_answer": false,
                "answer_text": "Um dispositivo de armazenamento externo"
            },
            {
                "id": 75,
                "question_id": 15,
                "correct_answer": false,
                "answer_text": "Um programa para criar gráficos e imagens"
            },
            {
                "id": 76,
                "question_id": 16,
                "correct_answer": true,
                "answer_text": "Um modelo de computação que permite acessar recursos e serviços pela internet"
            },
            {
                "id": 77,
                "question_id": 16,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 78,
                "question_id": 16,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação para automação de processos"
            },
            {
                "id": 79,
                "question_id": 16,
                "correct_answer": false,
                "answer_text": "Um dispositivo de armazenamento externo"
            },
            {
                "id": 80,
                "question_id": 16,
                "correct_answer": false,
                "answer_text": "Um programa para fazer backup de arquivos"
            },
            {
                "id": 81,
                "question_id": 17,
                "correct_answer": true,
                "answer_text": "Um conjunto de instruções sequenciais para resolver um problema específico"
            },
            {
                "id": 82,
                "question_id": 17,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 83,
                "question_id": 17,
                "correct_answer": false,
                "answer_text": "Um dispositivo utilizado para capturar imagens"
            },
            {
                "id": 84,
                "question_id": 17,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação para design gráfico"
            },
            {
                "id": 85,
                "question_id": 17,
                "correct_answer": false,
                "answer_text": "Um programa para criar animações em 2D"
            },
            {
                "id": 86,
                "question_id": 18,
                "correct_answer": true,
                "answer_text": "Um campo de estudo que desenvolve sistemas capazes de realizar tarefas que normalmente exigem inteligência humana"
            },
            {
                "id": 87,
                "question_id": 18,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 88,
                "question_id": 18,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação para análise estatística"
            },
            {
                "id": 89,
                "question_id": 18,
                "correct_answer": false,
                "answer_text": "Um dispositivo de armazenamento externo"
            },
            {
                "id": 90,
                "question_id": 18,
                "correct_answer": false,
                "answer_text": "Um programa para criar gráficos e imagens"
            },
            {
                "id": 91,
                "question_id": 19,
                "correct_answer": true,
                "answer_text": "A criação de uma versão virtual de um recurso de hardware ou software"
            },
            {
                "id": 92,
                "question_id": 19,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 93,
                "question_id": 19,
                "correct_answer": false,
                "answer_text": "Um software para monitorar a temperatura do computador"
            },
            {
                "id": 94,
                "question_id": 19,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação para desenvolvimento web"
            },
            {
                "id": 95,
                "question_id": 19,
                "correct_answer": false,
                "answer_text": "Um dispositivo utilizado para armazenar arquivos"
            },
            {
                "id": 96,
                "question_id": 20,
                "correct_answer": true,
                "answer_text": "Uma tecnologia que permite a transmissão de dados sem fio entre dispositivos"
            },
            {
                "id": 97,
                "question_id": 20,
                "correct_answer": false,
                "answer_text": "Um tipo de vírus de computador"
            },
            {
                "id": 98,
                "question_id": 20,
                "correct_answer": false,
                "answer_text": "Um dispositivo utilizado para armazenar arquivos"
            },
            {
                "id": 99,
                "question_id": 20,
                "correct_answer": false,
                "answer_text": "Uma linguagem de programação para desenvolvimento de jogos"
            },
            {
                "id": 100,
                "question_id": 20,
                "correct_answer": false,
                "answer_text": "Um programa para criar animações em 3D"
            },
            {
                "id": 101,
                "question_id": 21,
                "correct_answer": true,
                "answer_text": "TLS"
            },
            {
                "id": 102,
                "question_id": 21,
                "correct_answer": false,
                "answer_text": "FTP"
            },
            {
                "id": 103,
                "question_id": 21,
                "correct_answer": false,
                "answer_text": "HTTP"
            },
            {
                "id": 104,
                "question_id": 21,
                "correct_answer": false,
                "answer_text": "POP3"
            },
            {
                "id": 105,
                "question_id": 21,
                "correct_answer": false,
                "answer_text": "SMTP"
            },
            {
                "id": 106,
                "question_id": 22,
                "correct_answer": false,
                "answer_text": "Um tipo de linguagem de programação"
            },
            {
                "id": 107,
                "question_id": 22,
                "correct_answer": true,
                "answer_text": "Uma técnica que permite a inserção de comandos SQL maliciosos em uma aplicação"
            },
            {
                "id": 108,
                "question_id": 22,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque de negação de serviço"
            },
            {
                "id": 109,
                "question_id": 22,
                "correct_answer": false,
                "answer_text": "Um protocolo de comunicação seguro"
            },
            {
                "id": 110,
                "question_id": 22,
                "correct_answer": false,
                "answer_text": "Uma técnica de criptografia de dados"
            },
            {
                "id": 111,
                "question_id": 23,
                "correct_answer": false,
                "answer_text": "Uma técnica para acessar uma rede privada por meio de uma conexão segura"
            },
            {
                "id": 112,
                "question_id": 23,
                "correct_answer": true,
                "answer_text": "Virtual Private Network"
            },
            {
                "id": 113,
                "question_id": 23,
                "correct_answer": false,
                "answer_text": "Um tipo de firewall"
            },
            {
                "id": 114,
                "question_id": 23,
                "correct_answer": false,
                "answer_text": "Um protocolo de roteamento"
            },
            {
                "id": 115,
                "question_id": 23,
                "correct_answer": false,
                "answer_text": "Um software antivírus"
            },
            {
                "id": 116,
                "question_id": 24,
                "correct_answer": false,
                "answer_text": "A versão 4 do protocolo IP"
            },
            {
                "id": 117,
                "question_id": 24,
                "correct_answer": true,
                "answer_text": "A versão 6 do protocolo IP"
            },
            {
                "id": 118,
                "question_id": 24,
                "correct_answer": false,
                "answer_text": "O endereço IP padrão de um roteador"
            },
            {
                "id": 119,
                "question_id": 24,
                "correct_answer": false,
                "answer_text": "Um protocolo de criptografia de dados"
            },
            {
                "id": 120,
                "question_id": 24,
                "correct_answer": false,
                "answer_text": "Uma técnica de balanceamento de carga"
            },
            {
                "id": 121,
                "question_id": 25,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque de phishing"
            },
            {
                "id": 122,
                "question_id": 25,
                "correct_answer": true,
                "answer_text": "Um tipo de ataque que tenta adivinhar uma senha testando várias combinações"
            },
            {
                "id": 123,
                "question_id": 25,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque de negação de serviço"
            },
            {
                "id": 124,
                "question_id": 25,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que se aproveita de vulnerabilidades de software"
            },
            {
                "id": 125,
                "question_id": 25,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que usa redes zumbis"
            },
            {
                "id": 126,
                "question_id": 26,
                "correct_answer": false,
                "answer_text": "Um algoritmo de criptografia simétrica"
            },
            {
                "id": 127,
                "question_id": 26,
                "correct_answer": true,
                "answer_text": "Um algoritmo de criptografia que utiliza chaves públicas e privadas"
            },
            {
                "id": 128,
                "question_id": 26,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque de negação de serviço"
            },
            {
                "id": 129,
                "question_id": 26,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque de phishing"
            },
            {
                "id": 130,
                "question_id": 26,
                "correct_answer": false,
                "answer_text": "Um protocolo de comunicação seguro"
            },
            {
                "id": 131,
                "question_id": 27,
                "correct_answer": true,
                "answer_text": "Um sistema operacional cujo código-fonte é aberto e pode ser modificado"
            },
            {
                "id": 132,
                "question_id": 27,
                "correct_answer": false,
                "answer_text": "Um sistema operacional desenvolvido pela Microsoft"
            },
            {
                "id": 133,
                "question_id": 27,
                "correct_answer": false,
                "answer_text": "Um sistema operacional voltado para servidores"
            },
            {
                "id": 134,
                "question_id": 27,
                "correct_answer": false,
                "answer_text": "Um sistema operacional baseado em nuvem"
            },
            {
                "id": 135,
                "question_id": 27,
                "correct_answer": false,
                "answer_text": "Um sistema operacional que não requer licença para uso"
            },
            {
                "id": 136,
                "question_id": 28,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque de phishing"
            },
            {
                "id": 137,
                "question_id": 28,
                "correct_answer": true,
                "answer_text": "Um tipo de ataque que visa sobrecarregar um servidor ou rede para torná-los inacessíveis"
            },
            {
                "id": 138,
                "question_id": 28,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que se aproveita de vulnerabilidades de software"
            },
            {
                "id": 139,
                "question_id": 28,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que tenta adivinhar senhas por meio de força bruta"
            },
            {
                "id": 140,
                "question_id": 28,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que usa redes zumbis"
            },
            {
                "id": 141,
                "question_id": 29,
                "correct_answer": true,
                "answer_text": "Um modelo de fornecimento de serviços de computação por meio da Internet"
            },
            {
                "id": 142,
                "question_id": 29,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que visa obter acesso a informações confidenciais"
            },
            {
                "id": 143,
                "question_id": 29,
                "correct_answer": false,
                "answer_text": "Um protocolo de comunicação seguro"
            },
            {
                "id": 144,
                "question_id": 29,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que visa interromper ou degradar um serviço de rede"
            },
            {
                "id": 145,
                "question_id": 29,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que se aproveita de vulnerabilidades de software"
            },
            {
                "id": 146,
                "question_id": 30,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que visa obter acesso a informações confidenciais"
            },
            {
                "id": 148,
                "question_id": 30,
                "correct_answer": false,
                "answer_text": "Um protocolo de criptografia de dados"
            },
            {
                "id": 149,
                "question_id": 30,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque que se aproveita de vulnerabilidades de software"
            },
            {
                "id": 150,
                "question_id": 30,
                "correct_answer": false,
                "answer_text": "Um tipo de ataque de negação de serviço"
            },
            {
                "id": 147,
                "question_id": 30,
                "correct_answer": true,
                "answer_text": "Um conceito que se refere à conexão de objetos físicos à internet"
            }
            ]""";
}