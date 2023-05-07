   
class Graph(): 
   
    def __init__(self, nvertices): 
        self.N = nvertices 
        self.graph = [[0 for column in range(nvertices)]  
                    for row in range(nvertices)] 
        self.V = ['0' for column in range(nvertices)]

    def nameVertex(self):
        for i in range(self.N):
            print("Qual o rotúlo do vértice %i?"%(i))
            self.V[i]=input()

    def setEdge(self,u,v,w):
        self.graph[u][v]=w
        self.graph[v][u]=w

    def loadEdges(self):
        for i in range(self.N):
            for j in range(self.N):
                if i>j:
                    print("Qual o peso entre %c e %c?"%
                          (self.V[i],self.V[j]))
                    self.setEdge(i,j,input())
        
        

   
print('Qual o número de vértices?')
n = int(input())
g = Graph(n)
g1 = Graph(n-1)
print(g.graph)
g.nameVertex()
g.loadEdges()
print(g.graph)


