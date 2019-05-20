package uk.ac.ebi.atlas;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ebi.atlas.experiments.ExperimentsListController;

import javax.inject.Inject;

@RestController
@Scope("request")
public class Controller {
  private ExperimentsListController experimentsListController;

  @Inject
  public Controller(ExperimentsListController experimentsListController){
    this.experimentsListController = experimentsListController;
  }
  @RequestMapping(value = "/api/sc/json/experiments",
          method = RequestMethod.GET,
          produces = "application/json;charset=UTF-8")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String getExperimentsListFromSingleCell() {
    return experimentsListController.getExperimentsListAPI();
  }
}
