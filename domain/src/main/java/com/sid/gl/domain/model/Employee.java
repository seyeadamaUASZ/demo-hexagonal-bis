package com.sid.gl.domain.model;

import com.sid.gl.common.exceptions.ValidationException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void validate(){
        this.requiredValues();
    }

    private static boolean patternMatches(String emailAddress) {
        String  regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@\" \n" +
                "[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    private void requiredValues(){
        if(lastName==null || lastName.isBlank()){
            throw new ValidationException("lastName required");
        }
        if(firstName==null || firstName.isBlank()){
            throw new ValidationException("lastName required");
        }

        if(email ==null || email.isBlank()){
            throw new ValidationException("email is required !!");
        }

        if(!patternMatches(email)){
            throw new ValidationException("format email is incorrect !!!");
        }

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, department);
    }

    public Employee(Builder builder){
        id = builder.id;
        lastName= builder.lastName;
        firstName= builder.firstName;
        email= builder.email;
    }

    public static final class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private Department department;

        private Builder(){}

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(Long val){
            id=val;
            return this;
        }
        public Builder firstName(String val){
            firstName = val;
            return this;
        }
        public Builder lastName(String val){
            lastName = val;
            return this;
        }

        public Builder email(String val){
            email=val;
            return this;
        }

        public Builder department(Department val){
            department=val;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }
}

