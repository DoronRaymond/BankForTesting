import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    public AccountRepository() {
    }

    public void save(Account account) {
        throw new RuntimeException("Connection to DB doesn't exist");
    }
}
