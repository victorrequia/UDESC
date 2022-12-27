const items = [
    {
        id: 0,
        nome: 'Bolo de pote',
        img: '../produtos/bolo_pote.jpg',
        quantidade: 0
    },
    {
        id: 1,
        nome: 'Bolo de morango',
        img: '../produtos/bolo_morango.jpg',
        quantidade: 0
    },
    {
        id: 2,
        nome: 'Mousse de chocolate',
        img: '../produtos/mousse_chocolate.webp',
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
            <a key="`+val.id+`" href="#">Adicionar ao carrinho</a>
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