import com.chrosciu.shop.ShopApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopServiceIntegrationTest {
    private ShopApplication shopApplication;

    @BeforeEach
    public void setUp() {
        shopApplication = new ShopApplication();
    }

    @AfterEach
    public void tearDown() {
        shopApplication.close();
    }

    @Test
    public void shopServiceShouldBeCreated() {
        assertThat(shopApplication.getShopService()).isNotNull();
    }
}
