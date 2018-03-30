package org.springhibernate.webservices.interfaces;

import java.util.Date;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface IHolidayRequestServices {

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param startDate
     * @param endDate
     * @param name
     * @param empCode
     * @return
     */
    String bookHoliday(Date startDate, Date endDate, String name, String empCode);

}
