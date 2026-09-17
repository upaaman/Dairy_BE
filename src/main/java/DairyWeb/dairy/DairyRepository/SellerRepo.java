package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller , Long> {
}
