package phoenixit.education.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for Response.
 */
@Getter
@Setter
public class ModelResponse {

  private String id;
  private String name;
  private String comment;
  private Date createAt;
  private Date updateAt;
  private String creator;
  private String updater;
}
