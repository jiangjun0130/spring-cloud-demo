package jj.fly.spring.cloud.demo.feign.domain;

public class User {

    private Long id;

    private String username;

    private String name;

    private Integer age;

    public User() {
    }

    public User(Long id, String username, String name, Integer age) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}