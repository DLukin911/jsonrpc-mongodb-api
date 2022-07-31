package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.services.ModelService;

/**
 * Controller for processing input data to create ModelRequest.
 */
@Controller
@AutoJsonRpcServiceImpl
@RequiredArgsConstructor
@Slf4j
public class JsonRpcApiImpl implements JsonRpcApi {

  private final ModelService modelService;

  @Override
  public ModelResponse create(String name, String comment) {
    log.info("Request create with name: {}, comment: {}", name, comment);
    return modelService.create(new ModelRequest(name, comment));
  }

  @Override
  public ModelResponse update(String id, String name, String comment) {
    log.info("Request update by id: {}, name: {}, comment: {}", id, name, comment);
    return modelService.update(new ModelRequest(id, name, comment));
  }

  @Override
  public int delete(String id) {
    log.info("Request delete by id: {}", id);
    return modelService.delete(new ModelRequest(id));
  }

  @Override
  public ModelResponse get(String id) {
    log.info("Request get by id: {}", id);
    return modelService.get(new ModelRequest(id));
  }

  @Override
  public List<ModelResponse> getAll() {
    log.info("Request All Models");
    return modelService.getAll();
  }
}