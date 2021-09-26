import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MySqlApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MySqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String  query = "insert into users (fullname, email) values (?, ?)";

        int result  = jdbcTemplate.update(query, "Sameer Jain", "jainsameer20@gmail.com");

        if(result > 0) {
            System.out.println("A new row is inserted");
        }

    }
}
