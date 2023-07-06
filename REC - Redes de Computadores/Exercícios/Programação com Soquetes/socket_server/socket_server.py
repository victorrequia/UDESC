# Modificação do original: Apenas o uso do método strip() para aceitar as mensagens enviadas pelo client java

from random import choice, randint
from socket import *

POSSIBLE_EVENTS = [
    'MONSTER_ATTACK',
    'MONSTER_ATTACK',
    'MONSTER_ATTACK',
    'MONSTER_ATTACK',
    'MONSTER_ATTACK',

    'CHEST',

    'NOTHING',
    'NOTHING',
    'NOTHING',
    'NOTHING',

    'BOSS',
]

class Server:
    def __init__(self) -> None:
        self.score = 0
        self.state_num = 0
        self.health = 100
        self.client = None
        self.connection = None
    
    def send(self, msg):
        msg = str('{};{};{}'.format(msg, self.health, self.score))
        self.client.send(bytes(msg, encoding='utf-8'))

    def receive(self):
        result = self.client.recv(1024)
        if len(result) > 0:
            return result
        else:
            raise Exception()
            

    def handle_monster_attack(self):
        print('Monstro atrás das portas!')
        doors_number = randint(2, 5)
        monster_door = randint(0, doors_number)

        self.send('MONSTER_ATTACK;{}'.format(doors_number))

        position = int(self.receive())

        if position == monster_door:
            self.score += 40
            self.send('MONSTER_KILLED')
        else:
            self.health -= 20
            self.send('MONSTER_ATTACKED')

    def handle_chest(self):
        print('Baú encontrado!')
        chest_value = choice([-20, -20, -10, -10, -50, 5, 5, 5, 10, 10, 50, 50, 100, 50, 10, 5])
        self.send('TAKE_CHEST')
        response = (str(self.receive(), 'utf-8')).strip()
        print(response)
        if response == "`YES`":
            self.score += chest_value
            self.score = max(self.score, 0)
            self.send('CHEST_VALUE;{}'.format(chest_value))
        else:
            self.send('SKIPPING_CHEST')
            
    def handle_nothing(self):
        print('E nada aconteceu...')
        self.send('NOTHING_HAPPENED')

    def handle_boss(self):
        print('Luta com o boss!')
        self.send('BOSS_EVENT')
        action = (str(self.receive(), 'utf-8')).strip()
        if action == "`FIGHT`":
            chances = [100] * (self.health + 40) + [0] * 50
            fight = choice(chances)
            if fight == 100:
                print('Ganhou do boss!')

                self.score += 150
                self.health -= randint(0, 10)
                self.send('BOSS_DEFEATED')
            else:
                print('Perdeu pro Boss')
                self.health -= randint(20, 50)
                self.send('FAILED_BOSS_FIGHT')
        else:
            print('Fugiu da luta')
            self.health -= randint(10, 30)
            self.send('ESCAPED')

    def wait_client(self):
        print("Aguardando conexão...")
        self.health = 100
        self.score = 0
        self.state_num = 0
        self.client, addr = self.connection.accept()
        print("Herói conectado em {}:{}".format(addr[0], addr[1]))

        self.start_play()

    def start_server(self):
        port = 12000
        self.connection = socket(AF_INET, SOCK_STREAM)
        self.connection.bind(('', port))

        self.connection.listen(1)

        self.wait_client()


    def start_play(self):
        try:
            position = self.receive()
            start = str(position, 'utf-8')

            if start != 'START':
                self.connection.close()
                print('Herói não iniciou a partida')
            print('Iniciando jogo...')
            while True:
                event = choice(POSSIBLE_EVENTS)
                if event == 'MONSTER_ATTACK':
                    self.handle_monster_attack()
                elif event == 'CHEST':
                    self.handle_chest()
                elif event == 'BOSS':
                    self.handle_boss()
                else:
                    self.handle_nothing()
                self.receive()

                self.state_num += 1

                if self.health <= 0:
                    self.send('GAME_OVER;{}'.format(self.state_num))
                    self.client.close()
                    self.wait_client()
                elif self.score >= 500 or self.state_num >= 20:
                    self.send('WIN;{}'.format(self.state_num))
                    self.client.close()
                    self.wait_client()
                
        except Exception as e:
            self.client.close()
            self.connection.close()
            print('Heroi saiu...')
            self.wait_client()


if __name__ == '__main__':
   Server().start_server()
