package com.example.biniyam.mint.Model.Product;

import java.util.List;

public class SingleProduct {


        public Product product;
        public List<Comment> comments;

        public SingleProduct() {
        }

        public SingleProduct(Product product, List<Comment> comments) {
                this.product = product;
                this.comments = comments;
        }

        public Product getProduct() {
                return product;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

        public List<Comment> getComments() {
                return comments;
        }

        public void setComments(List<Comment> comments) {
                this.comments = comments;
        }
}
