package phoenixit.education.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import phoenixit.education.AbstractTest;
import phoenixit.education.exceptions.NotFoundException;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

public class ModelServiceTest extends AbstractTest {

  @Autowired
  private ModelService service;

  @Test
  void testShouldCreateNewModel() {
    ModelResponse response = service.create(new ModelRequest("NewSolar", "New comment"));
    Assertions.assertEquals("NewSolar", response.getName());
    service.delete(new ModelRequest(response.getId(), "NewSolar", "New comment"));
  }

  @Test
  void testShouldThrowExpWhenNameNull() {
    NotFoundException exception = Assertions.assertThrows(NotFoundException.class,
        () -> service.create(new ModelRequest(null, null)));
    Assertions.assertEquals("No information found for this query.", exception.getMessage());
  }

  @Test
  void testShouldUpdateModel() {
    ModelResponse response = service.create(new ModelRequest("NewSolar", "New comment"));
    ModelRequest request = new ModelRequest(response.getId(), "UpdateSolar", "Update comment");
    ModelResponse updatedResponse = service.update(request);
    Assertions.assertEquals(response.getId(), updatedResponse.getId());
    Assertions.assertEquals("UpdateSolar", updatedResponse.getName());
    service.delete(request);
  }

  @Test
  void testShouldThrowExpWhenUpdatedIdWrong() {
    NotFoundException exception = Assertions.assertThrows(NotFoundException.class,
        () -> service.update(new ModelRequest("55555", "UpdateSolar", "Update comment")));
    Assertions.assertEquals("No information found for this query.", exception.getMessage());
  }

  @Test
  void testShouldGetModel() {
    ModelResponse response = service.create(new ModelRequest("NewSolar", "New comment"));
    ModelRequest request = new ModelRequest(response.getId(), "NewSolar", "New comment");
    ModelResponse getResponse = service.get(request);
    Assertions.assertEquals(response.getId(), getResponse.getId());
    Assertions.assertEquals("NewSolar", getResponse.getName());
    Assertions.assertEquals("New comment", getResponse.getComment());
    service.delete(request);
  }

  @Test
  void testShouldThrowExpWhenGetIdWrong() {
    NotFoundException exception = Assertions.assertThrows(NotFoundException.class,
        () -> service.get(new ModelRequest("55555", "UpdateSolar", "Update comment")));
    Assertions.assertEquals("No information found for this query.", exception.getMessage());
  }

  @Test
  void testShouldDeleteModel() {
    ModelResponse response = service.create(new ModelRequest("NewSolar", "New comment"));
    ModelRequest request = new ModelRequest(response.getId(), "NewSolar", "New comment");
    service.delete(request);
    NotFoundException exception = Assertions.assertThrows(NotFoundException.class,
        () -> service.get(request));
    Assertions.assertEquals("No information found for this query.", exception.getMessage());
  }

  @Test
  void testShouldThrowExpWhenDeleteIdWrong() {
    NotFoundException exception = Assertions.assertThrows(NotFoundException.class,
        () -> service.get(new ModelRequest("55555", "UpdateSolar", "Update comment")));
    Assertions.assertEquals("No information found for this query.", exception.getMessage());
  }
}