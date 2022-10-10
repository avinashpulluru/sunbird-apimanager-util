package in.ekstep.am.dto.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GrantConsumerRequest {
  @JsonProperty
  private String id;

  @JsonProperty
  private String ver;

  @JsonProperty
  private long ets;

  @JsonProperty
  private Map<String, Object> params;

  @JsonProperty
  @Valid
  @NotNull(message = "REQUEST IS MANDATORY")
  private GrantConsumerRequestDetails request;

  private GrantConsumerRequest() {

  }

  public GrantConsumerRequest(Map<String, Object> params, GrantConsumerRequestDetails request) {
    this.params = params;
    this.request = request;
  }

  public String msgid() {
    return params == null ? "" : params.get("msgid") == null ? "" : (String) params.get("msgid");
  }


  public String[] groups() {
    return request.groups();
  }
}
