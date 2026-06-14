package Agri.AgriConnect.scheme;

import Agri.AgriConnect.Entity.Scheme;
import Agri.AgriConnect.Enum.Category;
import Agri.AgriConnect.Enum.SchemeType;
import Agri.AgriConnect.Enum.State;
import org.springframework.data.jpa.domain.Specification;

public class SchemeSpecification {

    public static Specification<Scheme> filterSchemes(
            SchemeType type,
            State state,
            Category category
    ) {
        return (root, query, cb) -> {

            var predicate = cb.conjunction();

            if (type != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("type"), type));
            }

            if (state != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("state"), state));
            }

            if (category != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("category"), category));
            }

            return predicate;
        };
    }
}