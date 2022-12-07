package com.training.tdd.tddinnova.app;

public class CustomerDetails {

    private String gender;
    private String status;
    private String group;

    public CustomerDetails() {
    }

    public CustomerDetails(String gender,
                           String status,
                           String group) {
        this.gender = gender;
        this.status = status;
        this.group = group;
    }

    public static CustomerDetailsBuilder builder() {
        return new CustomerDetailsBuilder();
    }

    public String getGender() {
        return this.gender;
    }

    public String getStatus() {
        return this.status;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static class CustomerDetailsBuilder {
        private String gender;
        private String status;
        private String group;

        CustomerDetailsBuilder() {
        }

        public CustomerDetailsBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public CustomerDetailsBuilder status(String status) {
            this.status = status;
            return this;
        }

        public CustomerDetailsBuilder group(String group) {
            this.group = group;
            return this;
        }

        public CustomerDetails build() {
            return new CustomerDetails(gender,
                                       status,
                                       group);
        }

        public String toString() {
            return "CustomerDetails.CustomerDetailsBuilder(gender="
                   + this.gender
                   + ", status="
                   + this.status
                   + ", group="
                   + this.group
                   + ")";
        }
    }
}
