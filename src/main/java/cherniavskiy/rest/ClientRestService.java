package cherniavskiy.rest;



import cherniavskiy.db.model.Client;
import cherniavskiy.db.model.Order;
import cherniavskiy.db.model.TransportOperator;
import cherniavskiy.service.ClientService;
import cherniavskiy.service.OrderService;
import cherniavskiy.service.SecurityService;
import cherniavskiy.service.TransportOperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/public/rest/client")
public class ClientRestService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private TransportOperatorService toService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/registration/{telephone}/{name}/{sname}/{pname}/{email}/{password}", method = RequestMethod.POST)
    public ResponseEntity<Object> registration(@PathVariable("telephone") String telephone, @PathVariable("name") String name,
                               @PathVariable("sname") String sname, @PathVariable("pname") String pname,
                               @PathVariable("email") String email, @PathVariable("password") String password) {

        if (clientService.findByUsername(telephone)!=null)
            return new ResponseEntity(new Error("Телефон уже зарегестрирован"), HttpStatus.BAD_REQUEST);
        Client client = new Client(name,sname, pname, email, telephone,password,1);
        clientService.save(client);
        securityService.autoLogin(client.getTelephone(), client.getConfirmPasshash());
        return ResponseEntity.ok(securityService.findLoggedInUsername());
    }

    @RequestMapping(value = "/registrationto/{telephone}/{name}/{sname}/{pname}/{email}/{password}", method = RequestMethod.POST)
    public ResponseEntity<Object> registrationto(@PathVariable("telephone") String telephone, @PathVariable("name") String name,
                                               @PathVariable("sname") String sname, @PathVariable("pname") String pname,
                                               @PathVariable("email") String email, @PathVariable("password") String password) {

        if (toService.findByUsername(telephone)!=null)
            return new ResponseEntity(new Error("Телефон уже зарегестрирован"), HttpStatus.BAD_REQUEST);
        TransportOperator client = new TransportOperator(name,sname, pname, email, telephone,password,1);
        toService.save(client);
        securityService.autoLoginTO(client.getTelephone(), client.getPasshash());
        return ResponseEntity.ok(securityService.findLoggedInUsername());
    }

    @RequestMapping(value = "/mypage/order", method = RequestMethod.GET)
    public ResponseEntity<Object> myPageOrder() {
        List<Order> orderList = clientService.getOrderByTelephone(securityService.findLoggedTelephone());
        return ResponseEntity.ok(clientService.getOrderByTelephone(securityService.findLoggedTelephone()));
    }
}
