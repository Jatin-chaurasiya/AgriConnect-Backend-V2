package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.*;
import Agri.AgriConnect.Entity.*;
import Agri.AgriConnect.Repository.CropRepository;
import Agri.AgriConnect.Service.CropPlannerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Agri.AgriConnect.Util.CropNameMapper;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CropPlannerServiceImpl implements CropPlannerService {

    private final CropRepository cropRepository;

    @Override
    public CropPlannerResponseDto getCropPlan(CropPlannerRequestDto requestDto) {

        String cropName = CropNameMapper.normalize(requestDto.getCropName());

        Crop crop = cropRepository.findByCropNameIgnoreCase(cropName)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Crop not found : " + cropName));
        return convertToResponseDto(crop);
    }
    /**
     * Convert Crop Entity into Response DTO
     */
    private CropPlannerResponseDto convertToResponseDto(Crop crop) {

        CropPlannerResponseDto dto = new CropPlannerResponseDto();

        // Crop Details
        dto.setCropName(crop.getCropName());
        dto.setScientificName(crop.getScientificName());
        dto.setCropType(crop.getCropType());
        dto.setSeason(crop.getSeason());
        dto.setDurationDays(crop.getDurationDays());
        dto.setIdealTemperature(crop.getIdealTemperature());
        dto.setIdealHumidity(crop.getIdealHumidity());
        dto.setIdealPh(crop.getIdealPh());
        dto.setRainfall(crop.getRainfall());
        dto.setDescription(crop.getDescription());

        // Summary
        dto.setEstimatedCost(getEstimatedCost(crop));
        dto.setExpectedIncome(getExpectedIncome(crop));
        dto.setExpectedProfit(getExpectedProfit(crop));

        // Child DTO Mapping
        dto.setSeeds(
                crop.getSeeds()
                        .stream()
                        .map(this::convertSeedToDto)
                        .collect(Collectors.toList())
        );

        dto.setFertilizers(
                crop.getFertilizers()
                        .stream()
                        .map(this::convertFertilizerToDto)
                        .collect(Collectors.toList())
        );

        dto.setIrrigations(
                crop.getIrrigations()
                        .stream()
                        .map(this::convertIrrigationToDto)
                        .collect(Collectors.toList())
        );

        dto.setDiseases(
                crop.getDiseases()
                        .stream()
                        .map(this::convertDiseaseToDto)
                        .collect(Collectors.toList())
        );

        dto.setCalendarActivities(
                crop.getCalendarActivities()
                        .stream()
                        .map(this::convertCalendarActivityToDto)
                        .collect(Collectors.toList())
        );

        dto.setCosts(
                crop.getCosts()
                        .stream()
                        .map(this::convertCostToDto)
                        .collect(Collectors.toList())
        );

        dto.setYields(
                crop.getYields()
                        .stream()
                        .map(this::convertYieldToDto)
                        .collect(Collectors.toList())
        );

        return dto;
    }
    /**
     * Get Total Estimated Cost
     */
    private Double getEstimatedCost(Crop crop) {

        if (crop.getCosts() == null || crop.getCosts().isEmpty()) {
            return 0.0;
        }

        Cost cost = crop.getCosts().get(0);

        return cost.getTotalCost() == null ? 0.0 : cost.getTotalCost();
    }

    /**
     * Get Expected Income
     */
    private Double getExpectedIncome(Crop crop) {

        if (crop.getYields() == null || crop.getYields().isEmpty()) {
            return 0.0;
        }

        Yield yield = crop.getYields().get(0);

        return yield.getExpectedIncome() == null
                ? 0.0
                : yield.getExpectedIncome();
    }

    /**
     * Get Expected Profit
     */
    private Double getExpectedProfit(Crop crop) {

        if (crop.getYields() == null || crop.getYields().isEmpty()) {
            return 0.0;
        }

        Yield yield = crop.getYields().get(0);

        // If Profit already exists in DB use it

        if (yield.getExpectedProfit() != null) {
            return yield.getExpectedProfit();
        }

        // Otherwise Calculate

        Double income = getExpectedIncome(crop);

        Double cost = getEstimatedCost(crop);

        return income - cost;
    }
    private SeedResponseDto convertSeedToDto(Seed seed) {

        SeedResponseDto dto = new SeedResponseDto();

        dto.setId(seed.getId());
        dto.setVariety(seed.getVariety());
        dto.setSeedRate(seed.getSeedRate());
        dto.setSpacing(seed.getSpacing());
        dto.setGermination(seed.getGermination());
        dto.setApproxCost(seed.getApproxCost());

        return dto;
    }
    private FertilizerResponseDto convertFertilizerToDto(Fertilizer fertilizer) {

        FertilizerResponseDto dto = new FertilizerResponseDto();

        dto.setId(fertilizer.getId());
        dto.setStage(fertilizer.getStage());
        dto.setDayNumber(fertilizer.getDayNumber());
        dto.setFertilizerName(fertilizer.getFertilizerName());
        dto.setQuantity(fertilizer.getQuantity());
        dto.setUnit(fertilizer.getUnit());
        dto.setPurpose(fertilizer.getPurpose());

        return dto;
    }
    private IrrigationResponseDto convertIrrigationToDto(Irrigation irrigation) {

        IrrigationResponseDto dto = new IrrigationResponseDto();

        dto.setId(irrigation.getId());
        dto.setDayNumber(irrigation.getDayNumber());
        dto.setStage(irrigation.getStage());
        dto.setDescription(irrigation.getDescription());

        return dto;
    }
    private DiseaseResponseDto convertDiseaseToDto(Disease disease) {

        DiseaseResponseDto dto = new DiseaseResponseDto();

        dto.setId(disease.getId());
        dto.setDiseaseName(disease.getDiseaseName());
        dto.setSymptoms(disease.getSymptoms());
        dto.setPrevention(disease.getPrevention());
        dto.setMedicine(disease.getMedicine());
        dto.setDosage(disease.getDosage());
        dto.setSprayInterval(disease.getSprayInterval());

        return dto;
    }
    private CalendarActivityResponseDto convertCalendarActivityToDto(CalendarActivity activity) {

        CalendarActivityResponseDto dto = new CalendarActivityResponseDto();

        dto.setId(activity.getId());
        dto.setDayNumber(activity.getDayNumber());
        dto.setActivity(activity.getActivity());
        dto.setDescription(activity.getDescription());

        return dto;
    }
    private CostResponseDto convertCostToDto(Cost cost) {

        CostResponseDto dto = new CostResponseDto();

        dto.setId(cost.getId());
        dto.setState(cost.getState());
        dto.setRegion(cost.getRegion());
        dto.setSeedCost(cost.getSeedCost());
        dto.setFertilizerCost(cost.getFertilizerCost());
        dto.setPesticideCost(cost.getPesticideCost());
        dto.setLabourCost(cost.getLabourCost());
        dto.setIrrigationCost(cost.getIrrigationCost());
        dto.setHarvestingCost(cost.getHarvestingCost());
        dto.setMiscellaneousCost(cost.getMiscellaneousCost());
        dto.setTotalCost(cost.getTotalCost());

        return dto;
    }
    private YieldResponseDto convertYieldToDto(Yield yield) {

        YieldResponseDto dto = new YieldResponseDto();

        dto.setId(yield.getId());
        dto.setState(yield.getState());
        dto.setRegion(yield.getRegion());
        dto.setExpectedYield(yield.getExpectedYield());
        dto.setYieldUnit(yield.getYieldUnit());
        dto.setMarketPrice(yield.getMarketPrice());
        dto.setPriceUnit(yield.getPriceUnit());
        dto.setExpectedIncome(yield.getExpectedIncome());
        dto.setExpectedProfit(yield.getExpectedProfit());

        return dto;
    }

}