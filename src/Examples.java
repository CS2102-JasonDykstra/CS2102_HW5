import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;
import org.junit.Test;


public class Examples {


    LinkedList<Reading> testReadings = new LinkedList<>();
    LinkedList<Reading> testReadingsEmpty = new LinkedList<>();


    DailyWeatherReport testReport1;

    DailyReportList testDailyReportList;
    DailyReportList testDailyReportListEmpty;
    DailyReportList testDailyReportListNegative;
    DailyReportList testDailyReportListJanAndFeb;

    WeatherMonitor testWeatherMonitor;
    WeatherMonitor testWeatherMonitorEmpty;
    WeatherMonitor testWeatherMonitorNegative;
    WeatherMonitor testWeatherMonitorJanAndFeb;

    LinkedList<DailyWeatherReport> testReports = new LinkedList<>();
    LinkedList<DailyWeatherReport> testReportsEmpty = new LinkedList<>();
    LinkedList<DailyWeatherReport> testReportsNegative = new LinkedList<>();
    LinkedList<DailyWeatherReport> testReportJanAndFeb = new LinkedList<>();

    LinkedList<Double> testTempReadings = new LinkedList<>();
    LinkedList<Double> testTempReadingsEmpty = new LinkedList<>();
    LinkedList<Double> testTempReadingsNegative = new LinkedList<>();
    LinkedList<Double> testTempReadingsJan = new LinkedList<>();
    LinkedList<Double> testTempReadingsFeb = new LinkedList<>();

    LinkedList<Double> testRainfallReadings = new LinkedList<>();
    LinkedList<Double> testRainfallReadingsEmpty = new LinkedList<>();
    LinkedList<Double> testRainfallReadingsNegative = new LinkedList<>();
    LinkedList<Double> testRainfallReadingsJan = new LinkedList<>();
    LinkedList<Double> testRainfallReadingsFeb = new LinkedList<>();

    DailyWeatherReport JanFirst = new DailyWeatherReport(new GregorianCalendar(2010, 1, 1), testTempReadingsJan, testRainfallReadingsJan);
    DailyWeatherReport FebFirst = new DailyWeatherReport(new GregorianCalendar(2010, 2, 1), testTempReadingsFeb, testRainfallReadingsFeb);

    public Examples() {
        testTempReadings.add(40.0);
        testTempReadings.add(50.0);
        testTempReadings.add(60.0);

        testTempReadingsNegative.add(-10.0);
        testTempReadingsNegative.add(-20.0);
        testTempReadingsNegative.add(-30.0);

        testTempReadingsJan.add(10.0);
        testTempReadingsJan.add(20.0);

        testTempReadingsFeb.add(100.0);
        testTempReadingsFeb.add(200.0);

        testRainfallReadings.add(1.0);
        testRainfallReadings.add(2.0);
        testRainfallReadings.add(3.0);

        testRainfallReadingsNegative.add(-1.0);

        testRainfallReadingsJan.add(2.0);
        testRainfallReadingsJan.add(4.0);

        testRainfallReadingsFeb.add(20.0);
        testRainfallReadingsFeb.add(40.0);

        testReadings.add(new Reading(new Time(1, 1), 20.0, 3.0));
        testReadings.add(new Reading(new Time(1, 2), 20.0, 3.0));

        testReports.add(new DailyWeatherReport(new GregorianCalendar(2019, 10, 1), testTempReadings, testRainfallReadings));
        testReportsNegative.add(new DailyWeatherReport(new GregorianCalendar(2019, 10, 1), testTempReadingsNegative, testRainfallReadingsNegative));
        testReportJanAndFeb.add(JanFirst);
        testReportJanAndFeb.add(FebFirst);


        testDailyReportList = new DailyReportList(testReports);
        testDailyReportListEmpty = new DailyReportList(testReportsEmpty);
        testDailyReportListNegative = new DailyReportList(testReportsNegative);
        testDailyReportListJanAndFeb = new DailyReportList(testReportJanAndFeb);

        testWeatherMonitor = new WeatherMonitor(testDailyReportList);
        testWeatherMonitorEmpty = new WeatherMonitor(testDailyReportListEmpty);
        testWeatherMonitorNegative = new WeatherMonitor(testDailyReportListNegative);
        testWeatherMonitorJanAndFeb = new WeatherMonitor(testDailyReportListJanAndFeb);
    }

    @Test
    public void testAverageTempForMonth(){
        assertEquals(50.0, testWeatherMonitor.averageTempForMonth(10, 2019), 0.01);
    }

    @Test
    public void testAverageTempForMonthNoData(){
        assertEquals(0.0, testWeatherMonitorEmpty.averageTempForMonth(10, 2019), 0.01);
    }

    @Test
    public void testAverageTempForMonthNegativeValues(){
        assertEquals(-20.0, testWeatherMonitorNegative.averageTempForMonth(10, 2019), 0.01);
    }

    @Test
    public void testAverageTempForRandomMonth(){
        assertEquals(150.0, testWeatherMonitorJanAndFeb.averageTempForMonth(2, 2010), 0.01);
    }

    @Test
    public void testTotalRainfallForMonth(){
        assertEquals(6.0, testWeatherMonitor.totalRainfallForMonth(10, 2019), 0.01);
    }

    @Test
    public void testTotalRainfallForMonthNoData(){
        assertEquals(0.0, testWeatherMonitorEmpty.totalRainfallForMonth(10, 2019), 0.01);
    }

    @Test
    public void testTotalRainfallForMonthNegativeValues(){
        assertEquals(0.0, testWeatherMonitorNegative.totalRainfallForMonth(10, 2019), 0.01);
    }

    @Test
    public void testTotalRainfallForRandomMonth(){
        assertEquals(60.0, testWeatherMonitorJanAndFeb.totalRainfallForMonth(2, 2010), 0.01);
    }

    @Test
    public void testAddDailyReport(){
        testWeatherMonitor.addDailyReport(new GregorianCalendar(2019, 10, 2), testReadings);
        assertEquals(35.0, testWeatherMonitor.averageTempForMonth(10, 2019), 0.01);
    }

    @Test
    public void testAddDailyReportNoData(){
        testWeatherMonitor.addDailyReport(new GregorianCalendar(2019, 10, 2), testReadingsEmpty);
        assertEquals(50.0, testWeatherMonitor.averageTempForMonth(10, 2019), 0.01);
    }

}
