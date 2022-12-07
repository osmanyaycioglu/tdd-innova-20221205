package com.training.tdd.tddinnova.app;

public class Customer {
    private Long            customerId;
    private String          name;
    private String          surname;
    private Double          discount;
    private CustomerDetails customerDetails;

    public Customer(){
    }

    public Customer(Long customerId,
             String name,
             String surname,
             Double discount,
             CustomerDetails customerDetails) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.discount = discount;
        this.customerDetails = customerDetails;
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public CustomerDetails getCustomerDetails() {
        return this.customerDetails;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public static class CustomerBuilder {
        private Long            customerId;
        private String          name;
        private String          surname;
        private Double          discount;
        private CustomerDetails customerDetails;

        CustomerBuilder() {
        }

        public CustomerBuilder withCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public CustomerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public CustomerBuilder withDiscount(Double discount) {
            this.discount = discount;
            return this;
        }

        public CustomerBuilder withCustomerDetails(CustomerDetails customerDetails) {
            this.customerDetails = customerDetails;
            return this;
        }

        public Customer build() {
            return new Customer(customerId,
                                name,
                                surname,
                                discount,
                                customerDetails);
        }

        public String toString() {
            return "Customer.CustomerBuilder(customerId="
                   + this.customerId
                   + ", name="
                   + this.name
                   + ", surname="
                   + this.surname
                   + ", discount="
                   + this.discount
                   + ", customerDetails="
                   + this.customerDetails
                   + ")";
        }
    }
}
