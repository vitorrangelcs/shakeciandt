package pedido;

import exception.IngredienteNaoEncontradoException;
import exception.PrecoInvalidoException;
import ingredientes.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardapioTest {

    Cardapio cardapio;

    @BeforeAll
    void setup(){
        cardapio = new Cardapio();
    }

    @Test
    void test_adicionar_ingredientes_properly(){
        int contator = 0;
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);
        Topping topping = new Topping(TipoTopping.Mel);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        assertEquals(3, cardapio.getPrecos().size());

        for (Map.Entry<Ingrediente,Double> pair : cardapio.getPrecos().entrySet()) {
            if (contator == 0) {
                assertEquals(new Base(TipoBase.Iorgute), pair.getKey());
                assertEquals(1.0, pair.getValue());
            }
            if (contator == 1) {
                assertEquals(new Topping(TipoTopping.Mel), pair.getKey());
                assertEquals(10.0, pair.getValue());
            }
            if (contator == 2) {
                assertEquals(new Fruta(TipoFruta.Morango), pair.getKey());
                assertEquals(5.0, pair.getValue());
            }
            contator += 1;
        }
    }

    @Test
    void test_adicionar_ingredientes_exception_precoInvalido(){
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);

        Exception thrown = assertThrows(
                PrecoInvalidoException.class,
                () -> cardapio.adicionarIngrediente(base, -9.0),
                "Excecao nao encontrada"
        );

        Exception thrown2 = assertThrows(
                PrecoInvalidoException.class,
                () -> cardapio.adicionarIngrediente(fruta, 0.0),
                "Excecao nao encontrada"
        );

        assertEquals("Preco invalido.", thrown.getMessage());
        assertEquals("Preco invalido.", thrown2.getMessage());

    }

    @Test
    void test_atualizar_ingredientes_properly(){
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);
        Topping topping = new Topping(TipoTopping.Mel);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        cardapio.atualizarIngrediente(new Base(TipoBase.Iorgute), 9.0);

        assertEquals(3, cardapio.getPrecos().size());
        assertEquals(9.0, cardapio.getPrecos().get(new Base(TipoBase.Iorgute)));
        assertEquals(5.0, cardapio.getPrecos().get(new Fruta(TipoFruta.Morango)));
        assertEquals(10.0, cardapio.getPrecos().get(new Topping(TipoTopping.Mel)));
    }

    @Test
    void test_atualizar_ingredientes_exception_precoInvalido(){
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);

        cardapio.adicionarIngrediente(base, 9.0);
        cardapio.adicionarIngrediente(fruta, 10.0);

        Exception thrown = assertThrows(
                PrecoInvalidoException.class,
                () -> cardapio.atualizarIngrediente(new Base(TipoBase.Iorgute), -9.0),
                "Excecao nao encontrada"
        );

        Exception thrown2 = assertThrows(
                PrecoInvalidoException.class,
                () -> cardapio.atualizarIngrediente(new Fruta(TipoFruta.Morango), 0.0),
                "Excecao nao encontrada"
        );

        assertEquals("Preco invalido.", thrown.getMessage());
        assertEquals("Preco invalido.", thrown2.getMessage());
    }

    @Test
    void test_atualizar_ingredientes_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);
        Topping topping = new Topping(TipoTopping.Aveia);

        cardapio.adicionarIngrediente(base, 9.0);
        cardapio.adicionarIngrediente(fruta, 10.0);
        cardapio.adicionarIngrediente(fruta, 10.0);

        Exception thrown = assertThrows(
                IngredienteNaoEncontradoException.class,
                () -> cardapio.atualizarIngrediente(new Topping(TipoTopping.Mel), 19.0),
                "Excecao nao encontrada"
        );

        assertEquals("Ingrediente nao existe no cardapio.", thrown.getMessage());
    }

    @Test
    void test_remover_ingredientes_properly(){
        int contator = 0;
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);
        Topping topping = new Topping(TipoTopping.Mel);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        cardapio.removerIngrediente(new Base(TipoBase.Iorgute));

        assertEquals(2, cardapio.getPrecos().size());

        for (Map.Entry<Ingrediente,Double> pair : cardapio.getPrecos().entrySet()) {
            if (contator == 0) {
                assertEquals(new Topping(TipoTopping.Mel), pair.getKey());
                assertEquals(10.0, pair.getValue());
            }
            if (contator == 1) {
                assertEquals(new Fruta(TipoFruta.Morango), pair.getKey());
                assertEquals(5.0, pair.getValue());
            }
            contator += 1;
        }
    }

    @Test
    void test_remover_ingredientes_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.Iorgute);
        cardapio.adicionarIngrediente(base, 1.0);

        Exception thrown = assertThrows(
                IngredienteNaoEncontradoException.class,
                () -> cardapio.removerIngrediente(new Topping(TipoTopping.Mel)),
                "Excecao nao encontrada"
        );

        assertEquals("Ingrediente nao existe no cardapio.", thrown.getMessage());
    }

    @Test
    void test_buscar_ingrediente_properly(){
        Base base = new Base(TipoBase.Iorgute);

        cardapio.adicionarIngrediente(base, 1.0);

        assertEquals(1.0, cardapio.buscarPreco(new Base(TipoBase.Iorgute)));
    }

    @Test
    void test_buscar_ingrediente_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.Iorgute);

        cardapio.adicionarIngrediente(base, 1.0);

        Exception thrown = assertThrows(
                IngredienteNaoEncontradoException.class,
                () -> cardapio.buscarPreco(new Base(TipoBase.Sorvete)),
                "Excecao nao encontrada"
        );

        assertEquals("Ingrediente nao existe no cardapio.", thrown.getMessage());
    }

}