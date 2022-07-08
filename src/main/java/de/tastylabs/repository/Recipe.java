package de.tastylabs.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.tastylabs.list.DataElement;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Recipe extends DataElement {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String title;

    @Column(columnDefinition = "CLOB")
    private String ingredients;

    @Column(columnDefinition = "CLOB")
    private String preparation;

    private LocalDateTime uploadedAt;

    @JsonIgnore
    private String ipAddressOfSubmitter;

    public Recipe() {}

    public Recipe(String title, String ingredients, String preparation, String ipAddressOfSubmitter) {
        this.title = title;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.ipAddressOfSubmitter = ipAddressOfSubmitter;
        this.uploadedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public String getIpAddressOfSubmitter() {
        return ipAddressOfSubmitter;
    }

    public void setIpAddressOfSubmitter(String ipAddressOfSubmitter) {
        this.ipAddressOfSubmitter = ipAddressOfSubmitter;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", preparation='" + preparation + '\'' +
                ", uploadedAt=" + uploadedAt +
                '}';
    }
}
