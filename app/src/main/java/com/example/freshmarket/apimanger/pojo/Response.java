package com.example.freshmarket.apimanger.pojo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;


@Entity
public class Response {

    /**
     * id : 1
     * name : Vegetables
     * category_img : https://gazef.s3.us-west-2.amazonaws.com/task-assets/1528666979514.jpg
     * products : [{"id":"1","name":"Potatoes","weight":"1KG","price":"100LE","product_img":"https://gazef.s3.us-west-2.amazonaws.com/task-assets/POT-270z.jpg"},{"id":"2","name":"Onions","weight":"1KG","price":"100LE","product_img":"https://gazef.s3.us-west-2.amazonaws.com/task-assets/indian-fresh-red-onion-exporter.jpg"},{"id":"3","name":"Broccoli","weight":"1KG","price":"100LE","product_img":"https://gazef.s3.us-west-2.amazonaws.com/task-assets/6000016950304.jpg"},{"id":"4","name":"Tomatoes","weight":"1KG","price":"100LE","product_img":"https://gazef.s3.us-west-2.amazonaws.com/task-assets/tomat-kvist-eko-500g-klass1-2.jpg"}]
     */

    @NonNull
    @PrimaryKey
    private String id;
    private String name;
    private String category_img;
    @Ignore
    private List<ProductsBean> products;

@Ignore
    int type;


    public static final int HOME=1;
    public static final int PRODUCTDETAILS=2;



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category_img='" + category_img + '\'' +
                ", products=" + products +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory_img() {
        return category_img;
    }

    public void setCategory_img(String category_img) {
        this.category_img = category_img;
    }

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public static class ProductsBean {
        /**
         * id : 1
         * name : Potatoes
         * weight : 1KG
         * price : 100LE
         * product_img : https://gazef.s3.us-west-2.amazonaws.com/task-assets/POT-270z.jpg
         */

        private String id;
        private String name;
        private String weight;
        private String price;
        private String product_img;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getProduct_img() {
            return product_img;
        }

        public void setProduct_img(String product_img) {
            this.product_img = product_img;
        }

        @Override
        public String toString() {
            return "ProductsBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", weight='" + weight + '\'' +
                    ", price='" + price + '\'' +
                    ", product_img='" + product_img + '\'' +
                    '}';
        }
    }
}
