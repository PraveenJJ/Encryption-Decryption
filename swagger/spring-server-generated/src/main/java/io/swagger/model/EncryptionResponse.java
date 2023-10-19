package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EncryptionResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-10T17:13:44.864504617Z[GMT]")


public class EncryptionResponse   {
  @JsonProperty("encryptedMessage")
  private String encryptedMessage = null;

  @JsonProperty("key")
  private String key = null;

  public EncryptionResponse encryptedMessage(String encryptedMessage) {
    this.encryptedMessage = encryptedMessage;
    return this;
  }

  /**
   * Get encryptedMessage
   * @return encryptedMessage
   **/
  @Schema(example = "7GmbBt3dSkBY4lqFSaWADQ==", required = true, description = "")
      @NotNull

    public String getEncryptedMessage() {
    return encryptedMessage;
  }

  public void setEncryptedMessage(String encryptedMessage) {
    this.encryptedMessage = encryptedMessage;
  }

  public EncryptionResponse key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
   **/
  @Schema(example = "DEAB4967BB669B9B", required = true, description = "")
      @NotNull

    public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionResponse encryptionResponse = (EncryptionResponse) o;
    return Objects.equals(this.encryptedMessage, encryptionResponse.encryptedMessage) &&
        Objects.equals(this.key, encryptionResponse.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptedMessage, key);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionResponse {\n");
    
    sb.append("    encryptedMessage: ").append(toIndentedString(encryptedMessage)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
