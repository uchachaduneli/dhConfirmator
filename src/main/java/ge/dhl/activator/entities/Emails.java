package ge.dhl.activator.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Emails {
    private Integer id;
    private String mail;
    private Integer leadId;
    private Byte confirmed;
    private String note;
    private String activationCode;
    private Timestamp createDate;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "lead_id")
    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    @Basic
    @Column(name = "confirmed")
    public Byte getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Byte confirmed) {
        this.confirmed = confirmed;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "activation_code")
    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emails emails = (Emails) o;
        return Objects.equals(id, emails.id) &&
                Objects.equals(mail, emails.mail) &&
                Objects.equals(leadId, emails.leadId) &&
                Objects.equals(confirmed, emails.confirmed) &&
                Objects.equals(note, emails.note) &&
                Objects.equals(activationCode, emails.activationCode) &&
                Objects.equals(createDate, emails.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail, leadId, confirmed, note, activationCode, createDate);
    }
}
