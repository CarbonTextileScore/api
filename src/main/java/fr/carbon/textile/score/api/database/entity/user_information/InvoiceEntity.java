package fr.carbon.textile.score.api.database.entity.user_information;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Invoice", schema = "UserInformation", catalog = "postgres")
public class InvoiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "Date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "Quota", nullable = false)
    private int quota;
    @Basic
    @Column(name = "UserId", nullable = false)
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceEntity that = (InvoiceEntity) o;

        if (id != that.id) return false;
        if (quota != that.quota) return false;
        if (userId != that.userId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + quota;
        result = 31 * result + userId;
        return result;
    }
}
