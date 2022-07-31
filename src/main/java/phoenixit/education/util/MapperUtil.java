package phoenixit.education.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

/**
 * Class for mapping EducationModelApiApplication entities.
 */
@Mapper
public abstract class MapperUtil {

  public static MapperUtil INSTANCE = Mappers.getMapper(MapperUtil.class);

  /**
   * Converting the Request object to a Model entity.
   */
  public abstract Model convertToModel(ModelRequest modelRequest);

  /**
   * Converting the Model entity to a Response object.
   */
  public abstract ModelResponse convertToResponse(Model model);
}