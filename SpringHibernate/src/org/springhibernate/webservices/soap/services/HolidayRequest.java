package org.springhibernate.webservices.soap.services;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springhibernate.webservices.soap.interfaces.IHolidayRequestServices;

/**
 * @author Abhishek Kumar Sinha
 *
 */

@WebService(endpointInterface = "org.springhibernate.webservices.soap.interfaces.IHolidayRequestServices", serviceName = "BookHolidays")
public class HolidayRequest implements IHolidayRequestServices {

    @Override
    @WebMethod
    public String bookHoliday(Date startDate, Date endDate, String name, String empCode) {
        String s = "Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "] and EmpCode " + empCode
                + " has been approved";
        return s;

    }

}
