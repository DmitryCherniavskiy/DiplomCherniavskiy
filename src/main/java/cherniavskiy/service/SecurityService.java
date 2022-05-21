package cherniavskiy.service;


public interface SecurityService {

    String findLoggedInUsername();

    String findLoggedTelephone();

    void autoLogin(String username, String password);

    void autoLoginTO(String username, String password);
}
