package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarketClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task6Test {
    @Test
    @DisplayName("Add 2, delete 3")
    void test1() {
        StockMarketClass stock = new StockMarketClass();
        assertThat(stock.mostValuableStock()).isNull();

        stock.add(new Stock(2));
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(2));


        stock.add(new Stock(1));
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(2));

        stock.add(new Stock(3));
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(3));

        stock.add(new Stock(1));
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(3));

        // REMOVING

        stock.remove(new Stock(3));
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(2));

        stock.remove(new Stock(4)); // stock shouldn't change
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(2));

        stock.remove(new Stock(1));
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(2));

        stock.remove(new Stock(2));
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(1));

        stock.remove(new Stock(32));
        assertThat(stock.mostValuableStock()).isEqualTo(new Stock(1));

        stock.remove(new Stock(1));
        assertThat(stock.mostValuableStock()).isEqualTo(null);

        stock.remove(new Stock(2));
        assertThat(stock.mostValuableStock()).isEqualTo(null);

    }

    @Test
    @DisplayName("Same values")
    void test2() {
        StockMarketClass stock = new StockMarketClass();

        for (int i = 0; i < 10; ++i) {
            stock.add(new Stock(2));
        }
        for (int i = 0; i < 20; ++i) {
            if (i < 10) {
                assertThat(stock.mostValuableStock()).isEqualTo(new Stock(2));
            } else {
                assertThat(stock.mostValuableStock()).isEqualTo(null);
            }
            stock.remove(new Stock(2));
        }
    }
}
