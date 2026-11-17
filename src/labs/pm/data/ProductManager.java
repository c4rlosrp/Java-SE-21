/*
 * Copyright (c) 2026.
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.  If not, see http://www.gnu.org/licenses/.
 */

package labs.pm.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

/**
 * @author manana
 **/
public class ProductManager {
    private Product product;
    private Review review;
    private Locale locale;
    private ResourceBundle resources;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFomart;

    private Review[] reviews = new Review[5];
    private Map<Product, List<Review>> products = new HashMap<>();


    public ProductManager (Locale locale){
        this.locale = locale;
        resources = ResourceBundle.getBundle("labs.pm.data.resources", locale);
        dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        moneyFomart = NumberFormat.getCurrencyInstance(locale);
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore){
        product = new Food(id, name, price, rating, bestBefore);

        //Crear listado de reseñas por producto
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating){
        product = new Drink(id, name, price, rating);

        //Crear listado de reseñas por producto
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {
        //review = new Review(rating, comments);
        if (reviews[reviews.length - 1] != null){
            reviews = Arrays.copyOf(reviews, reviews.length + 5);
        }

        int sum= 0, i = 0;
        boolean reviewed = false;

        while (i < reviews.length && !reviewed) {
            if(reviews[i] == null){
                reviews[i] = new Review(rating, comments);
                reviewed = true;
            }
            sum+= reviews[i].rating().ordinal();
            i++;
        }

        this.product = product.applyRating(Rateable.converrt(Math.round(sum/i)));
        return this.product;
    }

    public void printProductReport(){
        StringBuilder txt = new StringBuilder();

        String type = switch (product){
            case Food food -> resources.getString("food");
            case Drink drink -> resources.getString("drink");
        };

        txt.append(MessageFormat.format(resources.getString("product"),
                product.getName(),
                moneyFomart.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore()),
                type));


        //        txt.append(product);
//        txt.append('\n');
//        if (review != null)
//            txt.append(review);
//        else
//            txt.append("Not reviewed");
        txt.append('\n');
        for (Review review : reviews) {
            if (review == null){
                break;
            }//else {
//                txt.append('\n');
//                txt.append(resources.getString("no.reviews"));
//            }
            txt.append(MessageFormat.format(resources.getString("review"),
                    review.rating().getStars(),
                    review.comments()));
            txt.append('\n');
            if (reviews[0] == null){
                txt.append(resources.getString("no.reviews"));
                txt.append('\n');
            }


        }

        txt.append('\n');
        System.out.println(txt);
    }
}
