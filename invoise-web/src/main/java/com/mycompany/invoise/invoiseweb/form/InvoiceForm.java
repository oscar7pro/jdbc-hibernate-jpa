package com.mycompany.invoise.invoiseweb.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InvoiceForm {
    private String number;
    @NotBlank(/*message ="Le nom client est obligatoire" */)
    private String customerName;
    @Size(min = 10, max = 13 /*message ="Le numero de commande n'a pas de bonne lonueur"*/)
    private String orderNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
