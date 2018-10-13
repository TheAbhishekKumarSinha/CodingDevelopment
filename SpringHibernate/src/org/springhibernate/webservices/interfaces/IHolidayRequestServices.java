package org.springhibernate.webservices.interfaces;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@WebService()
public interface IHolidayRequestServices {

    @WebMethod(operationName = "bookHolidays")
    String bookHoliday(Date startDate, Date endDate, String name, String empCode);

}
