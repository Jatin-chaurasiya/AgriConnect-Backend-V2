package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.*;
import Agri.AgriConnect.Service.CropPlannerPdfService;
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
public class CropPlannerPdfServiceImpl implements CropPlannerPdfService {

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

            PdfWriter.getInstance(document,outputStream);

            document.open();

            addHeader(document);

            addCropInformation(document,dto);

            addFinancialSummary(document,dto);

            addSeedInformation(document,dto);

            addCostBreakdown(document,dto);

            addYieldDetails(document,dto);

            addFooter(document);

            document.close();

            return outputStream.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException("Unable to Generate PDF",e);

        }

    }

    private void addHeader(Document document) throws Exception {

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(PRIMARY);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(15);

        Paragraph title = new Paragraph("AgriConnect",titleFont);
        title.setAlignment(Element.ALIGN_CENTER);

        Paragraph subTitle = new Paragraph("Crop Planner Report",
                new Font(Font.HELVETICA,15,Font.BOLD,Color.WHITE));
        subTitle.setAlignment(Element.ALIGN_CENTER);

        Paragraph date = new Paragraph(
                "Generated On : " +
                        LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy")),
                new Font(Font.HELVETICA,10,Font.NORMAL,Color.WHITE));
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
        addRow(table,"Duration",value(dto.getDurationDays())+" Days");
        addRow(table,"Temperature",dto.getIdealTemperature());
        addRow(table,"Humidity",dto.getIdealHumidity());
        addRow(table,"Rainfall",dto.getRainfall());
        addRow(table,"Ideal pH",dto.getIdealPh());
        addRow(table,"Description",dto.getDescription());

        document.add(table);

    }

    private void addFinancialSummary(Document document,
                                     CropPlannerResponseDto dto) throws Exception {

        document.add(createSectionTitle("Financial Summary"));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingAfter(15);

        table.addCell(createSummaryCell(
                "Estimated Cost",
                money(dto.getEstimatedCost()),
                new Color(255,193,7)));

        table.addCell(createSummaryCell(
                "Expected Income",
                money(dto.getExpectedIncome()),
                new Color(0,188,212)));

        table.addCell(createSummaryCell(
                "Expected Profit",
                money(dto.getExpectedProfit()),
                new Color(76,175,80)));

        document.add(table);

    }

    private PdfPTable createSectionTitle(String title){

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setSpacingBefore(5);
        table.setSpacingAfter(8);

        PdfPCell cell = new PdfPCell(new Phrase(title,headingFont));
        cell.setBackgroundColor(PRIMARY);
        cell.setPadding(10);
        cell.setBorder(Rectangle.NO_BORDER);

        table.addCell(cell);

        return table;

    }

    private PdfPCell createSummaryCell(String title,
                                       String value,
                                       Color color){

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(color);
        cell.setPadding(15);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        Paragraph p1 = new Paragraph(title,
                new Font(Font.HELVETICA,12,Font.BOLD));
        p1.setAlignment(Element.ALIGN_CENTER);

        Paragraph p2 = new Paragraph(value,
                new Font(Font.HELVETICA,18,Font.BOLD));
        p2.setAlignment(Element.ALIGN_CENTER);

        cell.addElement(p1);
        cell.addElement(p2);

        return cell;

    }

    private void addRow(PdfPTable table,
                        String label,
                        String value){

        PdfPCell l = new PdfPCell(new Phrase(label,labelFont));
        l.setBackgroundColor(HEADER);
        l.setPadding(8);

        PdfPCell v = new PdfPCell(new Phrase(value(value),valueFont));
        v.setPadding(8);

        table.addCell(l);
        table.addCell(v);

    }

    private String value(Object value){

        return value==null ? "-" : value.toString();

    }

    private String money(Double amount){

        if(amount==null){
            return "-";
        }

        NumberFormat format =
                NumberFormat.getCurrencyInstance(new Locale("en","IN"));

        return format.format(amount);

    }
    private void addSeedInformation(Document document,
                                    CropPlannerResponseDto dto) throws Exception {

        if(dto.getSeeds()==null || dto.getSeeds().isEmpty()){
            return;
        }

        document.add(createSectionTitle("Seed Information"));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingAfter(12);
        table.setWidths(new float[]{3,2,2,2,2});

        addTableHeader(table,"Variety");
        addTableHeader(table,"Seed Rate");
        addTableHeader(table,"Spacing");
        addTableHeader(table,"Germination");
        addTableHeader(table,"Approx Cost");

        for(SeedResponseDto seed : dto.getSeeds()){

            table.addCell(createTableCell(seed.getVariety()));
            table.addCell(createTableCell(seed.getSeedRate()));
            table.addCell(createTableCell(seed.getSpacing()));
            table.addCell(createTableCell(seed.getGermination()));
            table.addCell(createTableCell(money(seed.getApproxCost())));

        }

        document.add(table);

    }

    private void addCostBreakdown(Document document,
                                  CropPlannerResponseDto dto) throws Exception {

        if(dto.getCosts()==null || dto.getCosts().isEmpty()){
            return;
        }

        document.add(createSectionTitle("Cost Breakdown"));

        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        table.setSpacingAfter(12);
        table.setWidths(new float[]{2,2,2,2,2,2,2,2});

        addTableHeader(table,"Region");
        addTableHeader(table,"Seeds");
        addTableHeader(table,"Fertilizer");
        addTableHeader(table,"Pesticide");
        addTableHeader(table,"Labour");
        addTableHeader(table,"Irrigation");
        addTableHeader(table,"Harvest");
        addTableHeader(table,"Total");

        for(CostResponseDto cost : dto.getCosts()){

            table.addCell(createTableCell(cost.getState()));
            table.addCell(createTableCell(money(cost.getSeedCost())));
            table.addCell(createTableCell(money(cost.getFertilizerCost())));
            table.addCell(createTableCell(money(cost.getPesticideCost())));
            table.addCell(createTableCell(money(cost.getLabourCost())));
            table.addCell(createTableCell(money(cost.getIrrigationCost())));
            table.addCell(createTableCell(money(cost.getHarvestingCost())));
            table.addCell(createTableCell(money(cost.getTotalCost())));

        }

        document.add(table);

    }

    private void addYieldDetails(Document document,
                                 CropPlannerResponseDto dto) throws Exception {

        if(dto.getYields()==null || dto.getYields().isEmpty()){
            return;
        }

        document.add(createSectionTitle("Yield Details"));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingAfter(12);
        table.setWidths(new float[]{2,2,2,2,2});

        addTableHeader(table,"Region");
        addTableHeader(table,"Yield");
        addTableHeader(table,"Market Price");
        addTableHeader(table,"Income");
        addTableHeader(table,"Profit");

        for(YieldResponseDto yield : dto.getYields()){

            table.addCell(createTableCell(yield.getState()));
            table.addCell(createTableCell(
                    value(yield.getExpectedYield())+" "+value(yield.getYieldUnit())));
            table.addCell(createTableCell(money(yield.getMarketPrice())));
            table.addCell(createTableCell(money(yield.getExpectedIncome())));
            table.addCell(createTableCell(money(yield.getExpectedProfit())));

        }

        document.add(table);

    }

    private void addTableHeader(PdfPTable table,
                                String text){

        PdfPCell cell = new PdfPCell(new Phrase(
                text,
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

        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(7);

        return cell;

    }

    private void addFooter(Document document) throws Exception {

        document.add(Chunk.NEWLINE);

        Paragraph footer = new Paragraph(
                "Generated by AgriConnect",
                footerFont);

        footer.setAlignment(Element.ALIGN_CENTER);

        document.add(footer);

    }

}