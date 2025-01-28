package com.hszg.demo.model.tripadvisor.location.locationGET;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hszg.demo.model.tripadvisor.location.locationPOST.Address;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Name",
    "Category",
    "Address",
    "Description",
    "Rating",
    "Comments",
    "Pictures",
    "Tags"
})
@Generated("jsonschema2pojo")
public class LocInfoLocationOut {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("Address")
    private com.hszg.demo.model.tripadvisor.location.locationPOST.Address address;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Rating")
    private String rating;
    @JsonProperty("Comments")
    private Comment comment;
    @JsonProperty("Pictures")
    private List<String> pictures;
    @JsonProperty("Tags")
    private List<String> tags;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LocInfoLocationOut() {
    }

    public LocInfoLocationOut(String name, String category, com.hszg.demo.model.tripadvisor.location.locationPOST.Address address, String description, String rating, Comment comment, List<String> pictures, List<String> tags) {
        super();
        this.name = name;
        this.category = category;
        this.address = address;
        this.description = description;
        this.rating = rating;
        this.comment = comment;
        this.pictures = pictures;
        this.tags = tags;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("Address")
    public com.hszg.demo.model.tripadvisor.location.locationPOST.Address getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("Rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("Comments")
    public Comment getComments() {
        return comment;
    }

    @JsonProperty("Comments")
    public void setComments(Comment comment) {
        this.comment = comment;
    }

    @JsonProperty("Pictures")
    public List<String> getPictures() {
        return pictures;
    }

    @JsonProperty("Pictures")
    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    @JsonProperty("Tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("Tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LocInfoLocationOut.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(((this.category == null)?"<null>":this.category));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("rating");
        sb.append('=');
        sb.append(((this.rating == null)?"<null>":this.rating));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comment == null)?"<null>":this.comment));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}