package ra.model.entity;

import java.util.Date;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private Date dateCreated;
    private String descriptions;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, Date dateCreated, String descriptions, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.dateCreated = dateCreated;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
