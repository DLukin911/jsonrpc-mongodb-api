package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import java.util.List;
import phoenixit.education.models.ModelResponse;

/**
 * API for receiving and sending data via JSON-RPC.
 */
@JsonRpcService("/api")
public interface JsonRpcApi {

  ModelResponse create(@JsonRpcParam(value = "name") String name,
      @JsonRpcParam(value = "comment") String comment);

  ModelResponse update(@JsonRpcParam(value = "id") String id,
      @JsonRpcParam(value = "name") String name, @JsonRpcParam(value = "comment") String comment);

  int delete(@JsonRpcParam(value = "id") String id);

  ModelResponse get(@JsonRpcParam(value = "id") String id);

  List<ModelResponse> getAll();
}