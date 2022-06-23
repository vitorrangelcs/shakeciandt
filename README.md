# Projeto loja de Shake 

```
Foi solicitado que fosse criado um sistema de uma loja de shakes,você como desenvolvedor 
recebeu a tarefa de implementar esse sistema para isso você deve seguir as seguintes 
especificações.
```

<h3>Dentro do package de Ingrediente temos a seguinte estrutura</h3>
<ul>
    <li><code>Interface</code> Ingrediente</li>
    <ul>
        <li>Método(s):</li>
        <ul>
            <li>Enum obterTipo();</li>
        </ul>
    </ul>
    <li><code>Interface</code> Adicional</li>
    <li><code>Enum</code> TipoBase</li>
    <ul>
        <li>Valores: Iorgurte, Sorvete e Leite.</li>
    </ul>
    <li><code>Enum</code> TipoTopping</li>
    <ul>
        <li>Valores: Aveia, Mel e Chocolate.</li>
    </ul>
    <li><code>Enum</code> TipoFruta</li>
    <ul>
        <li>Valores: Morango, Banana e Abacate.</li>
    </ul>
    <li><code>Class</code> Base</li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Ingrediente</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoBase tipoBase;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Base(TipoBase tipoBase)</li>
            <li><code>public</code> TipoBase getTipoBase()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
        </ul>
    <li><code>Class</code> Topping</li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Adicional</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoTopping tipoTopping;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Topping(TipoTopping tipoTopping)</li>
            <li><code>public</code> TipoTopping getTipoTopping()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
    </ul>
    <li><code>Class</code> Fruta</li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Adicional</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoFruta tipoFruta;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Fruta(TipoFruta tipoFruta)</li>
            <li><code>public</code> TipoFruta getTipoFruta()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
    </ul>
</ul>

<h3>Dentro do package de Produto temos a seguinte estrutura</h3>
<ul>
    <li><code>Enum</code> TipoTamanho</li>
    <ul>
        <li>Valores: P,M,G</li>
    </ul>
    <li><code>Class</code> Shake</li>
    <ul>
        <li>Atributo(s):</li>
    <ul>
        <li><code>private</code> Base base</li>
        <li><code>private</code> Fruta fruta</li>
        <li><code>private</code> Topping topping</li>
        <li><code>private</code> List&lt;Adicional&gt; adicionais</li>
        <li><code>private</code> TipoTamanho tipoTamanho</li>
    </ul>
    <li>Método(s):</li>
    <ul>
         <li><code>public</code> Shake(Base base,Fruta fruta,Topping topping,List&lt;Adicional&gt; adicionais,TipoTamanho tipoTamanho)</li>
         <li><code>public</code> Shake(Base base,Fruta fruta,Topping topping,TipoTamanho tipoTamanho)</li>
         <li><code>public</code> Base getBase()</li>
         <li><code>public</code> Base getFruta()</li>
         <li><code>public</code> Base getTopping()</li>
         <li><code>public</code> List&lt;Adiciona&gt; getAdicionais()</li>
         <li><code>public</code> TipoTamanho getTipoTamanho()</li>
         <li><code>public</code> String toString()</li>
   </ul>
   </ul>
   </ul>

<h3>Dentro do package de Pedido temos a seguinte estrutura</h3>
<ul>
    <li><code>Class</code> Cardapio</li>
        <ul>
           <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TreeMap&lt;Ingrediente,Double&gt; preco</li>
    </ul>
    <li>Método(s):</li>
    <ul>
         <li><code>public</code> Cardapio()</li>
         <li><code>public</code> void adicionarIngrediente(Ingrediente ingrediente,Double preco)</li>
         <li><code>public</code> boolean atualizarIngrediente(Ingrediente ingrediente,Double preco)</li>
         <li><code>public</code> boolean removerIngrediente(Ingrediente ingrediente)</li>
         <li><code>public</code> Double buscarPreco(Ingrediente ingrediente)</li>
         <li><code>public</code> String toString()</li>
   </ul>
   </ul>
   </ul>
    <li><code>Class</code> Cliente</li>
         <ul>
           <li>Atributo(s):</li>
         <ul>
            <li><code>private</code> int id</li>
            <li><code>private</code> String nome</li>
            <li><code>private</code> String email</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> Cliente(int id, String nome, String email)</li>
            <li><code>public</code> void serializarCliente()</li>
            <li><code>public</code> Cliente desserializarCliente(int id)</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> String toString()</li>
         </ul>
         </ul>
    <li><code>Class</code> ItemPedido</li>
          <ul>
           <li>Atributo(s):</li>
          <ul>
            <li><code>private</code> Shake shake</li>
            <li><code>private</code> int quantidade</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> ItemPedido(Shake shake, int quantidade)</li>
            <li><code>public</code> Shake getShake()</li>
            <li><code>public</code> int getQuantidade()</li>
            <li><code>public</code> setQuantidade(int quantidade)</li>
            <li><code>public</code> String toString()</li>
         </ul>
         </ul>
    <li><code>Class</code> Pedido</li>
       <ul>
           <li>Atributo(s):</li>
          <ul>
            <li><code>private</code> int id</li>
            <li><code>private</code> ArrayList&lt;ItemPedido&gt; itens</li>
            <li><code>private</code> Cliente cliente</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente)</li>
            <li><code>public</code> ArrayList&lt;ItemPedido&gt; getItens()</li>
            <li><code>public</code> int getId()</li>
            <li><code>public</code> Cliente getCliente()</li>
            <li><code>public</code> double calcularTotal(Cardapio cardapio)</li>
            <li><code>public</code> adicionarItemPedido(ItemPedido itemPedidoAdicionado)</li>
            <li><code>public</code> boolean removeItemPedido(ItemPedido itemPedidoRemovido)</li>
            <li><code>public</code> String toString()</li>
         </ul>
       </ul>


<h3>Dentro do package de Demo temos a seguinte estrutura</h3>
<ul>
    <li><code>Class</code> Program</li>
    <h4>Utilize  o main de referência para construir a aplicação</h4>
</ul>


<h3>Regras de negócio</h3>
<ul>
    <li>Custo do Shake em relação ao Tamanho:</li>
    <ul>
        <li>P: preco da Base original</li>
        <li>M: preco da Base acrescentado de 30%</li>
        <li>G: preco da Base acrescentado de 50%</li>         
    </ul>
    <li>Custo do Shake em relação ao Tamanho:</li>
    <ul>
        <li>P: preco da Base original</li>
        <li>M: preco da Base acrescentado de 30%</li>
        <li>G: preco da Base acrescentado de 50%</li>         
    </ul>
</ul>