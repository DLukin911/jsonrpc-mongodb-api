package phoenixit.education.config;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for JSON-RPC.
 */
@Configuration
public class JsonRpcConfig {

  @Bean
  public static AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
    AutoJsonRpcServiceImplExporter exp = new AutoJsonRpcServiceImplExporter();
    return exp;
  }
}
