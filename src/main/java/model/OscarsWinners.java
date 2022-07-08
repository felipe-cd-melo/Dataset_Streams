package model;

public class OscarsWinners {

    private final Long index;
    private final Integer year;
    private final Integer age;
    private final String name;
    private final String movie;
    private SexType sex;

    public OscarsWinners(Long index, int year, int age, String name, String movie, SexType sex) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
        this.sex = sex;
    }

    public Long getIndex() {
        return index;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }

    public String getSex() {
        return sex.getDescription();
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "DadosOscar{" +
                "index=" + index +
                ", year=" + year +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\'' +
                ", sex='" + sex.getDescription() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OscarsWinners that = (OscarsWinners) obj;
        return this.name.equals(that.getName());
    }
}
