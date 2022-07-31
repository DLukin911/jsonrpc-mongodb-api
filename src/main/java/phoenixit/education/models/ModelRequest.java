package phoenixit.education.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Model for Request.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ModelRequest {

  private String id;
  private String name;
  private String comment;

  public ModelRequest(String name, String comment) {
    this.name = name;
    this.comment = comment;
  }

  public ModelRequest(String id) {
    this.id = id;
  }
}
