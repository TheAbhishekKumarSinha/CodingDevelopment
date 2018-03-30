package org.springhibernate.webservices.services;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springhibernate.webservices.interfaces.IHolidayRequestServices;

/**
 * @author Abhishek Kumar Sinha
 *
 */

@Service
public class HolidayRequestServices implements IHolidayRequestServices {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springhibernate.webservices.interfaces.IHolidayRequestServices#bookHoliday(java.util.
     * Date, java.util.Date, java.lang.String, java.lang.String)
     */
    @Override
    public String bookHoliday(Date startDate, Date endDate, String name, String empCode) {
        String s = "Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "] and EmpCode " + empCode;
        return s;

    }

}
