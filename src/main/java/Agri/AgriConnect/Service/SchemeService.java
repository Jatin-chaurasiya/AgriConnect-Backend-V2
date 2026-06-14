package Agri.AgriConnect.Service;

import Agri.AgriConnect.Entity.Scheme;
import Agri.AgriConnect.Enum.Category;
import Agri.AgriConnect.Enum.SchemeType;
import Agri.AgriConnect.Enum.State;

import java.util.List;

public interface SchemeService {
    List<Scheme> getSchemes(SchemeType type, State state, Category category);
    Scheme getSchemeById(Long id);
}