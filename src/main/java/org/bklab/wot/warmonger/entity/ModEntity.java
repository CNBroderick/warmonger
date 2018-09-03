
package org.bklab.wot.warmonger.entity;

@SuppressWarnings("unused")
public class ModEntity {
    private String id;
    private String index;
    private String name;
    private String compatibility;
    private String version;
    private String describe;
    private String pictureNames;
    private String fileNames;
    private String type;

    public ModEntity(String id, String index, String name, String compatibility, String version, String describe, String pictureNames, String fileNames, String type) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.compatibility = compatibility;
        this.version = version;
        this.describe = describe;
        this.pictureNames = pictureNames;
        this.fileNames = fileNames;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public ModEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getIndex() {
        return index;
    }

    public ModEntity setIndex(String index) {
        this.index = index;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public ModEntity setCompatibility(String compatibility) {
        this.compatibility = compatibility;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public ModEntity setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public ModEntity setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public String getPictureNames() {
        return pictureNames;
    }

    public ModEntity setPictureNames(String pictureNames) {
        this.pictureNames = pictureNames;
        return this;
    }

    public String getFileNames() {
        return fileNames;
    }

    public ModEntity setFileNames(String fileNames) {
        this.fileNames = fileNames;
        return this;
    }

    public String getType() {
        return type;
    }

    public ModEntity setType(String type) {
        this.type = type;
        return this;
    }

    public String toString() {
        return "ModEntity{id='" + this.id + '\'' + ", index='" + this.index + '\'' + ", name='" + this.name + '\'' + ", compatibility='" + this.compatibility + '\'' + ", version='" + this.version + '\'' + ", describe='" + this.describe + '\'' + ", pictureNames='" + this.pictureNames + '\'' + ", fileNames='" + this.fileNames + '\'' + ", type='" + this.type + '\'' + '}';
    }
}
