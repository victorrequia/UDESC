const items = [
    {
        id: 0,
        nome: 'Bolo de pote',
        preco: '7,50',
        img: 'images/produtos/bolo_pote.jpg',
        quantidade: 0
    },
    {
        id: 1,
        nome: 'Bolo de morango',
        preco: '7,50',
        img: 'images/produtos/bolo_morango.jpg',
        quantidade: 0
    },
    {
        id: 2,
        nome: 'Mousse de chocolate',
        preco: '7,50',
        img: 'images/produtos/mousse_chocolate.webp',
        quantidade: 0
    },
]

inicializarLoja = () => {
    var containerProdutos = document.getElementById('produtos');
    items.map((val) => {
        containerProdutos.innerHTML += `
        <div class="produto-single">
            <img class="imagem-produto" src="`+val.img+`" />
            <p>`+val.nome+`</p>
            <p> R$`+val.preco+`</p>
            <a class="btn btn-success" key="`+val.id+`" href="#">Adicionar ao carrinho</a>
        </div>
        `;
    })
}

inicializarLoja();


atualizarCarrinho = () => {
    var containerCarrinho = document.getElementById('carrinho');
    containerCarrinho.innerHTML = "";
    items.map((val) => {
        if (val.quantidade > 0) {

        
        containerCarrinho.innerHTML += `
            <p>`+val.nome+` | quantidade `+val.quantidade+`</p>
        `;
        }
    })
}

var links = document.getElementsByTagName('a');

for(var i=0; i<links.length; i++){
    links[i].addEventListener("click",function(){
        let key = this.getAttribute('key');
        items[key].quantidade++;
        atualizarCarrinho();
        return false;
    })
}