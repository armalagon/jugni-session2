package org.jugni.session.lecturer.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author aalaniz
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"jugNiId", "fullName", "gender"})
public class Lecturer {

    public enum Gender {
        MALE, FEMALE
    }

    private String jugNiId;
    private String fullName;
    private Gender gender;

    public Lecturer() {
    }

    public Lecturer(String jugNiId, String fullName, Gender gender) {
        this.jugNiId = jugNiId;
        this.fullName = fullName;
        this.gender = gender;
    }

    public String getJugNiId() {
        return jugNiId;
    }

    public void setJugNiId(String jugNiId) {
        this.jugNiId = jugNiId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.jugNiId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lecturer other = (Lecturer) obj;
        if (!Objects.equals(this.jugNiId, other.jugNiId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lecturer{" + "jugNiId=" + jugNiId + ", fullName=" + fullName + ", gender=" + gender + '}';
    }
}
