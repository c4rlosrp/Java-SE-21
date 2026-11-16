/*
 * Copyright (c) 2026.
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.  If not, see http://www.gnu.org/licenses/.
 */

package labs.pm.app;

import labs.pm.data.*;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * {@code Shop} class represents am aplication that ,anages Products
 * @version 4.0
 * @author oracle
 **/
public class Shop {

    public static void main(String[] args) {

        ProductManager pm = new ProductManager(Locale.FRANCE);

        Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED, LocalDate.now());
//        Product p2 = pm.createProduct(102, "Coffee",BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
//        Product p3 = pm.createProduct(103, "Cake",BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p4 = pm.createProduct(105, "Cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
//        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);
//        Product p9 = p1.applyRating(Rating.TWO_STAR);

//        Product p1 = new Drink(101, "Tea",BigDecimal.valueOf(1.99), Rating.THREE_STAR);
//        Product p2 = new Drink(102, "Coffee",BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
//        Product p3 = new Food(103, "Cake",BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p4 = new Food(105, "Cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//        Product p6 = new Drink(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
//        Product p7 = new Food(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);
//        Product p9 = p1.applyRating(Rating.TWO_STAR);

//        List<Product> listProducts = List.of(p1, p2, p3, p4, p5);
//
//
//        for (Product p: listProducts){
//            //System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getDiscountRate() + " " + p.getRating().getStars());
//
//            System.out.println(p);
//        }
//
//        System.out.println(p6.equals(p7));
//        System.out.println(p8);
//        System.out.println(p9);
//
//        if(p3 instanceof Food f){
//            System.out.println(f.getBestBefore());
//        }
//
//        if(p3 instanceof Food ){
//            System.out.println(((Food)p3).getBestBefore());
//        }
//        System.out.println(p1.getBestBefore());
//        System.out.println(p3.getBestBefore());

        pm.printProductReport();
        p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "Nice hot cup of tea");
        pm.printProductReport();



    }

}