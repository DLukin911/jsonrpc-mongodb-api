package phoenixit.education.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phoenixit.education.exceptions.NotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.repositories.ModelRepository;
import phoenixit.education.util.MapperUtil;

/**
 * Class for service operations with entities.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ModelService {

  private final ModelRepository modelRepository;

  public ModelResponse create(ModelRequest modelRequest) {
    log.info("Creating a new model on ModelRequest: {}", modelRequest);
    if (modelRequest == null || modelRequest.getName() == null) {
      log.warn("Error creating a new model on ModelRequest: {}", modelRequest);
      throw new NotFoundException("No information found for this query.");
    }
    Model model = MapperUtil.INSTANCE.convertToModel(modelRequest);
    model.setCreateAt(new Date());
    return MapperUtil.INSTANCE.convertToResponse(modelRepository.insert(model));
  }

  @Transactional
  public ModelResponse update(ModelRequest modelRequest) {
    log.info("Update model on ModelRequest: {}", modelRequest);
    if (modelRequest.getId() == null) {
      log.warn("Error update model on ModelRequest: {}", modelRequest);
      throw new NotFoundException("No information found for this query.");
    }
    Model model = modelRepository.findById(modelRequest.getId())
        .orElseThrow(() -> {
          log.warn("Error update model on ModelRequest: {}", modelRequest);
          return new NotFoundException("No information found for this query.");
        });
    model.setName(modelRequest.getName());
    model.setComment(modelRequest.getComment());
    model.setUpdateAt(new Date());
    return MapperUtil.INSTANCE.convertToResponse(modelRepository.save(model));
  }

  public int delete(ModelRequest modelRequest) {
    log.info("Delete model on ModelRequest: {}", modelRequest);
    if (modelRequest.getId() == null) {
      log.warn("Error delete model on ModelRequest: {}", modelRequest);
      throw new NotFoundException("No information found for this query.");
    }
    Model model = modelRepository.findById(modelRequest.getId())
        .orElseThrow(() -> {
          log.warn("Error delete model on ModelRequest: {}", modelRequest);
          return new NotFoundException("No information found for this query.");
        });
    modelRepository.deleteById(model.getId());
    return 1;
  }

  public ModelResponse get(ModelRequest modelRequest) {
    log.info("Get model on ModelRequest: {}", modelRequest);
    if (modelRequest.getId() == null) {
      log.warn("Error get model on ModelRequest: {}", modelRequest);
      throw new NotFoundException("No information found for this query.");
    }
    Model model = modelRepository.findById(modelRequest.getId())
        .orElseThrow(() -> {
          log.warn("Error get model on ModelRequest: {}", modelRequest);
          return new NotFoundException("No information found for this query.");
        });
    return MapperUtil.INSTANCE.convertToResponse(model);
  }

  public List<ModelResponse> getAll() {
    log.info("Get All models from repository");
    List<Model> modelList = modelRepository.findAll();
    if (modelList.isEmpty()) {
      log.warn("Error get all models from repository");
      throw new NotFoundException("No information found for this query.");
    }
    List<ModelResponse> modelResponseList = new ArrayList<>();
    for (Model model : modelList) {
      modelResponseList.add(MapperUtil.INSTANCE.convertToResponse(model));
    }
    return modelResponseList;
  }
}