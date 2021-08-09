package com.org.qualifier.assessment4;

@Entity
public class Employee {
    private String name;
    @Id
    private Integer Id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    @Override
    public String toString() {
        return "Employee [Id=" + Id + ", name=" + name + "]";
    }
    

}
