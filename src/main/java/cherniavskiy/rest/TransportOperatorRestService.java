package cherniavskiy.rest;


import cherniavskiy.service.TransportOperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/public/rest/rec")
public class TransportOperatorRestService {

    @Autowired
    private TransportOperatorService transportOperatorService;

    @RequestMapping(value = "/into/{page}", method = RequestMethod.GET)
    public ResponseEntity<Object> browse(@PathVariable("page") Integer page) {
        return ResponseEntity.ok(transportOperatorService.listAll(page));
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        transportOperatorService.delete(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public ResponseEntity<Object> count() {
        return ResponseEntity.ok(transportOperatorService.count());
    }
}
