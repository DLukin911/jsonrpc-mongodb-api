package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import java.util.List;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

/**
 * API for receiving and sending data via JSON-RPC.
 */
@JsonRpcService("/api")
public interface JsonRpcApi {

  ModelResponse create(@JsonRpcParam(value = "request") ModelRequest request);

  ModelResponse update(@JsonRpcParam(value = "request") ModelRequest request);

  int delete(@JsonRpcParam(value = "request") ModelRequest request);

  ModelResponse get(@JsonRpcParam(value = "request") ModelRequest request);

  List<ModelResponse> getAll();
}