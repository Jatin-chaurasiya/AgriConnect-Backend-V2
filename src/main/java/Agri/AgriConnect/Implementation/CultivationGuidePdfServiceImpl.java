package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.CalendarActivityResponseDto;
import Agri.AgriConnect.Dto.CropPlannerResponseDto;
import Agri.AgriConnect.Dto.DiseaseResponseDto;
import Agri.AgriConnect.Dto.FertilizerResponseDto;
import Agri.AgriConnect.Dto.IrrigationResponseDto;
import Agri.AgriConnect.Service.CultivationGuidePdfService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.springframework.stereotype.Service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class CultivationGuidePdfServiceImpl implements CultivationGuidePdfService {

    private static final Color PRIMARY = new Color(34,139,34);
    private static final Color HEADER = new Color(225,235,245);

    private final Font titleFont = new Font(Font.HELVETICA,22,Font.BOLD,Color.WHITE);
    private final Font headingFont = new Font(Font.HELVETICA,15,Font.BOLD,Color.WHITE);
    private final Font labelFont = new Font(Font.HELVETICA,11,Font.BOLD);
    private final Font valueFont = new Font(Font.HELVETICA,11);
    private final Font footerFont = new Font(Font.HELVETICA,10,Font.ITALIC,Color.GRAY);

    @Override
    public byte[] generatePdf(CropPlannerResponseDto dto) {

        try {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            Document document = new Document(PageSize.A4,30,30,30,30);

            PdfWriter.getInstance(document, outputStream);

            document.open();

            addHeader(document);

            addCropInformation(document, dto);

            addFertilizerSchedule(document, dto);

            addIrrigationSchedule(document, dto);

            addDiseaseManagement(document, dto);

            addCalendarActivities(document, dto);

            addFooter(document);

            document.close();

            return outputStream.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException("Unable to Generate Cultivation Guide PDF", e);

        }
    }

    private void addHeader(Document document) throws Exception {

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(PRIMARY);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(15);

        Paragraph title = new Paragraph("AgriConnect", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);

        Paragraph subTitle = new Paragraph(
                "Cultivation Guide",
                new Font(Font.HELVETICA,15,Font.BOLD,Color.WHITE)
        );
        subTitle.setAlignment(Element.ALIGN_CENTER);

        Paragraph date = new Paragraph(
                "Generated On : " +
                        LocalDate.now().format(
                                DateTimeFormatter.ofPattern("dd MMM yyyy")
                        ),
                new Font(Font.HELVETICA,10,Font.NORMAL,Color.WHITE)
        );

        date.setAlignment(Element.ALIGN_CENTER);

        cell.addElement(title);
        cell.addElement(subTitle);
        cell.addElement(date);

        table.addCell(cell);

        document.add(table);
        document.add(Chunk.NEWLINE);
    }

    private void addCropInformation(Document document,
                                    CropPlannerResponseDto dto) throws Exception {

        document.add(createSectionTitle("Crop Information"));

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingAfter(12);

        addRow(table,"Crop Name",dto.getCropName());
        addRow(table,"Scientific Name",dto.getScientificName());
        addRow(table,"Crop Type",dto.getCropType());
        addRow(table,"Season",dto.getSeason());
        addRow(table,"Duration",value(dto.getDurationDays()) + " Days");
        addRow(table,"Temperature",dto.getIdealTemperature());
        addRow(table,"Humidity",dto.getIdealHumidity());
        addRow(table,"Ideal pH",dto.getIdealPh());

        document.add(table);
    }

    private void addFertilizerSchedule(Document document,
                                       CropPlannerResponseDto dto) throws Exception {

        if (dto.getFertilizers() == null || dto.getFertilizers().isEmpty()) {
            return;
        }

        document.add(createSectionTitle("Fertilizer Schedule"));

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setSpacingAfter(12);
        table.setWidths(new float[]{2,2,3,2,1.5f,3});

        addTableHeader(table,"Stage");
        addTableHeader(table,"Day");
        addTableHeader(table,"Fertilizer");
        addTableHeader(table,"Quantity");
        addTableHeader(table,"Unit");
        addTableHeader(table,"Purpose");

        for(FertilizerResponseDto fertilizer : dto.getFertilizers()){

            table.addCell(createTableCell(fertilizer.getStage()));
            table.addCell(createTableCell(value(fertilizer.getDayNumber())));
            table.addCell(createTableCell(fertilizer.getFertilizerName()));
            table.addCell(createTableCell(value(fertilizer.getQuantity())));
            table.addCell(createTableCell(fertilizer.getUnit()));
            table.addCell(createTableCell(fertilizer.getPurpose()));

        }

        document.add(table);

    }

    private void addIrrigationSchedule(Document document,
                                       CropPlannerResponseDto dto) throws Exception {

        if(dto.getIrrigations()==null || dto.getIrrigations().isEmpty()){
            return;
        }

        document.add(createSectionTitle("Irrigation Schedule"));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingAfter(12);
        table.setWidths(new float[]{2,2,6});

        addTableHeader(table,"Day");
        addTableHeader(table,"Stage");
        addTableHeader(table,"Description");

        for(IrrigationResponseDto irrigation : dto.getIrrigations()){

            table.addCell(createTableCell(value(irrigation.getDayNumber())));
            table.addCell(createTableCell(irrigation.getStage()));
            table.addCell(createTableCell(irrigation.getDescription()));

        }

        document.add(table);

    }

    private void addDiseaseManagement(Document document,
                                      CropPlannerResponseDto dto) throws Exception {

        if(dto.getDiseases()==null || dto.getDiseases().isEmpty()){
            return;
        }

        document.add(createSectionTitle("Disease Management"));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingAfter(12);
        table.setWidths(new float[]{2,3,3,2,2});

        addTableHeader(table,"Disease");
        addTableHeader(table,"Symptoms");
        addTableHeader(table,"Prevention");
        addTableHeader(table,"Medicine");
        addTableHeader(table,"Dosage");

        for(DiseaseResponseDto disease : dto.getDiseases()){

            table.addCell(createTableCell(disease.getDiseaseName()));
            table.addCell(createTableCell(disease.getSymptoms()));
            table.addCell(createTableCell(disease.getPrevention()));
            table.addCell(createTableCell(disease.getMedicine()));
            table.addCell(createTableCell(disease.getDosage()));

        }

        document.add(table);

    }

    private void addCalendarActivities(Document document,
                                       CropPlannerResponseDto dto) throws Exception {

        if(dto.getCalendarActivities()==null ||
                dto.getCalendarActivities().isEmpty()){
            return;
        }

        document.add(createSectionTitle("Calendar Activities"));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingAfter(12);
        table.setWidths(new float[]{2,3,6});

        addTableHeader(table,"Day");
        addTableHeader(table,"Activity");
        addTableHeader(table,"Description");

        for(CalendarActivityResponseDto activity
                : dto.getCalendarActivities()){

            table.addCell(
                    createTableCell(value(activity.getDayNumber())));

            table.addCell(
                    createTableCell(activity.getActivity()));

            table.addCell(
                    createTableCell(activity.getDescription()));

        }

        document.add(table);

    }

    private void addFooter(Document document) throws Exception {

        document.add(Chunk.NEWLINE);

        Paragraph footer = new Paragraph(
                "Generated by AgriConnect",
                footerFont);

        footer.setAlignment(Element.ALIGN_CENTER);

        document.add(footer);

    }

    private PdfPTable createSectionTitle(String title){

        PdfPTable table = new PdfPTable(1);

        table.setWidthPercentage(100);

        table.setSpacingBefore(5);

        table.setSpacingAfter(8);

        PdfPCell cell = new PdfPCell(
                new Phrase(title,headingFont));

        cell.setBackgroundColor(PRIMARY);

        cell.setBorder(Rectangle.NO_BORDER);

        cell.setPadding(10);

        table.addCell(cell);

        return table;

    }

    private void addTableHeader(PdfPTable table,
                                String text){

        PdfPCell cell = new PdfPCell(
                new Phrase(text,
                        new Font(Font.HELVETICA,11,Font.BOLD)));

        cell.setBackgroundColor(HEADER);

        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cell.setPadding(8);

        table.addCell(cell);

    }

    private PdfPCell createTableCell(String text){

        PdfPCell cell = new PdfPCell(
                new Phrase(value(text),valueFont));

        cell.setPadding(7);

        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        return cell;

    }

    private void addRow(PdfPTable table,
                        String label,
                        String value){

        PdfPCell labelCell =
                new PdfPCell(new Phrase(label,labelFont));

        labelCell.setBackgroundColor(HEADER);

        labelCell.setPadding(8);

        PdfPCell valueCell =
                new PdfPCell(new Phrase(value(value),valueFont));

        valueCell.setPadding(8);

        table.addCell(labelCell);

        table.addCell(valueCell);

    }

    private String value(Object value){

        return value==null ? "-" : value.toString();

    }

    private String money(Double amount){

        if(amount==null){
            return "-";
        }

        NumberFormat format =
                NumberFormat.getCurrencyInstance(
                        new Locale("en","IN"));

        return format.format(amount);

    }

}