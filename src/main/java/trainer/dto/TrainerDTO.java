package trainer.dto;

import java.util.Date;

/**
 * 트레이너관리 DTO
 * @author dahee
 * @since 25.09.17
 */
public class TrainerDTO {
    private int id;
    private String name;
    private String phone;
    private int baseSalary;
    private int bonus;
    private int lessons;
    private Date regDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getLessons() {
        return lessons;
    }

    public void setLessons(int lessons) {
        this.lessons = lessons;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int calculatePay() {
        return baseSalary + (lessons * bonus);
    }

    @Override
    public String toString() {
        return "TrainerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", baseSalary=" + baseSalary +
                ", bonus=" + bonus +
                ", lessons=" + lessons +
                ", regDate=" + regDate +
                '}';
    }
}
