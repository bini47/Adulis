package com.example.biniyam.mint.Model.Product;

public class SingleProduct {


        public Product product;
        public int comment_count;

        public SingleProduct() {
        }

        public SingleProduct(Product product, int comment_count) {
                this.product = product;
                this.comment_count = comment_count;
        }

        public Product getProduct() {
                return product;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

        public int getComment_count() {
                return comment_count;
        }

        public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
        }
}
