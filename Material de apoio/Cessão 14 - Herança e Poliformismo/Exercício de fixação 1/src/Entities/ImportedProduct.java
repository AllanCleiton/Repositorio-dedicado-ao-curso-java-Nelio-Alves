package Entities;

public final class ImportedProduct extends Product{
    private Double customsFee;

    public ImportedProduct(){}

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    @Override
    public String priceTag(){
        return getName() + " $ " + String.format("%.2f", totalPrice()) + "(Customs fee: $" + String.format("%.2f", getCustomsFee()) + ")";
    }

    public Double totalPrice(){
        return getPrice() + getCustomsFee();
    }
}    
