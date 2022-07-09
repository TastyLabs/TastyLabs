package de.tastylabs.list;

import java.time.LocalDateTime;

public abstract class DataElement {
    public abstract String getId();
    public abstract String getTitle();
    public abstract String getIngredients();
    public abstract String getPreparation();
    public abstract LocalDateTime getUploadedAt();
    public abstract String getIpAddressOfSubmitter();
}
