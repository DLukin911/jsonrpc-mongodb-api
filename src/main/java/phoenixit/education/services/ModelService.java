package phoenixit.education.services;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phoenixit.education.exceptions.NotFoundException;
import phoenixit.education.jsonRPC.JsonRpcApi;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.repositories.ModelRepository;
import phoenixit.education.util.MapperUtil;

/**
 * Class for service operations with entities.
 */
@Service
@AutoJsonRpcServiceImpl
@RequiredArgsConstructor
@Slf4j
public class ModelService implements JsonRpcApi {

  private final ModelRepository repository;

  @Override
  public ModelResponse create(ModelRequest request) {
    log.info("Creating a new model on ModelRequest: {}", request);
    if (request == null || request.getName() == null) {
      log.warn("Error creating a new model on ModelRequest: {}", request);
      throw new NotFoundException("No information found for this query.");
    }
    Model model = MapperUtil.INSTANCE.convertToModel(request);
    model.setCreateAt(new Date());
    return MapperUtil.INSTANCE.convertToResponse(repository.insert(model));
  }

  @Override
  @Transactional
  public ModelResponse update(ModelRequest request) {
    log.info("Update model on ModelRequest: {}", request);
    if (request.getId() == null) {
      log.warn("Error update model on ModelRequest: {}", request);
      throw new NotFoundException("No information found for this query.");
    }
    Model model = repository.findById(request.getId())
        .orElseThrow(() -> {
          log.warn("Error update model on ModelRequest: {}", request);
          return new NotFoundException("No information found for this query.");
        });
    model.setName(request.getName());
    model.setComment(request.getComment());
    model.setUpdateAt(new Date());
    return MapperUtil.INSTANCE.convertToResponse(repository.save(model));
  }

  @Override
  public int delete(ModelRequest request) {
    log.info("Delete model on ModelRequest: {}", request);
    if (request.getId() == null) {
      log.warn("Error delete model on ModelRequest: {}", request);
      throw new NotFoundException("No information found for this query.");
    }
    Model model = repository.findById(request.getId())
        .orElseThrow(() -> {
          log.warn("Error delete model on ModelRequest: {}", request);
          return new NotFoundException("No information found for this query.");
        });
    repository.deleteById(model.getId());
    return 1;
  }

  @Override
  public ModelResponse get(ModelRequest request) {
    log.info("Get model on ModelRequest: {}", request);
    if (request.getId() == null) {
      log.warn("Error get model on ModelRequest: {}", request);
      throw new NotFoundException("No information found for this query.");
    }
    Model model = repository.findById(request.getId())
        .orElseThrow(() -> {
          log.warn("Error get model on ModelRequest: {}", request);
          return new NotFoundException("No information found for this query.");
        });
    return MapperUtil.INSTANCE.convertToResponse(model);
  }

  @Override
  public List<ModelResponse> getAll() {
    log.info("Get All models from repository");
    List<Model> modelList = repository.findAll();
    if (modelList.isEmpty()) {
      log.warn("Error get all models from repository");
      throw new NotFoundException("No information found for this query.");
    }
    List<ModelResponse> modelsResponses = new ArrayList<>();
    for (Model model : modelList) {
      modelsResponses.add(MapperUtil.INSTANCE.convertToResponse(model));
    }
    return modelsResponses;
  }
}