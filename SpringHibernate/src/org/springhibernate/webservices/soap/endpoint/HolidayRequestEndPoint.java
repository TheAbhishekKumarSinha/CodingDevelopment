package org.springhibernate.webservices.soap.endpoint;

public class HolidayRequestEndPoint {
    /*
     * 
     * private IHolidayRequestServices holidayServices;
     * 
     * private static final String SERVICE_PATH_URL =
     * "http://www.example.org/HolidayRequestWebService"; private XPath startDateXpath;
     * 
     * private XPath endDateXpath; private XPath firstNameXpath; private XPath lastNameXpath;
     * private XPath empCodeXpath;
     * 
     * @Autowired public HolidayRequestEndPoint(IHolidayRequestServices holidayServices) throws
     * JDOMException { this.holidayServices = holidayServices; Namespace namespace =
     * Namespace.getNamespace("hr", SERVICE_PATH_URL);
     * 
     * startDateXpath = XPath.newInstance("//hr:startDate"); startDateXpath.addNamespace(namespace);
     * 
     * endDateXpath = XPath.newInstance("//hr:endDate"); endDateXpath.addNamespace(namespace);
     * 
     * firstNameXpath = XPath.newInstance("//hr:empFirstName");
     * firstNameXpath.addNamespace(namespace);
     * 
     * lastNameXpath = XPath.newInstance("//hr:empLastName"); lastNameXpath.addNamespace(namespace);
     * 
     * empCodeXpath = XPath.newInstance("//hr:empCode"); empCodeXpath.addNamespace(namespace);
     * 
     * }
     * 
     * @PayloadRoot(namespace = SERVICE_PATH_URL, localPart = "HolidayRequest")
     * 
     * @ResponseBody public String handleHolidayRequest(@RequestPayload Element holidayRequest)
     * throws ParseException, JDOMException {
     * 
     * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); Date startDate =
     * dateFormat.parse(startDateXpath.valueOf(holidayRequest)); Date endDate =
     * dateFormat.parse(endDateXpath.valueOf(holidayRequest)); String firstName =
     * firstNameXpath.valueOf(holidayRequest); String lastName =
     * lastNameXpath.valueOf(holidayRequest); String empCode = empCodeXpath.valueOf(holidayRequest);
     * String name = firstName + " " + lastName; return this.holidayServices.bookHoliday(startDate,
     * endDate, name, empCode); }
     * 
     */}
