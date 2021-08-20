package Main.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import Main.dto.Hotel;
public interface HotelDAO extends JpaRepository<Hotel, Integer>{

}
