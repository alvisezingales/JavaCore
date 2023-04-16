package enums;

public enum Payement {
    CREDIT_CARD("Pay by credit card / bancomat"),
    ALLOWANCE("Pay by cheque"),
    CASH("Pay with cash");

    private final String description;

    Payement(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }
}






