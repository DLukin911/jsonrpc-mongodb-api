package phoenixit.education.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model to save to collection for MongoDB repository.
 */
@Document(collection = "Model")
@Getter
@Setter
public class Model {

  @Id
  private String id;
  private String name;
  private String comment;
  private Date createAt;
  private Date updateAt;
  private String creator;
  private String updater;
}
