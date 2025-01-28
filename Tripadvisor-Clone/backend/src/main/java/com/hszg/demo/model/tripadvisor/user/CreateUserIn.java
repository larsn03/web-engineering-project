package com.hszg.demo.model.tripadvisor.user;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Username",
    "Passwort",
    "E-Mail",
    "FirstName",
    "LastName"
})
@Generated("jsonschema2pojo")
public class CreateUserIn {

    @JsonProperty("Username")
    private String username;
    @JsonProperty("Passwort")
    private String passwort;
    @JsonProperty("E-Mail")
    private String eMail;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreateUserIn() {
    }

    public CreateUserIn(String username, String passwort, String eMail, String firstName, String lastName) {
        super();
        this.username = username;
        this.passwort = passwort;
        this.eMail = eMail;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonProperty("Username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("Username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("Passwort")
    public String getPasswort() {
        return passwort;
    }

    @JsonProperty("Passwort")
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    @JsonProperty("E-Mail")
    public String getEMail() {
        return eMail;
    }

    @JsonProperty("E-Mail")
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        sb.append(CreateUserIn.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("username");
        sb.append('=');
        sb.append(((this.username == null)?"<null>":this.username));
        sb.append(',');
        sb.append("passwort");
        sb.append('=');
        sb.append(((this.passwort == null)?"<null>":this.passwort));
        sb.append(',');
        sb.append("eMail");
        sb.append('=');
        sb.append(((this.eMail == null)?"<null>":this.eMail));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
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
