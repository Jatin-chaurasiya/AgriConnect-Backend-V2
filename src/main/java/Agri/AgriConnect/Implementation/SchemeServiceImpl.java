package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Entity.Scheme;
import Agri.AgriConnect.Enum.Category;
import Agri.AgriConnect.Enum.SchemeType;
import Agri.AgriConnect.Enum.State;
import Agri.AgriConnect.Repository.SchemeRepository;
import Agri.AgriConnect.Service.SchemeService;
import Agri.AgriConnect.scheme.SchemeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchemeServiceImpl implements SchemeService {

    private final SchemeRepository schemeRepository;

    @Override
    public List<Scheme> getSchemes(SchemeType type, State state, Category category) {
        return schemeRepository.findAll(
                SchemeSpecification.filterSchemes(type, state, category)
        );
    }

    @Override
    public Scheme getSchemeById(Long id) {
        return schemeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Scheme not found with id: " + id));
    }
}