package jtechlog.springconverter.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationDao extends PagingAndSortingRepository<Location, Long> {

    @Query("select l from Location l order by l.id")
    Page<Location> findAllOrderById(Pageable pageable);
}
