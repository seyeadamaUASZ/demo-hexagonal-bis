package com.sid.gl.domain.model;


import com.sid.gl.common.exceptions.ValidationException;

import java.util.Objects;

public class Department {
    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Department(Builder builder){
        id = builder.id;
        name= builder.name;
        description= builder.description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Department that = (Department) object;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    public void validate(){
        this.checkValues();
    }

    // TODO : refactor this to implement monad pattern
    private void checkValues(){
        if(name ==null || name.isBlank()){
            throw new ValidationException("required fields !!");
        }
        if(description ==null || description.isBlank()){
            throw new ValidationException("required fields !!");
        }
    }

    public static final class Builder{
        private Long id;
        private String name;
        private String description;

        private Builder(){}
        public static Builder builder() { return new Builder() ;}

        public Builder id(Long val){
            id=val;
            return this;
        }

        public Builder name(String val){
            name=val;
            return this;
        }

        public Builder description(String val){
            description=val;
            return this;
        }
        public Department build(){
            return new Department(this);
        }
    }


}
